-- Criação da tabela Funcionário
CREATE TABLE Funcionario (
    Id_funcionario VARCHAR(10) PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Cargo VARCHAR(50) NOT NULL,
    Salario DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela Cliente
CREATE TABLE Cliente (
    Id_cliente VARCHAR(15) PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Endereco VARCHAR(200) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    CPF CHAR(11) NOT NULL
);

-- Criação da tabela Camiseta
CREATE TABLE Camiseta (
    Id_camiseta VARCHAR(10) PRIMARY KEY,
    Modelo VARCHAR(50) NOT NULL,
    Tamanho VARCHAR(10) NOT NULL,
    Cor VARCHAR(30) NOT NULL,
    Preco DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela Produto
CREATE TABLE Produto (
    Id_produto VARCHAR(10) PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Descricao VARCHAR(200) NOT NULL,
    Preco DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela Insumo
CREATE TABLE Insumo (
    Id_insumo VARCHAR(10) PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Descricao VARCHAR(200) NOT NULL,
    Preco_unitario DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela Fornecedor
CREATE TABLE Fornecedor (
    Id_fornecedor VARCHAR(10) PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Endereco VARCHAR(200) NOT NULL,
    Contato VARCHAR(50) NOT NULL
);

-- Criação da tabela Controle_De_Compra
CREATE TABLE Controle_De_Compra (
    Id_compra VARCHAR(10) PRIMARY KEY,
    Id_produto VARCHAR(10) NOT NULL,
    Quantidade INT NOT NULL,
    FOREIGN KEY (Id_produto) REFERENCES Produto(Id_produto)
);

-- Criação da tabela Controle_De_Producao
CREATE TABLE Controle_De_Producao (
    Id_controle_de_producao VARCHAR(10) PRIMARY KEY,
    Id_camiseta VARCHAR(10) NOT NULL,
    Quantidade_produzida INT NOT NULL,
    Data_producao DATE NOT NULL,
    Energia_gasta DECIMAL(10, 2) NOT NULL,
    Manutencao DECIMAL(10, 2) NOT NULL,
    Gasto_agua DECIMAL(10, 2) NOT NULL,
    Gasto_mao_de_obra DECIMAL(10, 2) NOT NULL,
    Gastos_internos DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (Id_camiseta) REFERENCES Camiseta(Id_camiseta)
);

-- Criação da tabela Controle_De_Venda
CREATE TABLE Controle_De_Venda (
    Id_controle_de_venda VARCHAR(10) PRIMARY KEY,
    Id_cliente VARCHAR(15) NOT NULL,
    Id_camiseta VARCHAR(10) NOT NULL,
    Quantidade INT NOT NULL,
    Data_venda DATE NOT NULL,
    FOREIGN KEY (Id_cliente) REFERENCES Cliente(Id_cliente),
    FOREIGN KEY (Id_camiseta) REFERENCES Camiseta(Id_camiseta)
);

-- Criação da tabela Relacao_Produto_Insumo
CREATE TABLE Relacao_Produto_Insumo (
    Id_produto VARCHAR(10) NOT NULL,
    Id_insumo VARCHAR(10) NOT NULL,
    Quantidade_usada DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (Id_produto, Id_insumo),
    FOREIGN KEY (Id_produto) REFERENCES Produto(Id_produto),
    FOREIGN KEY (Id_insumo) REFERENCES Insumo(Id_insumo)
);

-- Criação da tabela Receita
CREATE TABLE Receita (
    Id_receita VARCHAR(10) PRIMARY KEY,
    Valor_total DECIMAL(10, 2) NOT NULL,
    Data DATE NOT NULL
);

-- Criação da tabela Estoque
CREATE TABLE Estoque (
    Id_produto VARCHAR(10) NOT NULL,
    Id_insumo VARCHAR(10) NOT NULL,
    Quantidade_disponivel INT NOT NULL,
    PRIMARY KEY (Id_produto, Id_insumo),
    FOREIGN KEY (Id_produto) REFERENCES Produto(Id_produto),
    FOREIGN KEY (Id_insumo) REFERENCES Insumo(Id_insumo)
);
