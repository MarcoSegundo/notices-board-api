CREATE SCHEMA desafio;


CREATE TABLE desafio.aviso (
 id INT NOT NULL,
 titulo VARCHAR(255) NOT NULL,
 descricao VARCHAR(255) NOT NULL,
 data_publicacao DATETIME NOT NULL,
 data_visualizacao DATETIME NULL,
 PRIMARY KEY (id));


 ALTER TABLE desafio.aviso
 CHANGE COLUMN id id INT(11) NOT NULL AUTO_INCREMENT ,
 ADD UNIQUE INDEX id_UNIQUE (id ASC);