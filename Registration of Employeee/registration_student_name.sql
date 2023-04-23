-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: registration
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
-- Table structure for table `student_name`
--

DROP TABLE IF EXISTS `student_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_name` (
  `id` int(11) DEFAULT NULL,
  `customer1` varchar(255) DEFAULT NULL,
  `customer2` varchar(255) DEFAULT NULL,
  `customer3` varchar(255) DEFAULT NULL,
  `customer4` varchar(255) DEFAULT NULL,
  `customer5` varchar(255) DEFAULT NULL,
  `customer6` varchar(255) DEFAULT NULL,
  `customer7` varchar(255) DEFAULT NULL,
  `customer8` varchar(255) DEFAULT NULL,
  `customer9` varchar(255) DEFAULT NULL,
  `customer10` varchar(255) DEFAULT NULL,
  `total_pay` int(11) DEFAULT NULL,
  `paid` int(11) DEFAULT NULL,
  `remained` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_name`
--

LOCK TABLES `student_name` WRITE;
/*!40000 ALTER TABLE `student_name` DISABLE KEYS */;
INSERT INTO `student_name` VALUES (1,'Mete','gfdfgf','gfhgfhgf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,30000,25000,5000);
/*!40000 ALTER TABLE `student_name` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-23 10:14:50
