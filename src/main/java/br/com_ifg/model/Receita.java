package br.com_ifg.model;

import java.util.Date;

public class Receita {
    private String idReceita;
    private double valorTotal;
    private Date data;

    public Receita(String idReceita, double valorTotal, Date data) {
        this.idReceita = idReceita;
        this.valorTotal = valorTotal;
        this.data = data;
    }

    public String getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(String idReceita) {
        this.idReceita = idReceita;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Receita{ID Receita='" + idReceita + "', Valor Total=" + valorTotal + ", Data=" + data + "}";
    }
}
