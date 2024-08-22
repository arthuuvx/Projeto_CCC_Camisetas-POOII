package br.com_ifg.dao;

import br.com_ifg.model.RelacaoProdutoInsumo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelacaoProdutoInsumoDAOImpl implements RelacaoProdutoInsumoDAO {
    private Connection connection;

    public RelacaoProdutoInsumoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(RelacaoProdutoInsumo relacao) {
        String sql = "INSERT INTO RelacaoProdutoInsumo (idProduto, idInsumo, quantidadeUsada) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, relacao.getIdProduto());
            stmt.setString(2, relacao.getIdInsumo());
            stmt.setInt(3, relacao.getQuantidadeUsada());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir relação produto-insumo", e);
        }
    }

    @Override
    public RelacaoProdutoInsumo findByID(String id) {
        // Assume-se que o ID seja uma combinação de idProduto e idInsumo
        // Caso seja necessário um método diferente para encontrar pelo ID composto, este precisa ser ajustado
        String sql = "SELECT * FROM RelacaoProdutoInsumo WHERE idProduto = ? AND idInsumo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            String[] ids = id.split(":"); // Assumindo que o ID composto seja separado por ':'
            if (ids.length != 2) {
                throw new IllegalArgumentException("ID composto inválido");
            }
            stmt.setString(1, ids[0]);
            stmt.setString(2, ids[1]);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new RelacaoProdutoInsumo(
                        rs.getString("idProduto"),
                        rs.getString("idInsumo"),
                        rs.getInt("quantidadeUsada")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar relação produto-insumo", e);
        }
        return null;
    }

    @Override
    public List<RelacaoProdutoInsumo> findAll() {
        List<RelacaoProdutoInsumo> relacoes = new ArrayList<>();
        String sql = "SELECT * FROM RelacaoProdutoInsumo";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                relacoes.add(new RelacaoProdutoInsumo(
                        rs.getString("idProduto"),
                        rs.getString("idInsumo"),
                        rs.getInt("quantidadeUsada")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar relações produto-insumo", e);
        }
        return relacoes;
    }

    @Override
    public void update(RelacaoProdutoInsumo relacao) {
        String sql = "UPDATE RelacaoProdutoInsumo SET quantidadeUsada = ? WHERE idProduto = ? AND idInsumo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, relacao.getQuantidadeUsada());
            stmt.setString(2, relacao.getIdProduto());
            stmt.setString(3, relacao.getIdInsumo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar relação produto-insumo", e);
        }
    }

    @Override
    public void delete(String id) {
        // Assume-se que o ID seja uma combinação de idProduto e idInsumo
        // Caso seja necessário um método diferente para deletar pelo ID composto, este precisa ser ajustado
        String sql = "DELETE FROM RelacaoProdutoInsumo WHERE idProduto = ? AND idInsumo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            String[] ids = id.split(":"); // Assumindo que o ID composto seja separado por ':'
            if (ids.length != 2) {
                throw new IllegalArgumentException("ID composto inválido");
            }
            stmt.setString(1, ids[0]);
            stmt.setString(2, ids[1]);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar relação produto-insumo", e);
        }
    }
}
