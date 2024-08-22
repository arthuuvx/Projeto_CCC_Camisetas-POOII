package br.com_ifg.model;

import junit.framework.TestCase;

import java.util.Date;

public class TesteReceita extends TestCase {
    public void testReceita() {
        Receita r = new Receita("1", 1000.0, new Date());
        assertEquals("1", r.getIdReceita());
        assertEquals(1000.0, r.getValorTotal());
        assertNotNull(r.getData());
        System.out.println(r.toString());
    }
}
