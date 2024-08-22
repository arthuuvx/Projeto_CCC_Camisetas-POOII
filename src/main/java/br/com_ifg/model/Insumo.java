package br.com_ifg.model;

public class Insumo {
    private String idInsumo;
    private String nome;
    private String descricao;
    private double precoUnitario;

    public Insumo(String idInsumo, String nome, String descricao, double precoUnitario) {
        this.idInsumo = idInsumo;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
    }

    public String getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(String idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "Insumo{ID Insumo='" + idInsumo + "', Nome='" + nome + "', Descrição='" + descricao + "', Preço Unitário=" + precoUnitario + "}";
    }
}
