package br.com_ifg.dao;

import br.com_ifg.model.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAOImpl implements FornecedorDAO {
    private Connection connection;

    public FornecedorDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Fornecedor fornecedor) {
        String sql = "INSERT INTO Fornecedor (idFornecedor, nome, endereco, contato) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getIdFornecedor());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getContato());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir fornecedor", e);
        }
    }

    @Override
    public Fornecedor findByID(String id) {
        String sql = "SELECT * FROM Fornecedor WHERE idFornecedor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Fornecedor(
                        rs.getString("idFornecedor"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("contato")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar fornecedor", e);
        }
        return null;
    }

    @Override
    public List<Fornecedor> findAll() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM Fornecedor";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                fornecedores.add(new Fornecedor(
                        rs.getString("idFornecedor"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("contato")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar fornecedores", e);
        }
        return fornecedores;
    }

    @Override
    public void update(Fornecedor fornecedor) {
        String sql = "UPDATE Fornecedor SET nome = ?, endereco = ?, contato = ? WHERE idFornecedor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEndereco());
            stmt.setString(3, fornecedor.getContato());
            stmt.setString(4, fornecedor.getIdFornecedor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar fornecedor", e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Fornecedor WHERE idFornecedor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar fornecedor", e);
        }
    }
}
