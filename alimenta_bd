-- Inserir dados na tabela Funcionário
INSERT INTO Funcionario (Id_funcionario, Nome, Cargo, Salario) VALUES
('F001', 'João da Silva', 'Analista', 3500.00),
('F002', 'Maria Oliveira', 'Desenvolvedor', 4500.00);

-- Inserir dados na tabela Cliente
INSERT INTO Cliente (Id_cliente, Nome, Endereco, Email, CPF) VALUES
('C001', 'Pedro Santos', 'Rua A, 123', 'pedro.santos@example.com', '12345678901'),
('C002', 'Ana Costa', 'Rua B, 456', 'ana.costa@example.com', '09876543210');

-- Inserir dados na tabela Camiseta
INSERT INTO Camiseta (Id_camiseta, Modelo, Tamanho, Cor, Preco) VALUES
('CS001', 'Model A', 'M', 'Azul', 49.90),
('CS002', 'Model B', 'G', 'Vermelho', 59.90);

-- Inserir dados na tabela Produto
INSERT INTO Produto (Id_produto, Nome, Descricao, Preco) VALUES
('P001', 'Produto X', 'Descrição do Produto X', 29.90),
('P002', 'Produto Y', 'Descrição do Produto Y', 39.90);

-- Inserir dados na tabela Insumo
INSERT INTO Insumo (Id_insumo, Nome, Descricao, Preco_unitario) VALUES
('I001', 'Insumo A', 'Descrição do Insumo A', 5.00),
('I002', 'Insumo B', 'Descrição do Insumo B', 7.50);

-- Inserir dados na tabela Fornecedor
INSERT INTO Fornecedor (Id_fornecedor, Nome, Endereco, Contato) VALUES
('F001', 'Fornecedor 1', 'Av. Principal, 789', 'contato@fornecedor1.com'),
('F002', 'Fornecedor 2', 'Av. Secundária, 101', 'contato@fornecedor2.com');

-- Inserir dados na tabela Controle_De_Compra
INSERT INTO Controle_De_Compra (Id_compra, Id_produto, Quantidade) VALUES
('C001', 'P001', 100),
('C002', 'P002', 200);

-- Inserir dados na tabela Controle_De_Producao
INSERT INTO Controle_De_Producao (Id_controle_de_producao, Id_camiseta, Quantidade_produzida, Data_producao, Energia_gasta, Manutencao, Gasto_agua, Gasto_mao_de_obra, Gastos_internos) VALUES
('CP001', 'CS001', 500, '2024-08-20', 150.00, 30.00, 20.00, 40.00, 60.00),
('CP002', 'CS002', 300, '2024-08-21', 100.00, 20.00, 15.00, 25.00, 35.00);

-- Inserir dados na tabela Controle_De_Venda
INSERT INTO Controle_De_Venda (Id_controle_de_venda, Id_cliente, Id_camiseta, Quantidade, Data_venda) VALUES
('V001', 'C001', 'CS001', 2, '2024-08-20'),
('V002', 'C002', 'CS002', 1, '2024-08-21');

-- Inserir dados na tabela Relacao_Produto_Insumo
INSERT INTO Relacao_Produto_Insumo (Id_produto, Id_insumo, Quantidade_usada) VALUES
('P001', 'I001', 10),
('P002', 'I002', 20);

-- Inserir dados na tabela Receita
INSERT INTO Receita (Id_receita, Valor_total, Data) VALUES
('R001', 1000.00, '2024-08-20'),
('R002', 1500.00, '2024-08-21');

-- Inserir dados na tabela Estoque
INSERT INTO Estoque (Id_produto, Id_insumo, Quantidade_disponivel) VALUES
('P001', 'I001', 500),
('P002', 'I002', 300);
