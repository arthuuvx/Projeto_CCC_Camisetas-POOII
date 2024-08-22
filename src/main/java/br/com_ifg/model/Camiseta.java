package br.com_ifg.model;

public class Camiseta {
    private String idCamiseta;
    private String modelo;
    private String tamanho;
    private String cor;
    private double preco;

    public Camiseta(String idCamiseta, String modelo, String tamanho, String cor, double preco) {
        this.idCamiseta = idCamiseta;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.cor = cor;
        this.preco = preco;
    }

    public String getIdCamiseta() {
        return idCamiseta;
    }

    public void setIdCamiseta(String idCamiseta) {
        this.idCamiseta = idCamiseta;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Camiseta{ID Camiseta='" + idCamiseta + "', Modelo='" + modelo + "', Tamanho='" + tamanho + "', Cor='" + cor + "', Preço=" + preco + "}";
    }
}
