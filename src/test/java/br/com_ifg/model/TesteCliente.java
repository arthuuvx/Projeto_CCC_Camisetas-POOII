package br.com_ifg.model;

import junit.framework.TestCase;

public class TesteCliente extends TestCase {
    public void testeCliente() {
        Cliente c = new Cliente("1", "Maria Oliveira", "Rua das Flores", "maria@exemplo.com", "123.456.789-00");
        assertEquals("1", c.getIdCliente());
        assertEquals("Maria Oliveira", c.getNome());
        assertEquals("Rua das Flores", c.getEndereco());
        assertEquals("maria@exemplo.com", c.getEmail());
        assertEquals("123.456.789-00", c.getCpf());
        System.out.println(c.toString());
    }
}
