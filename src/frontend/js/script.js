// Dados Simulados
let produtos = [];
let estoque = [];
let fornecedores = [];
let clientes = [];
let compras = [];
let vendas = [];
let producao = [];
let relacaoProdutoInsumo = [];

// Funções de Adicionar e Exibir

function adicionarProduto() {
    const nome = prompt("Nome do Produto:");
    const preco = parseFloat(prompt("Preço do Produto:"));
    produtos.push({ nome, preco });
    exibirProdutos();
}

function exibirProdutos() {
    const container = document.querySelector('#produtos-lista');
    container.innerHTML = '';
    produtos.forEach((produto) => {
        container.innerHTML += `
            <div>Produto: ${produto.nome} | Preço: R$ ${produto.preco}</div>
        `;
    });
}

// Funções para Fornecedores
function adicionarFornecedor() {
    const nome = prompt("Nome do Fornecedor:");
    fornecedores.push({ nome });
    exibirFornecedores();
}

function exibirFornecedores() {
    const container = document.querySelector('#fornecedores-lista');
    container.innerHTML = '';
    fornecedores.forEach((fornecedor) => {
        container.innerHTML += `
            <div>Fornecedor: ${fornecedor.nome}</div>
        `;
    });
}

// Funções para Clientes
function adicionarCliente() {
    const nome = prompt("Nome do Cliente:");
    clientes.push({ nome });
    exibirClientes();
}

function exibirClientes() {
    const container = document.querySelector('#clientes-lista');
    container.innerHTML = '';
    clientes.forEach((cliente) => {
        container.innerHTML += `
            <div>Cliente: ${cliente.nome}</div>
        `;
    });
}

// Funções para Estoque
function adicionarEstoque() {
    const produto = prompt("Nome do Produto para adicionar ao Estoque:");
    const quantidade = parseInt(prompt("Quantidade:"));
    estoque.push({ produto, quantidade });
    exibirEstoque();
}

function exibirEstoque() {
    const container = document.querySelector('#estoque-lista');
    container.innerHTML = '';
    estoque.forEach((item) => {
        container.innerHTML += `
            <div>${item.produto} - Quantidade: ${item.quantidade}</div>
        `;
    });
}

document.addEventListener('DOMContentLoaded', () => {
    exibirProdutos();
    exibirFornecedores();
    exibirClientes();
    exibirEstoque();
});
