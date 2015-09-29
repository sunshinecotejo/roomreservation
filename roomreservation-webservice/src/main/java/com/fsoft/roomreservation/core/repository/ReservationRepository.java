package com.fsoft.roomreservation.core.repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.roomreservation.core.model.Reservation;
import com.fsoft.roomreservation.core.util.CommonUtil;
import com.fsoft.roomreservation.core.util.DateUtil;

@Repository("reservationRepository")
@Transactional
public class ReservationRepository extends AbstractRepository<Reservation> {

	@Override
	protected Class<?> getPersistentClass() {
		return Reservation.class;
	}

	@Transactional
	@Override
	public List<Reservation> getList() {
		List<Reservation> list = super.getList();
		for (Reservation reservation : list) {
			Hibernate.initialize(reservation.getRoom());
			Hibernate.initialize(reservation.getRoom().getFloor());
			Hibernate.initialize(reservation.getUser());
			Hibernate.initialize(reservation.getUser().getRoles());
		}

		return list;
	}

	@Transactional
	@Override
	public Reservation read(Integer id) {
		Reservation reservation = super.read(id);
		Hibernate.initialize(reservation.getRoom());
		Hibernate.initialize(reservation.getRoom().getFloor());
		Hibernate.initialize(reservation.getUser());
		Hibernate.initialize(reservation.getUser().getRoles());

		return reservation;
	}

	@Override
	public Reservation create(Reservation reservation) throws Exception {
		Reservation r = getExistingReservationByRoom(reservation);
		if (r != null) {
			throw new Exception("Schedule Is No Longer Available.");
		}

		return super.create(reservation);
	}

	@Override
	public Reservation update(Reservation Reservation) throws Exception {
		return super.update(Reservation);
	}

	@Override
	public void delete(Integer id) throws Exception {
		super.delete(id);
	}

	@Transactional
	private Reservation getExistingReservationByRoom(Reservation reservation) throws Exception {
		if (CommonUtil.isNull(reservation.getRoom(), reservation.getRoom().getRoomId())) {
			throw new Exception("Room or Room id cannot be null.");
		}

		Integer roomid = reservation.getRoom().getRoomId();
		Date schedule = reservation.getReservationSchedule();
		String start_time = DateUtil.getDate(schedule, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

		Session session = null;
		Reservation exist = null;
		try {
			session = getSessionFactory().openSession();
			exist = (Reservation) session.createCriteria(getPersistentClass())
										.add(Restrictions.eq("roomId", roomid))
										.add(Restrictions.sqlRestriction(
												new StringBuilder()
													.append(" ( '")
													.append(start_time)
													.append("' ")
													.append(" 	BETWEEN ")
													.append("	reservationschedule AND ")
													.append(" 	DATE_ADD(reservationSchedule,INTERVAL duration MINUTE) ) ")
													.append(" LIMIT 1 ").toString()))
										.uniqueResult();
		} finally {
			CommonUtil.closeQuitely(session);
		}
		
		return exist;
	}

}
