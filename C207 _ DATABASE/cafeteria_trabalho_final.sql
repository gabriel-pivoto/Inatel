DROP SCHEMA trabalho_cafeteria_final;
CREATE SCHEMA trabalho_cafeteria_final;
USE trabalho_cafeteria_final; 

CREATE TABLE Cliente (
    IDCliente INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50),
    Email VARCHAR(100),
    Telefone VARCHAR(15)
);

CREATE TABLE Produto (
    IDProduto INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50),
    Preco DECIMAL(8, 2)
);

CREATE TABLE Ingrediente (
    IDIngrediente INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50)
);

CREATE TABLE ProdutoIngrediente (
    IDProduto INT,
    IDIngrediente INT,
    PRIMARY KEY (IDProduto, IDIngrediente),
    FOREIGN KEY (IDProduto) REFERENCES Produto(IDProduto),
    FOREIGN KEY (IDIngrediente) REFERENCES Ingrediente(IDIngrediente)
);


CREATE TABLE Pedido (
    IDPedido INT PRIMARY KEY AUTO_INCREMENT,
    IDCliente INT,
    DataPedido VARCHAR(30),
    FOREIGN KEY (IDCliente) REFERENCES Cliente(IDCliente)
);

CREATE TABLE ItemPedido (
    IDItemPedido INT PRIMARY KEY AUTO_INCREMENT,
    IDPedido INT,
    IDProduto INT,
    Quantidade INT,
    PrecoUnitario DECIMAL(8, 2),
    FOREIGN KEY (IDPedido) REFERENCES Pedido(IDPedido),
    FOREIGN KEY (IDProduto) REFERENCES Produto(IDProduto)
);

CREATE TABLE Funcionario (
    IDFuncionario INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50),
    Cargo VARCHAR(50)
);
CREATE TABLE CartaoFidelidade (
    IDCartao INT PRIMARY KEY AUTO_INCREMENT,
    IDCliente INT UNIQUE,
    Pontuacao INT,
    FOREIGN KEY (IDCliente) REFERENCES Cliente(IDCliente)
);

CREATE TABLE Pagamento (
    IDPagamento INT PRIMARY KEY AUTO_INCREMENT,
    IDPedido INT,
    Valor DECIMAL(8, 2),
    MetodoPagamento VARCHAR(20),
    FOREIGN KEY (IDPedido) REFERENCES Pedido(IDPedido)
);





INSERT INTO Funcionario (Nome, Cargo) VALUES ('João Godoy', 'Faxineiro'), ('Gabriel', 'Gerente'), ('João', 'Cozinheiro'), ('Samuel', 'Garçon'),('Jorge', 'Garçon');
INSERT INTO Cliente (Nome, Email, Telefone) VALUES ('João Silva', 'joao@email.com', '123456789'), ('Alex Silva', 'alex@email.com', '1949846325'), ('Ana Silva', 'ana@email.com', '1654498491');
INSERT INTO Produto (Nome, Preco) VALUES ('Café Expresso', 3.50), ('Café longo', 2.50), ('Café', 1.00), ('Café com leite', 1.50),('Cappuccino', 5.00);

INSERT INTO Pedido (IDCliente, DataPedido) VALUES (1, CURRENT_TIMESTAMP);
INSERT INTO Pedido (IDCliente, DataPedido) VALUES (2, CURRENT_TIMESTAMP);
INSERT INTO Pedido (IDCliente, DataPedido) VALUES (3, CURRENT_TIMESTAMP);

INSERT INTO ItemPedido (IDPedido, IDProduto, Quantidade, PrecoUnitario) VALUES (1, 1, 2, 3.50), (1, 2, 1, 2.50), (1, 3, 4, 1.00);
INSERT INTO ItemPedido (IDPedido, IDProduto, Quantidade, PrecoUnitario) VALUES (2, 1, 9, 3.50), (2, 2, 2, 2.50), (2, 3, 8, 1.00);
INSERT INTO ItemPedido (IDPedido, IDProduto, Quantidade, PrecoUnitario) VALUES (3, 1, 1, 3.50), (3, 2, 4, 2.50), (3, 3, 2, 1.00);

INSERT INTO Ingrediente (Nome) VALUES ('Café');
INSERT INTO Ingrediente (Nome) VALUES ('Leite');
INSERT INTO Ingrediente (Nome) VALUES ('Açúcar');

INSERT INTO ProdutoIngrediente (IDProduto, IDIngrediente) VALUES (1, 1);
INSERT INTO ProdutoIngrediente (IDProduto, IDIngrediente) VALUES (2, 2);
INSERT INTO ProdutoIngrediente (IDProduto, IDIngrediente) VALUES (3, 3);

INSERT INTO Pagamento (IDPedido, Valor, MetodoPagamento) VALUES (1, 20.50, 'Cartão de Crédito');
INSERT INTO Pagamento (IDPedido, Valor, MetodoPagamento) VALUES (1, 10.00, 'Dinheiro');

INSERT INTO CartaoFidelidade (IDCliente, Pontuacao) VALUES (1, 100);




select * from ProdutoIngrediente;

SELECT Pedido.IDPedido, Pedido.DataPedido, Produto.Nome AS Nome_Produto, ItemPedido.Quantidade, ItemPedido.PrecoUnitario
FROM Pedido
JOIN ItemPedido ON Pedido.IDPedido = ItemPedido.IDPedido
JOIN Produto ON ItemPedido.IDProduto = Produto.IDProduto
WHERE Pedido.IDCliente = 3;

SELECT SUM(Quantidade * PrecoUnitario) AS Total
FROM ItemPedido
WHERE IDPedido = 3;


UPDATE Funcionario set Nome='Pivoto' where IDFuncionario= 2;
UPDATE Funcionario set Nome='Dodas' where IDFuncionario= 1;
UPDATE Produto set Preco='2.00' where Nome= 'Café com leite';

delete from Funcionario where Nome = 'Jorge'; 
delete from Produto where Nome = 'Café com leite';

SELECT Nome, Cargo from Funcionario;
SELECT * from Pedido;
SELECT * from Produto;