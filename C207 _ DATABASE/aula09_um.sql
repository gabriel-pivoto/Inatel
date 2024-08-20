CREATE SCHEMA IF NOT EXISTS AULA09_UM DEFAULT CHARACTER SET utf8;
USE AULA09_UM;

CREATE TABLE IF NOT EXISTS Departamento(
	idDepartamento INT NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(45) NOT NULL,
    qtd_projeto VARCHAR(45) NOT NULL, 
    PRIMARY KEY (idDepartamento)
);

CREATE TABLE IF NOT EXISTS Empregados(
	idEmpregado INT NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(45) NOT NULL,
    endereco VARCHAR (45) NOT NULL, 
    Departamento_idDepartamento INT NOT NULL,
    PRIMARY KEY (idEmpregado),
    
    CONSTRAINT fk_Empregado_Departamento
		FOREIGN KEY (Departamento_idDepartamento)
        REFERENCES Departamento(idDepartamento)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

INSERT INTO Departamento() values 
(default, 'Departamento1', 3),
(default, 'Departamento2', 5),
(default, 'Departamento3', 1);

INSERT INTO Empregados() values
(default, 'Pedro', 'Rua dos Limas', 1),
(default, 'João', 'Rua das Palmeiras', 2),
(default, 'Márcia', 'Rua dos Luzes', 1),
(default, 'Joana', 'Rua 5', 3),
(default, 'Kaio', 'Rua do Inatel', 2);

SELECT * FROM Departamento;
SELECT * FROM Empregados;
