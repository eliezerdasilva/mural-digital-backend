
ALTER TABLE evento_sisae MODIFY COLUMN imagem LONGBLOB NOT NULL;

INSERT INTO login_servidor (email, name, tipo_servidor) VALUES
('joao.silva@example.com', 'João Silva', 'DOCENTE'),
('maria.souza@example.com', 'Maria Souza', 'SISAE'),
('pedro.almeida@example.com', 'Pedro Almeida', 'RESTAURANTE'),
('ana.costa@example.com', 'Ana Costa', 'DOCENTE'),
('bruno.oliveira@example.com', 'Bruno Oliveira', 'SISAE'),
('lucas.santos@example.com', 'Lucas Santos', 'DOCENTE'),
('fernanda.lima@example.com', 'Fernanda Lima', 'RESTAURANTE'),
('marcio.rodrigues@example.com', 'Márcio Rodrigues', 'SISAE'),
('carla.pereira@example.com', 'Carla Pereira', 'DOCENTE'),
('frete7132@gmail.com', 'Eliézer da Silva', 'DOCENTE');

INSERT INTO turma_docente (turma, id_servidor) 
VALUES ('INFO101', 20);
INSERT INTO turma_docente (turma, id_servidor) 
VALUES ('INFO102', 20);
INSERT INTO turma_docente (turma, id_servidor) 
VALUES ('INFO201', 20);
INSERT INTO turma_docente (turma, id_servidor) 
VALUES ('INFO202', 20);
INSERT INTO turma_docente (turma, id_servidor) 
VALUES ('INFO301', 20);
INSERT INTO turma_docente (turma, id_servidor) 
VALUES ('INFO302', 20);
