package br.com_ifg.dao;

import br.com_ifg.model.ControleDeVenda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControleDeVendaDAOImpl implements ControleDeVendaDAO {
    private Connection connection;

    public ControleDeVendaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(ControleDeVenda controleDeVenda) {
        String sql = "INSERT INTO ControleDeVenda (idControleDeVenda, idCliente, idCamiseta, quantidade, dataVenda) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, controleDeVenda.getIdControleDeVenda());
            stmt.setString(2, controleDeVenda.getIdCliente());
            stmt.setString(3, controleDeVenda.getIdCamiseta());
            stmt.setInt(4, controleDeVenda.getQuantidade());
            stmt.setDate(5, new java.sql.Date(controleDeVenda.getDataVenda().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir controle de venda", e);
        }
    }

    @Override
    public ControleDeVenda findByID(String id) {
        String sql = "SELECT * FROM ControleDeVenda WHERE idControleDeVenda = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ControleDeVenda(
                        rs.getString("idControleDeVenda"),
                        rs.getString("idCliente"),
                        rs.getString("idCamiseta"),
                        rs.getInt("quantidade"),
                        rs.getDate("dataVenda")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar controle de venda", e);
        }
        return null;
    }

    @Override
    public List<ControleDeVenda> findAll() {
        List<ControleDeVenda> controleDeVendas = new ArrayList<>();
        String sql = "SELECT * FROM ControleDeVenda";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                controleDeVendas.add(new ControleDeVenda(
                        rs.getString("idControleDeVenda"),
                        rs.getString("idCliente"),
                        rs.getString("idCamiseta"),
                        rs.getInt("quantidade"),
                        rs.getDate("dataVenda")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar controles de venda", e);
        }
        return controleDeVendas;
    }

    @Override
    public void update(ControleDeVenda controleDeVenda) {
        String sql = "UPDATE ControleDeVenda SET idCliente = ?, idCamiseta = ?, quantidade = ?, dataVenda = ? WHERE idControleDeVenda = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, controleDeVenda.getIdCliente());
            stmt.setString(2, controleDeVenda.getIdCamiseta());
            stmt.setInt(3, controleDeVenda.getQuantidade());
            stmt.setDate(4, new java.sql.Date(controleDeVenda.getDataVenda().getTime()));
            stmt.setString(5, controleDeVenda.getIdControleDeVenda());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar controle de venda", e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM ControleDeVenda WHERE idControleDeVenda = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar controle de venda", e);
        }
    }
}
