package br.com_ifg.model;

public class ControleDeCompra {
    private String id;
    private String idProduto;
    private int quantidade;

    public ControleDeCompra(String id, String idProduto, int quantidade) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ControleDeCompra{ID='" + id + "', ID Produto='" + idProduto + "', Quantidade=" + quantidade + "}";
    }
}
