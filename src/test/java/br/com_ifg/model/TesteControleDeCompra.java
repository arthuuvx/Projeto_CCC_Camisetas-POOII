package br.com_ifg.model;

import junit.framework.TestCase;

public class TesteControleDeCompra extends TestCase {
    public void testControleDeCompra() {
        ControleDeCompra cc = new ControleDeCompra("1", "P1", 100);
        assertEquals("1", cc.getId());
        assertEquals("P1", cc.getIdProduto());
        assertEquals(100, cc.getQuantidade());
        System.out.println(cc.toString());
    }
}
