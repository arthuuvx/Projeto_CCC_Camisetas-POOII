package br.com_ifg.model;

public class Cliente {
    private String idCliente;
    private String nome;
    private String endereco;
    private String email;
    private String cpf;

    public Cliente(String idCliente, String nome, String endereco, String email, String cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.cpf = cpf;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{ID Cliente='" + idCliente + "', Nome='" + nome + "', Endereço='" + endereco + "', Email='" + email + "', CPF='" + cpf + "'}";
    }
}
