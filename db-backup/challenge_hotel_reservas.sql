-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: challenge_hotel
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_entrada` varchar(10) NOT NULL,
  `data_saida` varchar(10) NOT NULL,
  `valor` varchar(10) NOT NULL,
  `forma_pagamento` varchar(50) NOT NULL DEFAULT 'Dinheiro',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (19,'2022-10-20','2022-10-25','425.0','Boleto'),(20,'2022-10-22','2022-10-30','638.4','Cartão de débito'),(21,'2022-10-22','2022-10-27','460.0','Dinheiro'),(22,'2022-10-25','2022-11-01','699.86','PIX'),(23,'2022-10-29','2022-11-03','399.0','Cartão de crédito'),(24,'2022-11-03','2022-11-07','420.0','Cartão de crédito'),(25,'2022-11-07','2022-11-20','1040.0','Cartão de crédito'),(26,'2022-11-15','2022-11-25','963.34','Cartão de crédito'),(27,'2022-11-26','2022-12-12','1216.0','Boleto'),(28,'2022-11-30','2022-12-10','986.24','Dinheiro'),(29,'2022-12-02','2022-12-18','1775.52','PIX'),(30,'2022-12-17','2022-12-27','1250.0','Boleto'),(31,'2022-12-22','2023-01-06','2025.0','Cartão de débito'),(32,'2022-12-23','2023-01-04','1533.24','Cartão de crédito'),(33,'2022-12-23','2022-12-28','700.0','Cartão de crédito'),(34,'2022-12-29','2023-01-06','1042.24','Cartão de débito'),(35,'2023-01-07','2023-01-22','1694.55','Dinheiro'),(36,'2022-10-20','2022-10-30','1000.0','PIX');
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-01 14:05:19
