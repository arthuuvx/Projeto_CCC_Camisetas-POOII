let produtos = [];
let estoque = [];
let fornecedores = [];
let clientes = [];

// Funções de Modal
function abrirModal(secao) {
    const modal = document.getElementById(`${secao}-modal`);
    modal.style.display = 'block';
}

function fecharModal(secao) {
    const modal = document.getElementById(`${secao}-modal`);
    modal.style.display = 'none';
}

// Função Genérica para Adicionar e Validar
function obterEntradaValida(mensagem, tipo) {
    let valor;
    do {
        valor = prompt(mensagem);
        if (tipo === 'numero') valor = parseFloat(valor);
    } while (!valor || (tipo === 'numero' && isNaN(valor)));
    return valor;
}

function adicionarProduto() {
    const nome = obterEntradaValida("Nome do Produto:", "texto");
    const preco = obterEntradaValida("Preço do Produto:", "numero");
    produtos.push({ nome, preco });
    exibirProdutos();
}

function exibirProdutos() {
    const container = document.querySelector('#produtos-lista');
    container.innerHTML = '';
    produtos.forEach((produto) => {
        container.innerHTML += `<li>Produto: ${produto.nome} | Preço: R$ ${produto.preco}</li>`;
    });
}

function adicionarEstoque() {
    const produto = obterEntradaValida("Nome do Produto para adicionar ao Estoque:", "texto");
    const quantidade = obterEntradaValida("Quantidade:", "numero");
    estoque.push({ produto, quantidade });
    exibirEstoque();
}

function exibirEstoque() {
    const container = document.querySelector('#estoque-lista');
    container.innerHTML = '';
    estoque.forEach((item) => {
        container.innerHTML += `<li>${item.produto} - Quantidade: ${item.quantidade}</li>`;
    });
}

function adicionarFornecedor() {
    const nome = obterEntradaValida("Nome do Fornecedor:", "texto");
    fornecedores.push({ nome });
    exibirFornecedores();
}

function exibirFornecedores() {
    const container = document.querySelector('#fornecedores-lista');
    container.innerHTML = '';
    fornecedores.forEach((fornecedor) => {
        container.innerHTML += `<li>Fornecedor: ${fornecedor.nome}</li>`;
    });
}

function adicionarCliente() {
    const nome = obterEntradaValida("Nome do Cliente:", "texto");
    clientes.push({ nome });
    exibirClientes();
}

function exibirClientes() {
    const container = document.querySelector('#clientes-lista');
    container.innerHTML = '';
    clientes.forEach((cliente) => {
        container.innerHTML += `<li>Cliente: ${cliente.nome}</li>`;
    });
}

document.addEventListener('DOMContentLoaded', () => {
    exibirProdutos();
    exibirEstoque();
    exibirFornecedores();
    exibirClientes();
});
