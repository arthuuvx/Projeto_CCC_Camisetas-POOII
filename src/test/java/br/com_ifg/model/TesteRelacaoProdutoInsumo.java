package br.com_ifg.model;

import junit.framework.TestCase;

public class TesteRelacaoProdutoInsumo extends TestCase {
    public void testRelacaoProdutoInsumo() {
        RelacaoProdutoInsumo rpi = new RelacaoProdutoInsumo("P1", "I1", 50);
        assertEquals("P1", rpi.getIdProduto());
        assertEquals("I1", rpi.getIdInsumo());
        assertEquals(50, rpi.getQuantidadeUsada());
        System.out.println(rpi.toString());
    }
}
