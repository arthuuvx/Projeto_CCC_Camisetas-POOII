package br.com_ifg.dao;

import br.com_ifg.model.Estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAOImpl implements EstoqueDAO {
    private Connection connection;

    public EstoqueDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Estoque estoque) {
        String sql = "INSERT INTO Estoque (idProduto, idInsumo, quantidadeDisponivel) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, estoque.getIdProduto());
            stmt.setString(2, estoque.getIdInsumo());
            stmt.setInt(3, estoque.getQuantidadeDisponivel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir estoque", e);
        }
    }

    @Override
    public Estoque findByID(String[] id) {
        if (id.length != 2) {
            throw new IllegalArgumentException("ID deve conter dois elementos: idProduto e idInsumo");
        }

        String idProduto = id[0];
        String idInsumo = id[1];
        String sql = "SELECT * FROM Estoque WHERE idProduto = ? AND idInsumo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idProduto);
            stmt.setString(2, idInsumo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estoque(
                        rs.getString("idProduto"),
                        rs.getString("idInsumo"),
                        rs.getInt("quantidadeDisponivel")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar estoque", e);
        }
        return null;
    }

    @Override
    public List<Estoque> findAll() {
        List<Estoque> estoques = new ArrayList<>();
        String sql = "SELECT * FROM Estoque";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                estoques.add(new Estoque(
                        rs.getString("idProduto"),
                        rs.getString("idInsumo"),
                        rs.getInt("quantidadeDisponivel")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar estoques", e);
        }
        return estoques;
    }

    @Override
    public void update(Estoque estoque) {
        String sql = "UPDATE Estoque SET quantidadeDisponivel = ? WHERE idProduto = ? AND idInsumo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, estoque.getQuantidadeDisponivel());
            stmt.setString(2, estoque.getIdProduto());
            stmt.setString(3, estoque.getIdInsumo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar estoque", e);
        }
    }

    @Override
    public void delete(String[] id) {
        if (id.length != 2) {
            throw new IllegalArgumentException("ID deve conter dois elementos: idProduto e idInsumo");
        }

        String idProduto = id[0];
        String idInsumo = id[1];
        String sql = "DELETE FROM Estoque WHERE idProduto = ? AND idInsumo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idProduto);
            stmt.setString(2, idInsumo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar estoque", e);
        }
    }
}
