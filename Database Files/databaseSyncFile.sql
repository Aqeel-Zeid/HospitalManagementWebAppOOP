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
  `Speciality` varchar(100) NOT NULL,
  `ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Speciality`),
  KEY `Speciality_idx` (`ID`),
  CONSTRAINT `Speciality` FOREIGN KEY (`ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('Cardio',2),('Eye Specialist',14),('Ears Nose And Throat Specialist',15),('General',16);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Aqeel Zeid','973291963V','304/1,muruthagahamula,Gelioya','aqeelaqeelzeid@gmail.com','Aqeel_2563',NULL,NULL,NULL),(2,'Amaani Zeid','983291963V','304/1,Buwelikada Road,Gelioya','amaanizeid@gmail.com','Amaani_2563',NULL,NULL,NULL),(3,'Amaani Zeid','983291963V','304/1,Buwelikada Road,Gelioya','amaanizeid@gmail.com','Amaani_2563',NULL,NULL,NULL),(4,'name','NIC','Address','email','password','Pharmacist','recovery','Phone'),(5,'Jamers','Earl','Addressss','james email','password','Doctor','recovery@','073'),(6,'Karl','NIC','Address','email','password','Doctor','drogon2','Phone'),(7,'Karl','45678','Address','email','password','Doctor','drogon2','Phone'),(8,'Karl','4567856','Address','email','password','Doctor','drogon2','Phone'),(9,'Nisal','987654567','Address','email','password','Doctor','recovery','Phone'),(10,'Zimwambe','456734524','Address','email@em','password','Doctor','recovery@','Phone'),(11,'Karls','456722222','Address','email','password','Doctor','recovery','Phone'),(12,'klis','973291864V','Address','email','password','Doctor','recovery','Phone'),(13,'caas','973291963V','Address','email','password','Doctor','recovery','Phone'),(14,'name898','973291964V','Address','email','password','Doctor','recovery','Phone'),(15,'Dr Nose','78675645','2323','email','password','Doctor','recovery','Phone'),(16,'Normal Doc','456732','2323','email','password','Doctor','recovery','Phone'),(17,'name23','2345','2323','email','password','Doctor','recovery','Phone');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hospital_management_db'
--

--
-- Dumping routines for database 'hospital_management_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-26 15:48:42
