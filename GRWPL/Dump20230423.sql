-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: library
-- ------------------------------------------------------
-- Server version	5.5.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book_details`
--

DROP TABLE IF EXISTS `book_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_details` (
  `book_id` varchar(10) NOT NULL,
  `book_name` varchar(200) NOT NULL,
  `book_author` varchar(100) NOT NULL,
  `book_edition` varchar(10) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `added_date` date NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_details`
--

LOCK TABLES `book_details` WRITE;
/*!40000 ALTER TABLE `book_details` DISABLE KEYS */;
INSERT INTO `book_details` VALUES ('Bk00001','ghjhg','jbknk','kjnkjn','Computer Science',13,'2002-02-12'),('Bk00002','hdgsugf','dkjshfij','sdf','Computer Science',42,'2022-04-09'),('Bk00003','sdad','sda','sda','Select',33,'2022-04-09'),('Bk00004','csdcs','sdsdf','dfsf','Select',16,'2022-04-09'),('Bk00005','asd','asd','asd','Computer Science',120,'2022-04-09'),('Bk00006','k4jrh4i35hf','4t45','4545','Computer Science',12,'2022-05-04');
/*!40000 ALTER TABLE `book_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issuebook`
--

DROP TABLE IF EXISTS `issuebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issuebook` (
  `enroll` varchar(15) NOT NULL,
  `issuedbook1` varchar(10) DEFAULT NULL,
  `date1` date DEFAULT NULL,
  `due_date1` date DEFAULT NULL,
  `action1` varchar(10) DEFAULT NULL,
  `issuedbook2` varchar(10) DEFAULT NULL,
  `date2` date DEFAULT NULL,
  `due_date2` date DEFAULT NULL,
  `action2` varchar(10) DEFAULT NULL,
  `due` int(11) DEFAULT NULL,
  PRIMARY KEY (`enroll`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issuebook`
--

LOCK TABLES `issuebook` WRITE;
/*!40000 ALTER TABLE `issuebook` DISABLE KEYS */;
INSERT INTO `issuebook` VALUES ('123','Bk00004','2022-05-01',NULL,'return',NULL,NULL,NULL,NULL,91332076),('123456','Bk00001','2022-05-01',NULL,'return','Bk00001','2022-04-15',NULL,'issued',0),('123456123','Bk00001','2022-05-04','2022-05-11','issued',NULL,NULL,NULL,NULL,0),('123456n','Bk00004','2022-04-15',NULL,'issued','Bk00005','2022-05-01',NULL,'return',0),('147258369','Bk00001','2022-05-04','2022-05-10','return','Bk00004','2022-05-01',NULL,'return',19107),('159657','Bk00005','2022-05-03','2022-03-04','issued',NULL,NULL,NULL,NULL,0),('2356','Bk00002','2022-04-15',NULL,'issued','Bk00005','2022-04-15',NULL,'issued',0),('6954654','Bk00001','2022-05-02','2022-05-09','return',NULL,NULL,NULL,NULL,0),('78414','Bk00002','2022-05-02','2022-03-04','return',NULL,NULL,NULL,NULL,0),('873489','Bk00002','2022-05-02','2022-03-04','return',NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `issuebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librarian_table`
--

DROP TABLE IF EXISTS `librarian_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `librarian_table` (
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile` varchar(12) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `pass` varchar(20) NOT NULL,
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librarian_table`
--

LOCK TABLES `librarian_table` WRITE;
/*!40000 ALTER TABLE `librarian_table` DISABLE KEYS */;
INSERT INTO `librarian_table` VALUES ('Mete','shree@123','8768768798','Latur k','mete'),('Shree','shree@2000','456454664','latur','hat');
/*!40000 ALTER TABLE `librarian_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_details`
--

DROP TABLE IF EXISTS `student_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_details` (
  `enroll` varchar(15) NOT NULL,
  `name` varchar(100) NOT NULL,
  `rollno` varchar(10) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `department` varchar(50) NOT NULL,
  `class` varchar(10) NOT NULL,
  `addDate` date NOT NULL,
  PRIMARY KEY (`enroll`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_details`
--

LOCK TABLES `student_details` WRITE;
/*!40000 ALTER TABLE `student_details` DISABLE KEYS */;
INSERT INTO `student_details` VALUES ('','','','','','Select','Select','2022-04-26'),('123','shree','30','656262','shree','Computer Science ','C01','2022-04-27'),('123456','mete shriniwas','23','1234567890','mete@2000','Computer Science ','C01','2022-04-27'),('123456123','gayatri ','12','21215','gayatri','Computer Science ','C03','2022-05-04'),('123456789','mete','23','54645464','123','Civil Engineering','CE1','2022-04-28'),('123456789123','mete','40','5654654','mete','Civil Engineering','CE2','2022-04-28'),('123456n','mahesh','50','8456','ma','Computer Science ','C01','2022-05-01'),('12358789456','kjlk','24','424444445','tre43','Computer Science ','C01','2022-04-29'),('134679285','fr45f','45','4354635','geeff4','Civil Engineering','CE1','2022-04-29'),('147258369','hi shree','19','372468193','mete@123456','Computer Science ','C01','2022-04-29'),('159657','mete s','23','7020368027','mete','Dress Design','DD1','2022-05-03'),('2356','MK','25','8529637410','km@gmail.com','Computer Science ','Select','2022-05-01'),('546','hi','12','546','kmjkj','Computer Science ','C03','2022-04-27'),('5651651','fcejkrnfkejrnf','23','51465','mfnekjd','Civil Engineering','CE2','2022-04-27'),('5654','kkkkkk','25','456','kadam','Computer Science ','C01','2022-04-29'),('6954654','Amar','23','654654','mar','Computer Science ','C03','2022-05-02'),('78414','Som@star','45','65262','somStar','Computer Science ','C03','2022-05-02'),('873489','Shweta','51','546','shwet','Dress Design','DD1','2022-05-02'),('87435893745','shree','23','5465465165','mete','Computer Science ','C03','2022-04-26'),('hbjh','kjnkjn','kjnkjn','kjnkjn','jjnjkn','Computer Science ','C01','2022-04-26');
/*!40000 ALTER TABLE `student_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-23 10:20:13
