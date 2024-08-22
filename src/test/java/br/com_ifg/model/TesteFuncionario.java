package br.com_ifg.model;

import junit.framework.TestCase;

public class TesteFuncionario extends TestCase {
    public void testeFuncionario() {
        Funcionario f = new Funcionario("1", "João Silva", "Gerente", 5000.0);
        assertEquals("1", f.getIdFuncionario());
        assertEquals("João Silva", f.getNome());
        assertEquals("Gerente", f.getCargo());
        assertEquals(5000.0, f.getSalario());
        System.out.println(f.toString());
    }
}
