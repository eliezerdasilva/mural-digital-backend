CREATE TABLE `eventossisae` (
  `idEventosSisae` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `mensagem` VARCHAR(45) NOT NULL,
  `imagem` LONGBLOB NOT NULL,
  `data` DATE NOT NULL,
  PRIMARY KEY (`idEventosSisae`)
);
