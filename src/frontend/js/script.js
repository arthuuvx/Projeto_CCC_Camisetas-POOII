// Função para abrir o modal
function abrirModal(secao) {
    const modal = document.getElementById('modal');
    const modalBody = document.getElementById('modal-body');

    // Define o conteúdo com base na seção
    let conteudo = '';
    switch (secao) {
        case 'produtos':
            conteudo = '<h2>Produtos</h2><p>Gerencie seus produtos aqui.</p>';
            break;
        case 'estoque':
            conteudo = '<h2>Estoque</h2><p>Controle seu estoque de forma eficiente.</p>';
            break;
        case 'fornecedores':
            conteudo = '<h2>Fornecedores</h2><p>Adicione ou remova fornecedores.</p>';
            break;
        case 'clientes':
            conteudo = '<h2>Clientes</h2><p>Mantenha um registro de seus clientes.</p>';
            break;
        case 'compras':
            conteudo = '<h2>Compras</h2><p>Registre as compras realizadas.</p>';
            break;
        case 'vendas':
            conteudo = '<h2>Vendas</h2><p>Acompanhe suas vendas.</p>';
            break;
        case 'producao':
            conteudo = '<h2>Produção</h2><p>Gerencie a produção de produtos.</p>';
            break;
        case 'relacao':
            conteudo = '<h2>Relacionamento</h2><p>Relacionamento entre produtos e insumos.</p>';
            break;
        default:
            conteudo = '<p>Seção não encontrada.</p>';
    }

    // Adiciona o conteúdo ao modal e exibe
    modalBody.innerHTML = conteudo;
    modal.style.display = 'block';
}

// Função para fechar o modal
function fecharModal() {
    const modal = document.getElementById('modal');
    modal.style.display = 'none';
}

// Fecha o modal ao clicar fora dele
window.onclick = function (event) {
    const modal = document.getElementById('modal');
    if (event.target === modal) {
        fecharModal();
    }
};
