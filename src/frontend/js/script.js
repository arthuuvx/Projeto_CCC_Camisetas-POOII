// Função para abrir o modal
function abrirModal(secao) {
    const modal = document.getElementById('modal');
    const modalBody = document.getElementById('modal-body');
    let conteudo;

    switch (secao) {
        case 'produtos':
            conteudo = '<h2>Produtos</h2><p>Gerencie seus produtos aqui.</p>';
            break;
        case 'estoque':
            conteudo = '<h2>Estoque</h2><p>Controle seu estoque de forma eficiente.</p>';
            break;
        case 'fornecedores':
            conteudo = '<h2>Fornecedores</h2><p>Gerencie os fornecedores da sua loja.</p>';
            break;
        case 'clientes':
            conteudo = '<h2>Clientes</h2><p>Gerencie as informações dos seus clientes.</p>';
            break;
        case 'compras':
            conteudo = '<h2>Compras</h2><p>Controle suas compras realizadas.</p>';
            break;
        case 'vendas':
            conteudo = '<h2>Vendas</h2><p>Registre e acompanhe as vendas da loja.</p>';
            break;
        case 'producao':
            conteudo = '<h2>Produção</h2><p>Acompanhe o processo de produção.</p>';
            break;
        case 'receita':
            conteudo = '<h2>Receita</h2><p>Veja os relatórios de receita e desempenho financeiro.</p>';
            break;
        case 'funcionario':
            conteudo = '<h2>Funcionário</h2><p>Gerencie informações dos funcionários e equipe.</p>';
            break;
        case 'insumo':
            conteudo = '<h2>Insumo</h2><p>Controle e acompanhe os insumos necessários para produção.</p>';
            break;
        default:
            conteudo = '<p>Seção não encontrada.</p>';
    }

    modalBody.innerHTML = conteudo;
    modal.style.display = 'flex';
}

// Função para fechar o modal
function fecharModal() {
    const modal = document.getElementById('modal');
    modal.style.display = 'none';
}
