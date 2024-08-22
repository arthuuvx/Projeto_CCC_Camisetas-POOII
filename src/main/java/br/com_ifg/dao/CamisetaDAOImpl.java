package br.com_ifg.dao;

import br.com_ifg.model.Camiseta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CamisetaDAOImpl implements CamisetaDAO {
    private Connection connection;

    public CamisetaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Camiseta camiseta) {
        String sql = "INSERT INTO Camiseta (idCamiseta, modelo, tamanho, cor, preco) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, camiseta.getIdCamiseta());
            stmt.setString(2, camiseta.getModelo());
            stmt.setString(3, camiseta.getTamanho());
            stmt.setString(4, camiseta.getCor());
            stmt.setDouble(5, camiseta.getPreco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir camiseta", e);
        }
    }

    @Override
    public Camiseta findByID(String id) {
        String sql = "SELECT * FROM Camiseta WHERE idCamiseta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Camiseta(
                        rs.getString("idCamiseta"),
                        rs.getString("modelo"),
                        rs.getString("tamanho"),
                        rs.getString("cor"),
                        rs.getDouble("preco")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar camiseta", e);
        }
        return null;
    }

    @Override
    public List<Camiseta> findAll() {
        List<Camiseta> camisetas = new ArrayList<>();
        String sql = "SELECT * FROM Camiseta";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                camisetas.add(new Camiseta(
                        rs.getString("idCamiseta"),
                        rs.getString("modelo"),
                        rs.getString("tamanho"),
                        rs.getString("cor"),
                        rs.getDouble("preco")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar camisetas", e);
        }
        return camisetas;
    }

    @Override
    public void update(Camiseta camiseta) {
        String sql = "UPDATE Camiseta SET modelo = ?, tamanho = ?, cor = ?, preco = ? WHERE idCamiseta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, camiseta.getModelo());
            stmt.setString(2, camiseta.getTamanho());
            stmt.setString(3, camiseta.getCor());
            stmt.setDouble(4, camiseta.getPreco());
            stmt.setString(5, camiseta.getIdCamiseta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar camiseta", e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Camiseta WHERE idCamiseta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar camiseta", e);
        }
    }
}
