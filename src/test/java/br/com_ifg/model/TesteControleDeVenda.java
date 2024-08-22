package br.com_ifg.model;

import junit.framework.TestCase;

import java.util.Date;

public class TesteControleDeVenda extends TestCase {
    public void testControleDeVenda() {
        ControleDeVenda cv = new ControleDeVenda("1", "C1", "M1", 10, new Date());
        assertEquals("1", cv.getIdControleDeVenda());
        assertEquals("C1", cv.getIdCliente());
        assertEquals("M1", cv.getIdCamiseta());
        assertEquals(10, cv.getQuantidade());
        assertNotNull(cv.getDataVenda());
        System.out.println(cv.toString());
    }
}
