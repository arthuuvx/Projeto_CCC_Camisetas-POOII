# POO_II_Camisetas

## Sumário

1. [Introdução](#introdução)
2. [Clone e Importação do Projeto](#clone-e-importação-do-projeto)
3. [Configuração do Banco de Dados](#configuração-do-banco-de-dados)

## Introdução

Este projeto é um sistema de gerenciamento para uma loja de camisetas, permitindo o controle de clientes, fornecedores, produtos, insumos, e muito mais. O sistema é implementado em Java e utiliza Maven para gerenciamento de dependências.

## Clone e Importação do Projeto

### Clonar o Projeto no IntelliJ IDEA

1. **Abrir o IntelliJ IDEA:**
   Abra o IntelliJ IDEA na sua máquina.

2. **Clonar o Repositório:**
   - Vá para **File** -> **New** -> **Project from Version Control**.
   - Selecione **Git** na lista de sistemas de controle de versão.
   - No campo **URL**, insira o link do repositório GitHub:
     ```
     https://github.com/arthuuvx/POO_II_Camisetas.git
     ```
   - Escolha o diretório onde deseja clonar o projeto e clique em **Clone**.

3. **Importar o Projeto:**
   - Após o repositório ser clonado, o IntelliJ IDEA reconhecerá automaticamente o projeto Maven.
   - Se não reconhecer, vá para **File** -> **Open** e selecione o diretório do projeto clonado.
   - O IntelliJ IDEA irá configurar o projeto automaticamente.

## Configuração do Banco de Dados

### Criar e Configurar o Banco de Dados

1. **Criar o Banco de Dados:**
   - Abra o cliente PostgreSQL ou utilize a linha de comando para criar o banco de dados:
     ```sh
     createdb -U postgres ccc_camisetas
     ```

2. **Importar o Script SQL:**
   - Salve o arquivo script_do_banco em .sql, importe-o utilizando o cliente PostgreSQL ou pgAdmin:
   - Alimente-o salvando o arquivo alimenta_bd em .sql, importe-o dentro do banco de dados.

### Configurar a Conexão com o Banco de Dados

1. **Editar Configurações de Conexão:**
   - Abra o arquivo `DatabaseConnection.java` no IntelliJ IDEA.
   - Verifique e ajuste as configurações de URL, usuário e senha conforme sua configuração local:
     ```java
     private static final String URL = "jdbc:postgresql://localhost:5432/ccc_camisetas";
     private static final String USER = "postgres";
     private static final String PASSWORD = "sua_senha";
     ```
