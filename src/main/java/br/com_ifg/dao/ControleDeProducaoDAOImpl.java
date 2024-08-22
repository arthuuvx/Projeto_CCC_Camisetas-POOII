package br.com_ifg.dao;

import br.com_ifg.model.ControleDeProducao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControleDeProducaoDAOImpl implements ControleDeProducaoDAO {
    private Connection connection;

    public ControleDeProducaoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(ControleDeProducao controleDeProducao) {
        String sql = "INSERT INTO ControleDeProducao (idControleDeProducao, idCamiseta, quantidadeProduzida, dataProducao, energiaGasta, manutencao, gastoAgua, gastoMaoDeObra, gastosInternos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, controleDeProducao.getIdControleDeProducao());
            stmt.setString(2, controleDeProducao.getIdCamiseta());
            stmt.setInt(3, controleDeProducao.getQuantidadeProduzida());
            stmt.setDate(4, new java.sql.Date(controleDeProducao.getDataProducao().getTime()));
            stmt.setDouble(5, controleDeProducao.getEnergiaGasta());
            stmt.setDouble(6, controleDeProducao.getManutencao());
            stmt.setDouble(7, controleDeProducao.getGastoAgua());
            stmt.setDouble(8, controleDeProducao.getGastoMaoDeObra());
            stmt.setDouble(9, controleDeProducao.getGastosInternos());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir controle de produção", e);
        }
    }

    @Override
    public ControleDeProducao findByID(String id) {
        String sql = "SELECT * FROM ControleDeProducao WHERE idControleDeProducao = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ControleDeProducao(
                        rs.getString("idControleDeProducao"),
                        rs.getString("idCamiseta"),
                        rs.getInt("quantidadeProduzida"),
                        rs.getDate("dataProducao"),
                        rs.getDouble("energiaGasta"),
                        rs.getDouble("manutencao"),
                        rs.getDouble("gastoAgua"),
                        rs.getDouble("gastoMaoDeObra"),
                        rs.getDouble("gastosInternos")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar controle de produção", e);
        }
        return null;
    }

    @Override
    public List<ControleDeProducao> findAll() {
        List<ControleDeProducao> controleDeProducoes = new ArrayList<>();
        String sql = "SELECT * FROM ControleDeProducao";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                controleDeProducoes.add(new ControleDeProducao(
                        rs.getString("idControleDeProducao"),
                        rs.getString("idCamiseta"),
                        rs.getInt("quantidadeProduzida"),
                        rs.getDate("dataProducao"),
                        rs.getDouble("energiaGasta"),
                        rs.getDouble("manutencao"),
                        rs.getDouble("gastoAgua"),
                        rs.getDouble("gastoMaoDeObra"),
                        rs.getDouble("gastosInternos")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar controles de produção", e);
        }
        return controleDeProducoes;
    }

    @Override
    public void update(ControleDeProducao controleDeProducao) {
        String sql = "UPDATE ControleDeProducao SET idCamiseta = ?, quantidadeProduzida = ?, dataProducao = ?, energiaGasta = ?, manutencao = ?, gastoAgua = ?, gastoMaoDeObra = ?, gastosInternos = ? WHERE idControleDeProducao = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, controleDeProducao.getIdCamiseta());
            stmt.setInt(2, controleDeProducao.getQuantidadeProduzida());
            stmt.setDate(3, new java.sql.Date(controleDeProducao.getDataProducao().getTime()));
            stmt.setDouble(4, controleDeProducao.getEnergiaGasta());
            stmt.setDouble(5, controleDeProducao.getManutencao());
            stmt.setDouble(6, controleDeProducao.getGastoAgua());
            stmt.setDouble(7, controleDeProducao.getGastoMaoDeObra());
            stmt.setDouble(8, controleDeProducao.getGastosInternos());
            stmt.setString(9, controleDeProducao.getIdControleDeProducao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar controle de produção", e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM ControleDeProducao WHERE idControleDeProducao = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar controle de produção", e);
        }
    }
}
