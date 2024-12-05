CREATE TABLE login_servidor (
    id_servidor BIGINT AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    tipo_servidor VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_servidor)
);
