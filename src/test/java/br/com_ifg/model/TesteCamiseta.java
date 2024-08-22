package br.com_ifg.model;

import junit.framework.TestCase;

public class TesteCamiseta extends TestCase {
    public void testCamiseta() {
        Camiseta cam = new Camiseta("1", "Model A", "M", "Azul", 49.99);
        assertEquals("1", cam.getIdCamiseta());
        assertEquals("Model A", cam.getModelo());
        assertEquals("M", cam.getTamanho());
        assertEquals("Azul", cam.getCor());
        assertEquals(49.99, cam.getPreco());
        System.out.println(cam.toString());
    }
}
