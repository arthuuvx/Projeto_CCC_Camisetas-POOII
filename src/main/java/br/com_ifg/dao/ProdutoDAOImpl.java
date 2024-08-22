package br.com_ifg.dao;

import br.com_ifg.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAO {
    private Connection connection;

    public ProdutoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Produto produto) {
        String sql = "INSERT INTO Produto (idProduto, nome, descricao, preco) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getIdProduto());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPreco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir produto", e);
        }
    }

    @Override
    public Produto findByID(String id) {
        String sql = "SELECT * FROM Produto WHERE idProduto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Produto(
                        rs.getString("idProduto"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("preco")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto", e);
        }
        return null;
    }

    @Override
    public List<Produto> findAll() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getString("idProduto"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("preco")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos", e);
        }
        return produtos;
    }

    @Override
    public void update(Produto produto) {
        String sql = "UPDATE Produto SET nome = ?, descricao = ?, preco = ? WHERE idProduto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setString(4, produto.getIdProduto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto", e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Produto WHERE idProduto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar produto", e);
        }
    }
}
