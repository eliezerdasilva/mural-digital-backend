
DROP TABLE IF EXISTS `cardapio`;

CREATE TABLE `cardapio` (
  `idcardapio` int  AUTO_INCREMENT,
  `carnes` varchar(255) ,
  `opcoes_vegana` varchar(255) ,
  `sucos` varchar(255) ,
  `saladas` varchar(255) ,
  `carboidratos` varchar(255) ,
  `data` DATE Null,
  PRIMARY KEY (`idcardapio`),
  UNIQUE KEY `idcardapio_UNIQUE` (`idcardapio`),
  UNIQUE KEY `data_UNIQUE` (`data`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `mural_digital`.`eventossisae` (
  `idEventosSisae` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `mensagem` VARCHAR(45) NOT NULL,
  `imagem` MEDIUMBLOB NOT NULL,
  PRIMARY KEY (`idEventosSisae`));

/*!40101 SET character_set_client = @saved_cs_client */;
