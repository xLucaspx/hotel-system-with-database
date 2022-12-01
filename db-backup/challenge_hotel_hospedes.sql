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
-- Table structure for table `hospedes`
--

DROP TABLE IF EXISTS `hospedes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospedes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) NOT NULL,
  `sobrenome` varchar(50) NOT NULL DEFAULT 'N.I.',
  `data_nasc` varchar(10) NOT NULL,
  `nacionalidade` varchar(25) NOT NULL,
  `telefone` varchar(25) NOT NULL,
  `id_reserva` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_reserva` (`id_reserva`),
  CONSTRAINT `hospedes_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reservas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospedes`
--

LOCK TABLES `hospedes` WRITE;
/*!40000 ALTER TABLE `hospedes` DISABLE KEYS */;
INSERT INTO `hospedes` VALUES (10,'Bruna','Lima','2000-12-08','Brasileira','51 98765-4321',19),(11,'Henrique','Diaz','1996-08-06','Argentino','(54) 98547-6687',20),(12,'Leonor','de Bragança','2000-02-29','Portuguesa','(57) 3387-4587',21),(13,'Lúcia Helena','Dias de Sousa','1989-09-13','Brasileira','53 985475878',22),(14,'Nico ','Steppat','1986-09-08','Alemão','(36) 98457-5547',23),(15,'Hérnan','Fernandez','1999-05-07','Espanhol','(85) 985476663',24),(16,'Marcel','Simon','1996-03-03','Francês','85 965478547',25),(17,'Júlia','Santos de Lima','1997-09-13','Brasileira','53 98745-6699',26),(18,'Paulo','Silveira','1987-09-15','Brasileiro','54 3368-9874',27),(19,'Anthony','Romano','1979-08-13','Americano','57 998547658',28),(20,'Carlo','di Conti','1991-05-12','Italiano','53 95478-3321',29),(21,'Èdouard','Saint Simon','1975-06-03','Francês','51 985214785',30),(22,'Adriana','Lopes da Silveira','2000-07-06','Brasileira','52 3368-9988',31),(23,'Andrés','Velasco','2000-04-13','Uruguaio','53 33687459',32),(24,'Laurel','Lennox','1967-05-01','Americana','56 3667-8487',33),(25,'João Victor','Staudt de Matos','1998-10-10','Brasileiro','54 98745-0072',34),(26,'Eduardo Guilherme','Monteiro da Silveira','1989-12-18','Brasileiro','54 97854-6620',35),(27,'Mestre','Jonas','1922-08-07','Baleia','51 985476584',36);
/*!40000 ALTER TABLE `hospedes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-01 14:05:20
