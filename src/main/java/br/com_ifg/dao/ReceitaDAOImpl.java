package br.com_ifg.dao;

import br.com_ifg.model.Receita;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDAOImpl implements ReceitaDAO {
    private Connection connection;

    public ReceitaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Receita receita) {
        String sql = "INSERT INTO Receita (idReceita, valorTotal, data) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, receita.getIdReceita());
            stmt.setDouble(2, receita.getValorTotal());
            stmt.setDate(3, new java.sql.Date(receita.getData().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir receita", e);
        }
    }

    @Override
    public Receita findByID(String id) {
        String sql = "SELECT * FROM Receita WHERE idReceita = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Receita(
                        rs.getString("idReceita"),
                        rs.getDouble("valorTotal"),
                        rs.getDate("data")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar receita", e);
        }
        return null;
    }

    @Override
    public List<Receita> findAll() {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT * FROM Receita";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                receitas.add(new Receita(
                        rs.getString("idReceita"),
                        rs.getDouble("valorTotal"),
                        rs.getDate("data")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar receitas", e);
        }
        return receitas;
    }

    @Override
    public void update(Receita receita) {
        String sql = "UPDATE Receita SET valorTotal = ?, data = ? WHERE idReceita = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, receita.getValorTotal());
            stmt.setDate(2, new java.sql.Date(receita.getData().getTime()));
            stmt.setString(3, receita.getIdReceita());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar receita", e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Receita WHERE idReceita = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar receita", e);
        }
    }
}
