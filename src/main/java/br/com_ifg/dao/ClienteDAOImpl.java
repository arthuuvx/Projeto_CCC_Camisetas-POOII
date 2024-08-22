// src/main/java/br/com_ifg/dao/ClienteDAOImpl.java
package br.com_ifg.dao;

import br.com_ifg.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    private Connection connection;

    public ClienteDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Cliente cliente) {
        String sql = "INSERT INTO Cliente (idCliente, nome, endereco, email, cpf) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getIdCliente());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir cliente", e);
        }
    }

    @Override
    public Cliente findByID(String id) {
        String sql = "SELECT * FROM Cliente WHERE idCliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                        rs.getString("idCliente"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("cpf")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar cliente", e);
        }
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getString("idCliente"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("cpf")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao listar clientes", e);
        }
        return clientes;
    }

    @Override
    public void update(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome = ?, endereco = ?, email = ?, cpf = ? WHERE idCliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getIdCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar cliente", e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Cliente WHERE idCliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar cliente", e);
        }
    }
}
