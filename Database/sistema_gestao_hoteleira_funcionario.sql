-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema_gestao_hoteleira
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `Bi` varchar(15) NOT NULL,
  `Nome` varchar(50) DEFAULT NULL,
  `Idade` int DEFAULT NULL,
  `Sexo` char(1) DEFAULT NULL,
  `Telefone` varchar(50) DEFAULT NULL,
  `Endereco` varchar(30) DEFAULT NULL,
  `Ano_de_admissao` int DEFAULT NULL,
  `Senha` varchar(30) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Codigo_Cargo` int DEFAULT NULL,
  PRIMARY KEY (`Bi`),
  KEY `Codigo_Cargo` (`Codigo_Cargo`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`Codigo_Cargo`) REFERENCES `cargo_salarios` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES ('','Frederico',20,'M','0','Almeida Onca',2023,NULL,NULL,1),('3232A','JOAA',40,'M','32323232','RUA DAS LUPAS',2023,NULL,NULL,5),('AB3','Maria',18,'M','846636422','Avenida Lulas',2023,NULL,NULL,1),('AB4','JPAP',39,'M','875','gb',2022,NULL,NULL,5),('AMDKDI33','Ana Maria',33,'M','846636422','Avenida Almirante',2015,NULL,NULL,5);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-02 18:41:38
