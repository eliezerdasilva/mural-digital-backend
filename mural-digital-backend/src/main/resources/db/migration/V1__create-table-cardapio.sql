
DROP TABLE IF EXISTS `cardapio`;

CREATE TABLE `cardapio` (
  `idcardapio` int  AUTO_INCREMENT,
  `carnes` varchar(100) ,
  `opcaovegana` varchar(100) ,
  `sucos` varchar(100) ,
  `saladas` varchar(100) ,
  `carboidratos` varchar(200) ,
  `data` datetime ,
  PRIMARY KEY (`idcardapio`),
  UNIQUE KEY `idcardapio_UNIQUE` (`idcardapio`),
  UNIQUE KEY `data_UNIQUE` (`data`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
