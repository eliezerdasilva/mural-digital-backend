CREATE TABLE `mural_digital`.`noticia_docente` (
  `idnoticia_docente` INT NOT NULL AUTO_INCREMENT,
  `dateInicio` DATE NOT NULL,
  `dataFinal` DATE NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `mensagem` VARCHAR(45) NOT NULL,
  `id_turma` BIGINT(20) NOT NULL,
  `id_servidor` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idnoticia_docente`),
  INDEX `id_turma_idx` (`id_turma` ) ,
  INDEX `id_servidor_idx` (`id_servidor`) ,
  CONSTRAINT `id_turma`
    FOREIGN KEY (`id_turma`)
    REFERENCES `mural_digital`.`turma_docente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_servidor`
    FOREIGN KEY (`id_servidor`)
    REFERENCES `mural_digital`.`login_servidor` (`id_servidor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);