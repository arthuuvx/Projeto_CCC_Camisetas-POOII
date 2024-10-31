package br.com_ifg.dao;

import br.com_ifg.model.Camiseta;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class TesteCamisetaDAO {
    private Connection connection;
    private CamisetaDAOImpl camisetaDAO;

    @Before
    public void setUp() throws SQLException {
        // Conectar ao banco de dados ccc_camisetas
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ccc_camisetas", "postgres", "aluno123");
        camisetaDAO = new CamisetaDAOImpl(connection);
    }

    @After
    public void tearDown() throws SQLException {
        // Fechar a conexão
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testSaveAndFindByID() {
        Camiseta camiseta = new Camiseta("1", "Modelo A", "M", "Azul", 49.99);
        camisetaDAO.save(camiseta);

        Camiseta found = camisetaDAO.findByID("1");
        assertNotNull(found);
        assertEquals("Modelo A", found.getModelo());
    }

    @Test
    public void testUpdate() {
        Camiseta camiseta = new Camiseta("2", "Modelo A", "M", "Azul", 49.99);
        camisetaDAO.save(camiseta);

        camiseta.setModelo("Modelo B");
        camisetaDAO.update(camiseta);

        Camiseta updated = camisetaDAO.findByID("2");
        assertEquals("Modelo B", updated.getModelo());
    }

    @Test
    public void testDelete() {
        Camiseta camiseta = new Camiseta("3", "Modelo A", "M", "Azul", 49.99);
        camisetaDAO.save(camiseta);
        camisetaDAO.delete("3");

        Camiseta deleted = camisetaDAO.findByID("3");
        assertNull(deleted);
    }

    @Test
    public void testFindAll() {
        camisetaDAO.save(new Camiseta("4", "Modelo A", "M", "Azul", 49.99));
        camisetaDAO.save(new Camiseta("5", "Modelo B", "G", "Verde", 59.99));

        List<Camiseta> camisetas = camisetaDAO.findAll();
        assertTrue(camisetas.size() >= 2); // Verifica se pelo menos duas camisetas foram adicionadas
    }
}
