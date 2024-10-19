CREATE DATABASE  IF NOT EXISTS `mural_digital` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mural_digital`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mural_digital
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `cardapio`
--

DROP TABLE IF EXISTS `cardapio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cardapio` (
  `idcardapio` int NOT NULL AUTO_INCREMENT,
  `carnes` varchar(100) NOT NULL,
  `opcaovegana` varchar(100) NOT NULL,
  `sucos` varchar(100) NOT NULL,
  `saladas` varchar(100) NOT NULL,
  `carboidratos` varchar(200) NOT NULL,
  `data` datetime NOT NULL,
  PRIMARY KEY (`idcardapio`),
  UNIQUE KEY `idcardapio_UNIQUE` (`idcardapio`),
  UNIQUE KEY `data_UNIQUE` (`data`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardapio`
--

LOCK TABLES `cardapio` WRITE;
/*!40000 ALTER TABLE `cardapio` DISABLE KEYS */;
/*!40000 ALTER TABLE `cardapio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventosisae`
--

DROP TABLE IF EXISTS `eventosisae`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventosisae` (
  `ideventosisae` int NOT NULL AUTO_INCREMENT,
  `imagem` blob NOT NULL,
  `idusuario` int NOT NULL,
  PRIMARY KEY (`ideventosisae`,`idusuario`),
  UNIQUE KEY `ideventosisae_UNIQUE` (`ideventosisae`),
  KEY `idusuario_idx` (`idusuario`),
  CONSTRAINT `idusuario` FOREIGN KEY (`idusuario`) REFERENCES `usuariosisae` (`idusuariosisae`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventosisae`
--

LOCK TABLES `eventosisae` WRITE;
/*!40000 ALTER TABLE `eventosisae` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventosisae` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariorestaurante`
--

DROP TABLE IF EXISTS `usuariorestaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuariorestaurante` (
  `idusuarioRestaurante` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `categoriaUsuario` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idusuarioRestaurante`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariorestaurante`
--

LOCK TABLES `usuariorestaurante` WRITE;
/*!40000 ALTER TABLE `usuariorestaurante` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuariorestaurante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariosisae`
--

DROP TABLE IF EXISTS `usuariosisae`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuariosisae` (
  `idusuariosisae` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(75) NOT NULL,
  `categoriausuario` varchar(45) NOT NULL,
  PRIMARY KEY (`idusuariosisae`),
  UNIQUE KEY `idusuariosisae_UNIQUE` (`idusuariosisae`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariosisae`
--

LOCK TABLES `usuariosisae` WRITE;
/*!40000 ALTER TABLE `usuariosisae` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuariosisae` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-19 15:43:19
