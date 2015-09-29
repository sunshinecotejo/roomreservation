-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2015 at 08:36 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `meetingroom`
--

-- --------------------------------------------------------

--
-- Table structure for table `building`
--

CREATE TABLE IF NOT EXISTS `building` (
  `buildingid` int(11) NOT NULL,
  `buildingname` varchar(20) DEFAULT NULL,
  `buildingAddress` varchar(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `building`
--

INSERT INTO `building` (`buildingid`, `buildingname`, `buildingAddress`) VALUES
(1, 'Ebloc3', 'IT Park');

-- --------------------------------------------------------

--
-- Table structure for table `facility`
--

CREATE TABLE IF NOT EXISTS `facility` (
  `facilityId` int(11) NOT NULL,
  `facilityName` varchar(40) DEFAULT NULL,
  `serial` varchar(30) NOT NULL,
  `description` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facility`
--

INSERT INTO `facility` (`facilityId`, `facilityName`, `serial`, `description`) VALUES
(1, 'projector', 'a2lkj213na42sdf12', 'a projector'),
(2, 'chair', '', 'chair ');

-- --------------------------------------------------------

--
-- Table structure for table `floor`
--

CREATE TABLE IF NOT EXISTS `floor` (
  `floorid` int(11) NOT NULL,
  `buildingid` int(11) NOT NULL,
  `floorNumber` int(11) DEFAULT NULL,
  `floorName` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `floor`
--

INSERT INTO `floor` (`floorid`, `buildingid`, `floorNumber`, `floorName`) VALUES
(1, 1, 2, 'level 1');

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `reservationID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `roomID` int(11) NOT NULL,
  `reservationSchedule` datetime DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `title` varchar(30) NOT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`reservationID`, `userID`, `roomID`, `reservationSchedule`, `duration`, `title`, `description`) VALUES
(1, 1, 1, '2015-06-23 06:41:17', 30, '', ''),
(2, 1, 1, '2015-06-24 22:30:07', 2, 'adsfasfd', 'asdfsadf'),
(3, 1, 1, '2015-06-09 07:00:00', 123123, 'asdfasdsa', 'fasdfsa'),
(4, 1, 1, '2015-06-03 08:00:00', 12, 'asdfasdfasd', 'fasfsafsfsafsdf');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `roleID` int(11) NOT NULL,
  `roleName` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`roleID`, `roleName`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE IF NOT EXISTS `room` (
  `roomid` int(11) NOT NULL,
  `floorid` int(11) NOT NULL,
  `roomname` varchar(20) DEFAULT NULL,
  `roomcapacity` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`roomid`, `floorid`, `roomname`, `roomcapacity`) VALUES
(1, 1, 'Narnia', 2),
(2, 1, 'Minas Tirith', 4);

-- --------------------------------------------------------

--
-- Table structure for table `room_facility`
--

CREATE TABLE IF NOT EXISTS `room_facility` (
  `room_facilityId` int(11) NOT NULL,
  `roomId` int(11) NOT NULL,
  `facilityId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_facility`
--

INSERT INTO `room_facility` (`room_facilityId`, `roomId`, `facilityId`, `quantity`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userID` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `email`, `password`, `firstName`, `lastName`) VALUES
(1, 'resty.artiaga@gmail.com', 'hibernate', 'Resty Louis', 'Artiaga'),
(2, 'john', 'doe', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `userID` int(11) NOT NULL,
  `roleID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`userID`, `roleID`) VALUES
(1, 1),
(2, 1),
(2, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `building`
--
ALTER TABLE `building`
  ADD PRIMARY KEY (`buildingid`);

--
-- Indexes for table `facility`
--
ALTER TABLE `facility`
  ADD PRIMARY KEY (`facilityId`);

--
-- Indexes for table `floor`
--
ALTER TABLE `floor`
  ADD PRIMARY KEY (`floorid`), ADD KEY `FK_floor_bldg` (`buildingid`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`reservationID`), ADD KEY `FK_reservation_user` (`userID`), ADD KEY `FK_reservation_room` (`roomID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`roleID`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`roomid`), ADD KEY `FK_room_floor` (`floorid`);

--
-- Indexes for table `room_facility`
--
ALTER TABLE `room_facility`
  ADD PRIMARY KEY (`room_facilityId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`userID`,`roleID`), ADD KEY `FK_user_role_r` (`roleID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `building`
--
ALTER TABLE `building`
  MODIFY `buildingid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `facility`
--
ALTER TABLE `facility`
  MODIFY `facilityId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `floor`
--
ALTER TABLE `floor`
  MODIFY `floorid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `reservationID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `roleID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `roomid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `room_facility`
--
ALTER TABLE `room_facility`
  MODIFY `room_facilityId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `floor`
--
ALTER TABLE `floor`
ADD CONSTRAINT `FK_floor_bldg` FOREIGN KEY (`buildingid`) REFERENCES `building` (`buildingid`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
ADD CONSTRAINT `FK_reservation_room` FOREIGN KEY (`roomID`) REFERENCES `room` (`roomid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_reservation_user` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `room`
--
ALTER TABLE `room`
ADD CONSTRAINT `FK_room_floor` FOREIGN KEY (`floorid`) REFERENCES `floor` (`floorid`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
ADD CONSTRAINT `FK_user_role_r` FOREIGN KEY (`roleID`) REFERENCES `role` (`roleID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_user_role_u` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
