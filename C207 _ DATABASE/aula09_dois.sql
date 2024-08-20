CREATE SCHEMA IF NOT EXISTS AULA09_UM DEFAULT CHARACTER SET utf8;
USE AULA09_UM;


CREATE TABLE IF NOT EXISTS Empregados(
	idEmpregado INT NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(45) NOT NULL,
    endereco VARCHAR (45) NOT NULL, 
    Departamento_idDepartamento INT NOT NULL,
    PRIMARY KEY (idEmpregado)
);

CREATE TABLE IF NOT EXISTS Dependentes(
	idDependentes INT NOT NULL AUTO_INCREMENT,
	Nome VARCHAR(45) NOT NULL,
    Endereco VARCHAR(45) NOT NULL, 
    Empregados_idEmpregado INT NOT NULL, 
    PRIMARY KEY (idDependentes),
    CONSTRAINT fk_Dependentes_Empregados
		FOREIGN KEY (Empregados_idEmpregado)
        REFERENCES Empregados(idEmpregado)
        ON DELETE NO ACTION
		ON UPDATE NO ACTION
    );
    
INSERT INTO Empregados() values
(default, 'Pedro', 'Rua dos Limas', 1),
(default, 'João', 'Rua das Palmeiras', 2),
(default, 'Márcia', 'Rua dos Luzes', 1),
(default, 'Joana', 'Rua 5', 3),
(default, 'Kaio', 'Rua do Inatel', 2);


INSERT INTO Dependentes() values
(default, 'Dependente 1', 'Rua dos Limas', 1),
(default, 'Dependente 2', 'Rua das Palmeira',2),
(default, 'Dependente 3', 'Rua dos Luzes', 2),
(default, 'Dependente 4', 'Rua 5', 3),
(default, 'Dependente 5', 'Rua do Inatel', 4),
(default, 'Dependente 6', 'Rua das Águas', 5);

SELECT Empregados.Nome, Dependentes.Nome FROM Empregados JOIN Dependentes;

SELECT E.Nome, D.Nome FROM Empregados AS E INNER JOIN Dependentes AS D;

SELECT E.Nome, D.Nome FROM Empregados AS E JOIN Dependentes AS D ON D.Empregados_idEmpregado = E.idEmpregado ORDER BY E.Nome;

