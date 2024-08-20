CREATE SCHEMA IF NOT EXISTS AULA09_TRES DEFAULT CHARACTER SET utf8;
USE AULA09_TRES;
CREATE TABLE IF NOT EXISTS Empregados(
	idEmpregado INT NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(45) NOT NULL,
    endereco VARCHAR (45) NOT NULL, 
    Departamento_idDepartamento INT NOT NULL,
    PRIMARY KEY (idEmpregado)
);

CREATE TABLE IF NOT EXISTS Projeto (
	idProjeto INT NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(45) NOT NULL,
    setor VARCHAR(45) NOT NULL, 
    PRIMARY KEY (idProjeto)
);

CREATE TABLE IF NOT EXISTS Empregados_has_Projeto(
	Empregados_idEmpregado INT NOT NULL,
    Projeto_idProjeto INT NOT NULL,
    Date_conclusao DATE NULL,
    PRIMARY KEY (Empregados_idEmpregado, Projeto_idProjeto),
    CONSTRAINT fk_Empregados_has_Projeto_Empregado
		FOREIGN KEY (Empregados_idEmpregado)
        REFERENCES Empregados(idEmpregado)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
        
	CONSTRAINT fk_Empregados_has_Projeto_Projeto1
		FOREIGN KEY (Projeto_idProjeto)
        REFERENCES Projeto(idProjeto)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);


INSERT INTO Empregados() values
(default, 'Pedro', 'Rua dos Limas', 1),
(default, 'João', 'Rua das Palmeiras', 2),
(default, 'Márcia', 'Rua dos Luzes', 1),
(default, 'Joana', 'Rua 5', 3),
(default, 'Kaio', 'Rua do Inatel', 2);

INSERT INTO Projeto() values
(default, 'Projeto 1', 1),
(default, 'Projeto 2', 1),
(default, 'Projeto 3', 2),
(default, 'Projeto 4', 2),
(default, 'Projeto 5', 2);

INSERT INTO Empregados_has_Projeto() values
(1, 2, "110-01-22"),
(2, 1, "22-12-19"),
(3, 1, "22-12-18"),
(4, 1, "12-06-22"),
(5, 2, "10/11-11");


SELECT E.Nome, P.Nome, EP.Date_conclusao FROM Empregados AS E JOIN Empregados_has_Projeto AS EP ON E.idEmpregado = EP.Empregados_idEmpregado JOIN PROJETO AS P ON P.idProjeto = EP.Projeto_idProjeto;