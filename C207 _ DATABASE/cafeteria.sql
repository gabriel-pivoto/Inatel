DROP SCHEMA trabalho_cafeteria;
CREATE SCHEMA IF NOT EXISTS trabalho_cafeteria;
USE trabalho_cafeteria;

-- -----------------------------------------------------
-- Tabela `trabalho_cafeteria`.`Cardapio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Cardapio (
  idCatalogo INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  QntProdutos INT NOT NULL,
  PRIMARY KEY (idCatalogo)
);

-- -----------------------------------------------------
-- Tabela `trabalho_cafeteria`.`Cafeteria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Cafeteria (
  idCafeteria INT NOT NULL AUTO_INCREMENT,
  Nome VARCHAR(45) NOT NULL,
  Endereco VARCHAR(45) NOT NULL,
  Telefone VARCHAR(45) NOT NULL,
  Cardapio_idCatalogo INT NOT NULL,
  PRIMARY KEY (idCafeteria),
  CONSTRAINT fk_Cafeteria_Cardapio1
    FOREIGN KEY (Cardapio_idCatalogo)
    REFERENCES Cardapio (idCatalogo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Tabela `trabalho_cafeteria`.`Mesas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Mesas (
  idMesas INT NOT NULL AUTO_INCREMENT,
  NumMesa VARCHAR(45) NOT NULL,
  QntdCadeiras INT NOT NULL,
  Cafeteria_idCafeteria INT NOT NULL,
  PRIMARY KEY (idMesas),
  CONSTRAINT fk_Mesas_Cafeteria1
    FOREIGN KEY (Cafeteria_idCafeteria)
    REFERENCES Cafeteria (idCafeteria)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Tabela `trabalho_cafeteria`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Cliente (
  idCliente INT NOT NULL AUTO_INCREMENT,
  Clientecol VARCHAR(45) NOT NULL,
  Telefone VARCHAR(45) NOT NULL,
  Mesas_idMesas INT NOT NULL,
  PRIMARY KEY (idCliente),
  INDEX idx_Cliente_Mesas (Mesas_idMesas), -- Adiciona o índice necessário
  CONSTRAINT fk_Cliente_Mesas1
    FOREIGN KEY (Mesas_idMesas)
    REFERENCES Mesas (idMesas)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Tabela `trabalho_cafeteria`.`Cafeteria_has_Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Cafeteria_has_Cliente (
  Cafeteria_idCafeteria INT NOT NULL,
  Cliente_idCliente INT NOT NULL,
  Cliente_Mesas_idMesas INT NOT NULL,
  PRIMARY KEY (Cafeteria_idCafeteria, Cliente_idCliente, Cliente_Mesas_idMesas),
  CONSTRAINT fk_Cafeteria
    FOREIGN KEY (Cafeteria_idCafeteria)
    REFERENCES Cafeteria (idCafeteria),
  CONSTRAINT fk_Cliente
    FOREIGN KEY (Cliente_idCliente)
    REFERENCES Cliente (idCliente),
  CONSTRAINT fk_Mesas
    FOREIGN KEY (Cliente_Mesas_idMesas)
    REFERENCES Mesas (idMesas)
);

-- -----------------------------------------------------
-- Tabela `trabalho_cafeteria`.`Produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Produtos (
  idProdutos INT NOT NULL AUTO_INCREMENT,
  Nome VARCHAR(45) NOT NULL,
  tipo VARCHAR(45) NOT NULL,
  Cliente_idCliente INT NOT NULL,
  Cliente_Mesas_idMesas INT NOT NULL,
  Cardapio_idCatalogo INT NOT NULL,
  Cardapio_Produtos_idProdutos INT NOT NULL,
  Cardapio_Produtos_Cliente_idCliente INT NOT NULL,
  Cardapio_Produtos_Cliente_Mesas_idMesas INT NOT NULL,
  PRIMARY KEY (idProdutos),
  INDEX idx_Produtos_Cliente (Cliente_idCliente, Cliente_Mesas_idMesas), -- Adiciona o índice necessário
  CONSTRAINT fk_Produtos_Cliente1
    FOREIGN KEY (Cliente_idCliente, Cliente_Mesas_idMesas)
    REFERENCES Cliente (idCliente, Mesas_idMesas)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Produtos_Cardapio1
    FOREIGN KEY (Cardapio_idCatalogo, Cardapio_Produtos_idProdutos, Cardapio_Produtos_Cliente_idCliente, Cardapio_Produtos_Cliente_Mesas_idMesas)
    REFERENCES Cardapio (idCatalogo, idCatalogo, idCatalogo, idCatalogo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Inserir dados na tabela Cliente
INSERT INTO Cliente (Clientecol, Telefone, Mesas_idMesas) VALUES
('Mesa1', '4', 1),
('Mesa2', '2', 1),
('Mesa3', '4', 1),
('Mesa4', '4', 1),
('Mesa5', '4', 1),
('Mesa6', '4', 1),
('Mesa7', '4', 1);
