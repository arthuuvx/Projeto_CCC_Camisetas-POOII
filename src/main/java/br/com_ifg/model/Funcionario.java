package br.com_ifg.model;

public class Funcionario {
    private String idFuncionario;
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String idFuncionario, String nome, String cargo, double salario) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{ID Funcionário='" + idFuncionario + "', Nome='" + nome + "', Cargo='" + cargo + "', Salário=" + salario + "}";
    }
}
