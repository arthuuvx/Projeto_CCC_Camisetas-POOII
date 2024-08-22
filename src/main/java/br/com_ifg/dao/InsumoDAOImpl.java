package br.com_ifg.dao;

import br.com_ifg.model.Insumo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsumoDAOImpl implements InsumoDAO {
    private Connection connection;

    public InsumoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Insumo insumo) {
        String sql = "INSERT INTO Insumo (idInsumo, nome, descricao, precoUnitario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, insumo.getIdInsumo());
            stmt.setString(2, insumo.getNome());
            stmt.setString(3, insumo.getDescricao());
            stmt.setDouble(4, insumo.getPrecoUnitario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir insumo", e);
        }
    }

    @Override
    public Insumo findByID(String id) {
        String sql = "SELECT * FROM Insumo WHERE idInsumo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Insumo(
                        rs.getString("idInsumo"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("precoUnitario")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar insumo", e);
        }
        return null;
    }

    @Override
    public List<Insumo> findAll() {
        List<Insumo> insumos = new ArrayList<>();
        String sql = "SELECT * FROM Insumo";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                insumos.add(new Insumo(
                        rs.getString("idInsumo"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("precoUnitario")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar insumos", e);
        }
        return insumos;
    }

    @Override
    public void update(Insumo insumo) {
        String sql = "UPDATE Insumo SET nome = ?, descricao = ?, precoUnitario = ? WHERE idInsumo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, insumo.getNome());
            stmt.setString(2, insumo.getDescricao());
            stmt.setDouble(3, insumo.getPrecoUnitario());
            stmt.setString(4, insumo.getIdInsumo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar insumo", e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Insumo WHERE idInsumo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar insumo", e);
        }
    }
}
