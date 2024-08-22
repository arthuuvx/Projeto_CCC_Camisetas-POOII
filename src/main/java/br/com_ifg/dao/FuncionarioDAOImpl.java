// src/main/java/br/com_ifg/dao/FuncionarioDAOImpl.java
package br.com_ifg.dao;

import br.com_ifg.model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAOImpl implements FuncionarioDAO {
    private Connection connection;

    public FuncionarioDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (id_funcionario, nome, cargo, salario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getIdFuncionario());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCargo());
            stmt.setDouble(4, funcionario.getSalario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Funcionario findByID(String id) {
        String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Funcionario(
                        rs.getString("id_funcionario"),
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getDouble("salario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Funcionario> findAll() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                funcionarios.add(new Funcionario(
                        rs.getString("id_funcionario"),
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getDouble("salario")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    @Override
    public void update(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, cargo = ?, salario = ? WHERE id_funcionario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.setString(4, funcionario.getIdFuncionario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
