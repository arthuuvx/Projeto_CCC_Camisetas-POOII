package br.com_ifg.model;

import junit.framework.TestCase;

public class TesteFornecedor extends TestCase {
    public void testFornecedor() {
        Fornecedor f = new Fornecedor("1", "Fornecedor A", "Rua dos Fornecedores", "contato@fornecedor.com");
        assertEquals("1", f.getIdFornecedor());
        assertEquals("Fornecedor A", f.getNome());
        assertEquals("Rua dos Fornecedores", f.getEndereco());
        assertEquals("contato@fornecedor.com", f.getContato());
        System.out.println(f.toString());
    }
}
