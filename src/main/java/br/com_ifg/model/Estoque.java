package br.com_ifg.model;

public class Estoque {
    private String idProduto;
    private String idInsumo;
    private int quantidadeDisponivel;

    public Estoque(String idProduto, String idInsumo, int quantidadeDisponivel) {
        this.idProduto = idProduto;
        this.idInsumo = idInsumo;
        this.quantidadeDisponivel = quantidadeDisponivel;
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

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public String toString() {
        return "Estoque{ID Produto='" + idProduto + "', ID Insumo='" + idInsumo + "', Quantidade Disponível=" + quantidadeDisponivel + "}";
    }
}
