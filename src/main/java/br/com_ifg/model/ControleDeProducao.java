package br.com_ifg.model;

import java.util.Date;

public class ControleDeProducao {
    private String idControleDeProducao;
    private String idCamiseta;
    private int quantidadeProduzida;
    private Date dataProducao;
    private double energiaGasta;
    private double manutencao;
    private double gastoAgua;
    private double gastoMaoDeObra;
    private double gastosInternos;

    public ControleDeProducao(String idControleDeProducao, String idCamiseta, int quantidadeProduzida, Date dataProducao, double energiaGasta, double manutencao, double gastoAgua, double gastoMaoDeObra, double gastosInternos) {
        this.idControleDeProducao = idControleDeProducao;
        this.idCamiseta = idCamiseta;
        this.quantidadeProduzida = quantidadeProduzida;
        this.dataProducao = dataProducao;
        this.energiaGasta = energiaGasta;
        this.manutencao = manutencao;
        this.gastoAgua = gastoAgua;
        this.gastoMaoDeObra = gastoMaoDeObra;
        this.gastosInternos = gastosInternos;
    }

    public String getIdControleDeProducao() {
        return idControleDeProducao;
    }

    public void setIdControleDeProducao(String idControleDeProducao) {
        this.idControleDeProducao = idControleDeProducao;
    }

    public String getIdCamiseta() {
        return idCamiseta;
    }

    public void setIdCamiseta(String idCamiseta) {
        this.idCamiseta = idCamiseta;
    }

    public int getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    public void setQuantidadeProduzida(int quantidadeProduzida) {
        this.quantidadeProduzida = quantidadeProduzida;
    }

    public Date getDataProducao() {
        return dataProducao;
    }

    public void setDataProducao(Date dataProducao) {
        this.dataProducao = dataProducao;
    }

    public double getEnergiaGasta() {
        return energiaGasta;
    }

    public void setEnergiaGasta(double energiaGasta) {
        this.energiaGasta = energiaGasta;
    }

    public double getManutencao() {
        return manutencao;
    }

    public void setManutencao(double manutencao) {
        this.manutencao = manutencao;
    }

    public double getGastoAgua() {
        return gastoAgua;
    }

    public void setGastoAgua(double gastoAgua) {
        this.gastoAgua = gastoAgua;
    }

    public double getGastoMaoDeObra() {
        return gastoMaoDeObra;
    }

    public void setGastoMaoDeObra(double gastoMaoDeObra) {
        this.gastoMaoDeObra = gastoMaoDeObra;
    }

    public double getGastosInternos() {
        return gastosInternos;
    }

    public void setGastosInternos(double gastosInternos) {
        this.gastosInternos = gastosInternos;
    }

    @Override
    public String toString() {
        return "ControleDeProducao{ID Controle de Produção='" + idControleDeProducao + "', ID Camiseta='" + idCamiseta + "', Quantidade Produzida=" + quantidadeProduzida + ", Data Produção=" + dataProducao + ", Energia Gasta=" + energiaGasta + ", Manutenção=" + manutencao + ", Gasto Água=" + gastoAgua + ", Gasto Mão de Obra=" + gastoMaoDeObra + ", Gastos Internos=" + gastosInternos + "}";
    }
}
