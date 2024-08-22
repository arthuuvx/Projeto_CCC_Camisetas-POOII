package br.com_ifg.model;

public class RelacaoProdutoInsumo {
    private String idProduto;
    private String idInsumo;
    private int quantidadeUsada;

    public RelacaoProdutoInsumo(String idProduto, String idInsumo, int quantidadeUsada) {
        this.idProduto = idProduto;
        this.idInsumo = idInsumo;
        this.quantidadeUsada = quantidadeUsada;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(String idInsumo) {
        this.idInsumo = idInsumo;
    }

    public int getQuantidadeUsada() {
        return quantidadeUsada;
    }

    public void setQuantidadeUsada(int quantidadeUsada) {
        this.quantidadeUsada = quantidadeUsada;
    }

    @Override
    public String toString() {
        return "RelacaoProdutoInsumo{ID Produto='" + idProduto + "', ID Insumo='" + idInsumo + "', Quantidade Usada=" + quantidadeUsada + "}";
    }
}
