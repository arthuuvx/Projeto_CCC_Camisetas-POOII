package br.com_ifg.model;

import junit.framework.TestCase;

public class TesteInsumo extends TestCase {
    public void testInsumo() {
        Insumo i = new Insumo("1", "Insumo A", "Descrição do Insumo A", 5.50);
        assertEquals("1", i.getIdInsumo());
        assertEquals("Insumo A", i.getNome());
        assertEquals("Descrição do Insumo A", i.getDescricao());
        assertEquals(5.50, i.getPrecoUnitario());
        System.out.println(i.toString());
    }
}
