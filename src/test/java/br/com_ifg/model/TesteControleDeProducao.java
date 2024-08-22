package br.com_ifg.model;

import junit.framework.TestCase;

import java.util.Date;

public class TesteControleDeProducao extends TestCase {
    public void testControleDeProducao() {
        ControleDeProducao cp = new ControleDeProducao("1", "C1", 200, new Date(), 50.0, 20.0, 10.0, 15.0, 25.0);
        assertEquals("1", cp.getIdControleDeProducao());
        assertEquals("C1", cp.getIdCamiseta());
        assertEquals(200, cp.getQuantidadeProduzida());
        assertNotNull(cp.getDataProducao());
        assertEquals(50.0, cp.getEnergiaGasta());
        assertEquals(20.0, cp.getManutencao());
        assertEquals(10.0, cp.getGastoAgua());
        assertEquals(15.0, cp.getGastoMaoDeObra());
        assertEquals(25.0, cp.getGastosInternos());
        System.out.println(cp.toString());
    }
}
