CREATE DATABASE IF NOT EXISTS C207;

USE C207;

CREATE TABLE IF NOT EXISTS alunos(
	matricula INT,
    curso VARCHAR(45),
    NOME varchar(45),
    periodo INT, 
    PRIMARY KEY (matricula, curso)
);


CREATE USER "Monitor" identified  by "111#GEC";
CREATE USER "Professor" identified  by "999#GEC";

GRANT ALL PRIVILEGES ON C207.* TO "Monitor";
GRANT SELECT, INSERT, UPDATE, DELETE ON C207.alunos TO "Professor";

REVOKE INSERT ON C207.* FROM "Monitor";
REVOKE SELECT, INSERT ON C207.alunos FROM "Professor";


SHOW GRANTS FOR "Monitor";
SHOW GRANTS FOR "Professor";