package br.com_ifg.model;

import junit.framework.TestCase;

public class TesteProduto extends TestCase {
    public void testProduto() {
        Produto p = new Produto("1", "Produto A", "Descrição do Produto A", 99.99);
        assertEquals("1", p.getIdProduto());
        assertEquals("Produto A", p.getNome());
        assertEquals("Descrição do Produto A", p.getDescricao());
        assertEquals(99.99, p.getPreco());
        System.out.println(p.toString());
    }
}
