package br.com_ifg.model;

import junit.framework.TestCase;

public class TesteEstoque extends TestCase {
    public void testEstoque() {
        Estoque e = new Estoque("P1", "I1", 100);
        assertEquals("P1", e.getIdProduto());
        assertEquals("I1", e.getIdInsumo());
        assertEquals(100, e.getQuantidadeDisponivel());
        System.out.println(e.toString());
    }
}
