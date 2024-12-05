CREATE TABLE `turma_docente` (
  `idturma_docente` INT NOT NULL AUTO_INCREMENT,
  `id_servidor` VARCHAR(45) NOT NULL,
  `turma` VARCHAR(45) NOT NULL,
  `disciplina` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idturma_docente`),
  CONSTRAINT `fk_servidor` FOREIGN KEY (`servidor`) REFERENCES `loginServidor` (`idlogin`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
