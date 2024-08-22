package br.com_ifg.model;

public class Fornecedor {
    private String idFornecedor;
    private String nome;
    private String endereco;
    private String contato;

    public Fornecedor(String idFornecedor, String nome, String endereco, String contato) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }

    public String getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(String idFornecedor) {
        this.idFornecedor = idFornecedor;
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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Fornecedor{ID Fornecedor='" + idFornecedor + "', Nome='" + nome + "', Endereço='" + endereco + "', Contato='" + contato + "'}";
    }
}
