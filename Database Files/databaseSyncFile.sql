CREATE DATABASE  IF NOT EXISTS `hospital_management_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hospital_management_db`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital_management_db
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `doctor` (
  `Speciality` varchar(100) DEFAULT NULL,
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Speciality_idx` (`Speciality`),
  CONSTRAINT `ID` FOREIGN KEY (`ID`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('Heart Specialist',25);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `room` (
  `Name` varchar(10) NOT NULL,
  `Directions` varchar(300) DEFAULT NULL,
  `speciality` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Name`),
  KEY `Speciality_idx` (`speciality`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES ('ENT','2nd floor , 1st right','Ears Nose And Throat Specialist'),('EYE','2nd Floor 1st left','Eye Specialist'),('GENERAL1','1st Foor 1st left','General'),('GENERAL2','1st floor 2nd Left','General'),('GENERAL3','1st floor 1st right','General'),('GYNOCOLOGY','3rd floor , 2nd Left ','Gynaecologist'),('HEART','3rd floor','Heart Specialist');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timeslot`
--

DROP TABLE IF EXISTS `timeslot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `timeslot` (
  `Start` time NOT NULL,
  `End` time DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(45) DEFAULT NULL,
  `Room` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `room_idx` (`Room`),
  CONSTRAINT `room` FOREIGN KEY (`Room`) REFERENCES `room` (`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timeslot`
--

LOCK TABLES `timeslot` WRITE;
/*!40000 ALTER TABLE `timeslot` DISABLE KEYS */;
INSERT INTO `timeslot` VALUES ('09:00:00','11:00:00',1,NULL,'GENERAL1'),('11:00:00','13:00:00',2,NULL,'GENERAL1'),('13:00:00','15:00:00',3,NULL,'GENERAL1'),('17:00:00','19:00:00',4,NULL,'GENERAL1'),('19:00:00','21:00:00',5,NULL,'GENERAL1'),('09:00:00','11:00:00',6,NULL,'GENERAL2'),('11:00:00','13:00:00',7,NULL,'GENERAL2'),('13:00:00','15:00:00',8,NULL,'GENERAL2'),('17:00:00','19:00:00',9,NULL,'GENERAL2'),('19:00:00','21:00:00',10,NULL,'GENERAL2'),('09:00:00','12:00:00',11,NULL,'EYE'),('12:00:00','15:00:00',12,NULL,'EYE'),('15:00:00','18:00:00',13,NULL,'EYE'),('18:00:00','21:00:00',14,NULL,'EYE'),('09:30:00','11:30:00',15,NULL,'ENT'),('11:30:00','13:30:00',16,NULL,'ENT'),('09:00:00','11:30:00',17,NULL,'HEART'),('12:00:00','14:30:00',18,NULL,'HEART'),('18:00:00','21:30:00',19,NULL,'HEART');
/*!40000 ALTER TABLE `timeslot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) DEFAULT NULL,
  `NIC` varchar(10) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `recoveryEmail` varchar(100) DEFAULT NULL,
  `Phone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (25,'Dre','973291900V','dres home','dre@gmail.com','ÑŠ·�ýÙ† ¾Š\"Qùy5','Doctor','recoverydre@gmail.com','0764619900');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work`
--

DROP TABLE IF EXISTS `work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `work` (
  `doctor` int(11) NOT NULL,
  `date` date NOT NULL,
  `appointmentLimit` int(11) DEFAULT NULL,
  `ArrivalTime` datetime DEFAULT NULL,
  `AllocatedTimePerSession` int(11) DEFAULT NULL,
  `timeSlot` int(11) NOT NULL,
  PRIMARY KEY (`doctor`,`timeSlot`,`date`),
  KEY `timeslot_idx` (`timeSlot`),
  CONSTRAINT `doctor` FOREIGN KEY (`doctor`) REFERENCES `doctor` (`ID`),
  CONSTRAINT `timeslot` FOREIGN KEY (`timeSlot`) REFERENCES `timeslot` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work`
--

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hospital_management_db'
--

--
-- Dumping routines for database 'hospital_management_db'
--
/*!50003 DROP PROCEDURE IF EXISTS `GetALLFreeTimeSlots` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetALLFreeTimeSlots`(

	IN p_speciality varchar(100),
    IN p_appointed_date DATE
    
    
)
BEGIN
	SELECT t.id , r.Name , t.start , t.end
	FROM timeslot t, room r
	WHERE t.room = r.Name
	AND speciality = p_speciality
	AND ID NOT IN 
	(
		SELECT timeSlot
		FROM work w,timeslot t, room r
		WHERE w.timeslot = t.ID
		AND t.room = r.Name
		AND r.speciality = p_speciality
		AND date = p_appointed_date
	);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-28 16:02:32
