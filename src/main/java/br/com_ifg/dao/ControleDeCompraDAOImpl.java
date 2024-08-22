package br.com_ifg.dao;

import br.com_ifg.model.ControleDeCompra;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControleDeCompraDAOImpl implements ControleDeCompraDAO {
    private Connection connection;

    public ControleDeCompraDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(ControleDeCompra controleDeCompra) {
        String sql = "INSERT INTO ControleDeCompra (id, idProduto, quantidade) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, controleDeCompra.getId());
            stmt.setString(2, controleDeCompra.getIdProduto());
            stmt.setInt(3, controleDeCompra.getQuantidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir controle de compra", e);
        }
    }

    @Override
    public ControleDeCompra findByID(String id) {
        String sql = "SELECT * FROM ControleDeCompra WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ControleDeCompra(
                        rs.getString("id"),
                        rs.getString("idProduto"),
                        rs.getInt("quantidade")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar controle de compra", e);
        }
        return null;
    }

    @Override
    public List<ControleDeCompra> findAll() {
        List<ControleDeCompra> controleDeCompras = new ArrayList<>();
        String sql = "SELECT * FROM ControleDeCompra";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                controleDeCompras.add(new ControleDeCompra(
                        rs.getString("id"),
                        rs.getString("idProduto"),
                        rs.getInt("quantidade")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar controle de compras", e);
        }
        return controleDeCompras;
    }

    @Override
    public void update(ControleDeCompra controleDeCompra) {
        String sql = "UPDATE ControleDeCompra SET idProduto = ?, quantidade = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, controleDeCompra.getIdProduto());
            stmt.setInt(2, controleDeCompra.getQuantidade());
            stmt.setString(3, controleDeCompra.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar controle de compra", e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM ControleDeCompra WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar controle de compra", e);
        }
    }
}
