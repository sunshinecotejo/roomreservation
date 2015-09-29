<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- HTML -->
<!DOCTYPE html>
<html>
	<head>
		<title>Meeting Room Reservation</title>
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
		<link  rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet/less" type="text/css" href="${pageContext.request.contextPath}/resources/less/quicktmpl.less">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/meetingroom.css">
  		<script src="http://code.jquery.com/jquery-1.10.2.js"></script> 
	    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
	<body>
		<nav class="navbar navbar-inverse">
	  		<ul class="nav navbar-nav">
	            <li class="active"><a href="#">Home</a></li>
	            <li class="dropdown">
			          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage<span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="#">Add Room</a></li>
			            <li><a href="#">View Schedule</a></li>
			          </ul>
			    </li>
	         </ul>
	         <ul class="nav navbar-nav navbar-right">
        	<li><a href="#"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
        	</ul>
		</nav>
				<%@include file="createReservation.jsp" %>
				<div id="reservation-panel">
					<label class="control-label" for="inputReservation">Change Calendar</label>
					<div class="btn-group" id="changeCalendarByRoom">
		  				<button type="button" class="btn btn-default">All Reservations</button>
		  				<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    				<span class="caret"></span>
		    				<span class="sr-only">Toggle Dropdown</span>
		  				</button>
		  				
		  				<ul class="dropdown-menu">
		  					<li><a href="#" class="room-attr">All Reservations</a></li>
		  					<c:if test="${!empty roomList}"> 
		  					<c:forEach var="room" items="${roomList}"  varStatus="loop">
		    					<li><a href="#" id="room-${loop.index}" class="room-attr">${room.roomName}</a></li>
		    					
		    				</c:forEach>
		    				</c:if> 
		  				</ul>
		  				
					</div>
			</div>
		
		<div id="template">
	
			<div class="container theme-showcase">
				 <h1>Calendar</h1>
				<div id="holder" class="row" ></div>
			</div>
	
		<script type="text/tmpl" id="tmpl">
 {{ 
  var date = date || new Date(),
      month = date.getMonth(), 
      year = date.getFullYear(), 
      first = new Date(year, month, 1), 
      last = new Date(year, month + 1, 0),
      startingDay = first.getDay(), 
      thedate = new Date(year, month, 1 - startingDay),
      dayclass = lastmonthcss,
      today = new Date(),
      i, j; 
  if (mode === 'week') {
    thedate = new Date(date);
    thedate.setDate(date.getDate() - date.getDay());
    first = new Date(thedate);
    last = new Date(thedate);
    last.setDate(last.getDate()+6);
  } else if (mode === 'day') {
    thedate = new Date(date);
    first = new Date(thedate);
    last = new Date(thedate);
    last.setDate(thedate.getDate() + 1);
  }
  
  }}
  <table class="calendar-table table table-condensed table-tight">
    <thead>
      <tr>
        <td colspan="7" style="text-align: center">
          <table style="white-space: nowrap; width: 100%">
            <tr>
              <td style="text-align: left;">
                <span class="btn-group">
                  <button class="js-cal-prev btn btn-default">&lt;</button>
                  <button class="js-cal-next btn btn-default">&gt;</button>
                </span>
                <button class="js-cal-option btn btn-default {{: first.toDateInt() <= today.toDateInt() && today.toDateInt() <= last.toDateInt() ? 'active':'' }}" data-date="{{: today.toISOString()}}" data-mode="month">{{: todayname }}</button>
              </td>
              <td>
                <span class="btn-group btn-group-lg">
                  {{ if (mode !== 'day') { }}
                    {{ if (mode === 'month') { }}<button class="js-cal-option btn btn-link" data-mode="year">{{: months[month] }}</button>{{ } }}
                    {{ if (mode ==='week') { }}
                      <button class="btn btn-link disabled">{{: shortMonths[first.getMonth()] }} {{: first.getDate() }} - {{: shortMonths[last.getMonth()] }} {{: last.getDate() }}</button>
                    {{ } }}
                    <button class="js-cal-years btn btn-link">{{: year}}</button> 
                  {{ } else { }}
                    <button class="btn btn-link disabled">{{: date.toDateString() }}</button> 
                  {{ } }}
                </span>
              </td>
              <td style="text-align: right">
                <span class="btn-group">
                  <button class="js-cal-option btn btn-default {{: mode==='year'? 'active':'' }}" data-mode="year">Year</button>
                  <button class="js-cal-option btn btn-default {{: mode==='month'? 'active':'' }}" data-mode="month">Month</button>
                  <button class="js-cal-option btn btn-default {{: mode==='week'? 'active':'' }}" data-mode="week">Week</button>
                  <button class="js-cal-option btn btn-default {{: mode==='day'? 'active':'' }}" data-mode="day">Day</button>
                </span>
              </td>
            </tr>
          </table>
          
        </td>
      </tr>
    </thead>
    {{ if (mode ==='year') {
      month = 0;
    }}
    <tbody>
      {{ for (j = 0; j < 3; j++) { }}
      <tr>
        {{ for (i = 0; i < 4; i++) { }}
        <td class="calendar-month month-{{:month}} js-cal-option" data-date="{{: new Date(year, month, 1).toISOString() }}" data-mode="month">
          {{: months[month] }}
          {{ month++;}}
        </td>
        {{ } }}
      </tr>
      {{ } }}
    </tbody>
    {{ } }}
    {{ if (mode ==='month' || mode ==='week') { }}
    <thead>
      <tr class="c-weeks">
        {{ for (i = 0; i < 7; i++) { }}
          <th class="c-name">
            {{: days[i] }}
          </th>
        {{ } }}
      </tr>
    </thead>
    <tbody>
      {{ for (j = 0; j < 6 && (j < 1 || mode === 'month'); j++) { }}
      <tr>
        {{ for (i = 0; i < 7; i++) { }}
        {{ if (thedate > last) { dayclass = nextmonthcss; } else if (thedate >= first) { dayclass = thismonthcss; } }}
        <td class="calendar-day {{: dayclass }} {{: thedate.toDateCssClass() }} {{: date.toDateCssClass() === thedate.toDateCssClass() ? 'selected':'' }} {{: daycss[i] }} js-cal-option" data-date="{{: thedate.toISOString() }}">
          <div class="date">{{: thedate.getDate() }}</div>
          {{ thedate.setDate(thedate.getDate() + 1);}}
        </td>
        {{ } }}
      </tr>
      {{ } }}
    </tbody>
    {{ } }}
    {{ if (mode ==='day') { }}
    <tbody>
      <tr>
        <td colspan="7">
          <table class="table table-striped table-condensed table-tight-vert" >
            <thead>
              <tr>
                <th>&nbsp;</th>
                <th style="text-align: center; width: 100%">{{: days[date.getDay()] }}</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th class="timetitle" >All Day</th>
                <td class="{{: date.toDateCssClass() }}">  </td>
              </tr>
              <tr>
                <th class="timetitle" >Before 6 AM</th>
                <td class="time-0-0"> </td>
              </tr>
              {{for (i = 6; i < 22; i++) { }}
              <tr>
                <th class="timetitle" >{{: i <= 12 ? i : i - 12 }}:00 {{: i < 12 ? "AM" : "PM"}}</th>
                <td class="time-{{: i}}-0"> </td>
              </tr>
              <tr>
                <th class="timetitle" >{{: i <= 12 ? i : i - 12 }}:30 {{: i < 12 ? "AM" : "PM"}}</th>
                <td class="time-{{: i}}-30"> </td>
              </tr>
              {{ } }}
              <tr>
                <th class="timetitle" >After 10 PM</th>
                <td class="time-22-0"> </td>
              </tr>
            </tbody>
          </table>
        </td>
      </tr>
    </tbody>
    {{ } }}
  </table>
	</script>
		
	
	
	</div>

	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/less.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/quicktmpl.js"></script>
	 <script type="text/javascript"  src="${pageContext.request.contextPath}/resources/js/meetingroom.js"> </script>
	 <script type="text/javascript" >

	 	var storedData = new Array();
		//Real time data start
		(function ($) {
		
			$.ajax({
				type: "GET",
				//url : "http://localhost:8081/roomreservation-webservice-0.0.1-SNAPSHOT/reservationmgt/",
				//url : "http://localhost:8082/roomreservation-webapp-0.0.1-SNAPSHOT/resources/json/reservation.json",
				url: "http://localhost:8080/roomreservation-webapp/resources/json/reservation.json",
				dataType: "json",
				contentType: "application/json; charset=utf-8",
				success: function(xdata) {
					var newData = new Array();
					
					$.each(xdata, function(i,reservation){
						var currentDateTime = new Date();
						var mEpoch = parseInt(reservation.reservationSchedule); 
						if(mEpoch<10000000000) 
							mEpoch *= 1000; 

						currentDateTime.setTime(mEpoch);
						
						var end = null;
			
						newData.push({ title: reservation.title, start: currentDateTime, end: end, allDay: !(reservation.duration < 480), text: reservation.description, room : reservation.room.roomName   });
					});
					  newData.sort(function(a,b) { return (+a.start) - (+b.start); });
	
						storedData = newData;
						$('#holder').calendar({
						  data: newData
						});
						
				},
				error: function(xhr, status, error) {
					alert(xhr.status);
				}
			});
	})(jQuery);

	//Real time data end
		
	//Dummy data start

	/**
		var data = [],
	    date = new Date(),
	    d = date.getDate(),
	    d1 = d,
	    m = date.getMonth(),
	    y = date.getFullYear(),
	    i,
	    end, 
	    j, 
	    c = 1063, 
	    c1 = 3329,
	    h, 
	    m,
	    names = ['All Day Event', 'Long Event', 'Birthday Party', 'Repeating Event', 'Training', 'Meeting', 'Mr. Behnke', 'Date', 'Ms. Tubbs'],
	    //slipsum = ['text1', 'text2', 'text3', 'text4', 'text5', 'text6', 'text7', 'text8', 'text9'],
	    rooms = ['Camotes', 'Malapascua', 'Moalboal', 'Panglao'];
	    slipsum = ["Now that we know who you are, I know who I am. I'm not a mistake! It all makes sense! In a comic, you know how you can tell who the arch-villain's going to be? He's the exact opposite of the hero. And most times they're friends, like you and me! I should've known way back when... You know why, David? Because of the kids. They called me Mr Glass.", "You see? It's curious. Ted did figure it out - time travel. And when we get back, we gonna tell everyone. How it's possible, how it's done, what the dangers are. But then why fifty years in the future when the spacecraft encounters a black hole does the computer call it an 'unknown entry event'? Why don't they know? If they don't know, that means we never told anyone. And if we never told anyone it means we never made it back. Hence we die down here. Just as a matter of deductive logic.", "Your bones don't break, mine do. That's clear. Your cells react to bacteria and viruses differently than mine. You don't get sick, I do. That's also clear. But for some reason, you and I react the exact same way to water. We swallow it too fast, we choke. We get some in our lungs, we drown. However unreal it may seem, we are connected, you and I. We're on the same curve, just on opposite ends.", "Well, the way they make shows is, they make one show. That show's called a pilot. Then they show that show to the people who make shows, and on the strength of that one show they decide if they're going to make more shows. Some pilots get picked and become television programs. Some don't, become nothing. She starred in one of the ones that became nothing.", "Yeah, I like animals better than people sometimes... Especially dogs. Dogs are the best. Every time you come home, they act like they haven't seen you in a year. And the good thing about dogs... is they got different dogs for different people. Like pit bulls. The dog of dogs. Pit bull can be the right man's best friend... or the wrong man's worst enemy. You going to give me a dog for a pet, give me a pit bull. Give me... Raoul. Right, Omar? Give me Raoul.", "Like you, I used to think the world was this great place where everybody lived by the same standards I did, then some kid with a nail showed me I was living in his world, a world where chaos rules not order, a world where righteousness is not rewarded. That's Cesar's world, and if you're not willing to play by his rules, then you're gonna have to pay the price.", "You think water moves fast? You should see ice. It moves like it has a mind. Like it knows it killed the world once and got a taste for murder. After the avalanche, it took us a week to climb out. Now, I don't know exactly when we turned on each other, but I know that seven of us survived the slide... and only five made it out. Now we took an oath, that I'm breaking now. We said we'd say it was the snow that killed the other two, but it wasn't. Nature is lethal but it doesn't hold a candle to man.", "You see? It's curious. Ted did figure it out - time travel. And when we get back, we gonna tell everyone. How it's possible, how it's done, what the dangers are. But then why fifty years in the future when the spacecraft encounters a black hole does the computer call it an 'unknown entry event'? Why don't they know? If they don't know, that means we never told anyone. And if we never told anyone it means we never made it back. Hence we die down here. Just as a matter of deductive logic.", "Like you, I used to think the world was this great place where everybody lived by the same standards I did, then some kid with a nail showed me I was living in his world, a world where chaos rules not order, a world where righteousness is not rewarded. That's Cesar's world, and if you're not willing to play by his rules, then you're gonna have to pay the price.", "You think water moves fast? You should see ice. It moves like it has a mind. Like it knows it killed the world once and got a taste for murder. After the avalanche, it took us a week to climb out. Now, I don't know exactly when we turned on each other, but I know that seven of us survived the slide... and only five made it out. Now we took an oath, that I'm breaking now. We said we'd say it was the snow that killed the other two, but it wasn't. Nature is lethal but it doesn't hold a candle to man."];
		  for(i = 0; i < 500; i++) {
			    j = Math.max(i % 15 - 10, 0);
			    //c and c1 jump around to provide an illusion of random data
			    c = (c * 1063) % 1061; 
			    c1 = (c1 * 3329) % 3331;
			    d = (d1 + c + c1) % 839 - 440;
			    h = i % 36;
			    m = (i % 4) * 15;
			    if (h < 18) { h = 0; m = 0; } else { h = Math.max(h - 24, 0) + 8; }
			    end = !j ? null : new Date(y, m, d + j, h + 2, m);
			   
			    data.push({ title: names[c1 % names.length], start: new Date(y, m, d, h, m), end: end, allDay: !(i % 6), text: slipsum[c % slipsum.length ], room : rooms[c % rooms.length ]   });
			  }
			  
			  data.sort(function(a,b) { return (+a.start) - (+b.start); });
	  
			  //data must be sorted by start date

			  //Actually do everything
			  $('#holder').calendar({
				  data: data
			  });
			  **/

		//Dummy data end	  
	
				
				 $(document).ready(function(){
					 $('a.room-attr').on('click', function () {
					        
					        var newArr = new Array();
					 		var selectedRoom = $(this).text();

					 		for (var a in storedData){
						 		var room = storedData[a].room;
							
						 		if(selectedRoom == room){
									newArr.push(storedData[a]);
							 	}else	if(selectedRoom == "All Reservations"){
									newArr = storedData;
							 	}
						 	}

						 	

					 		
							  $('#holder').calendar({
								  data: newArr
							  }); 

							  $('#changeCalendarByRoom .btn:first-child').text($(this).text());
						      $('#changeCalendarByRoom .btn:first-child').val($(this).text());
					    }); 
					});
	 </script>

	</body>
</html>