package br.com_ifg.model;

import java.util.Date;

public class ControleDeVenda {
    private String idControleDeVenda;
    private String idCliente;
    private String idCamiseta;
    private int quantidade;
    private Date dataVenda;

    public ControleDeVenda(String idControleDeVenda, String idCliente, String idCamiseta, int quantidade, Date dataVenda) {
        this.idControleDeVenda = idControleDeVenda;
        this.idCliente = idCliente;
        this.idCamiseta = idCamiseta;
        this.quantidade = quantidade;
        this.dataVenda = dataVenda;
    }

    public String getIdControleDeVenda() {
        return idControleDeVenda;
    }

    public void setIdControleDeVenda(String idControleDeVenda) {
        this.idControleDeVenda = idControleDeVenda;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdCamiseta() {
        return idCamiseta;
    }

    public void setIdCamiseta(String idCamiseta) {
        this.idCamiseta = idCamiseta;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public String toString() {
        return "ControleDeVenda{ID Controle de Venda='" + idControleDeVenda + "', ID Cliente='" + idCliente + "', ID Camiseta='" + idCamiseta + "', Quantidade=" + quantidade + ", Data Venda=" + dataVenda + "}";
    }
}
