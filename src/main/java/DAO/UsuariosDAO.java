package DAO;

import Interfaces.iUsuarios;
import Model.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.PostgresDriver.getConnection;
import static DB.PostgresDriver.printSQLException;
import static DB.Queries.qUsuarios.*;

public class UsuariosDAO implements iUsuarios {

    @Override
    public Usuarios select(String carnetUser) {
        Usuarios usuarios = null;
        //Establishing a connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USUARIOS)) {
            //Create statement
            preparedStatement.setString(1, carnetUser);
            System.out.println(preparedStatement);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            //Process ResultSet
            while (rs.next()) {
                String carnet = rs.getString("carnet");
                String nom_usuario = rs.getString("nom_usuario");
                String ape_usuario = rs.getString("ape_usuario");
                String tipo = rs.getString("tipo");
                String telcasa = rs.getString("telcasa");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                String estado = rs.getString("estado");
                String clave = rs.getString("clave");
                int acessosistemas = rs.getInt("acessosistemas");
                int esadministrador = rs.getInt("esadministrador");
                //We create the object
                usuarios = new Usuarios(carnet, nom_usuario, ape_usuario, tipo, telcasa, celular, email, estado, clave, acessosistemas, esadministrador);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return usuarios;
    }

    @Override
    public List<Usuarios> selectAll() {
        List<Usuarios> usuarios = new ArrayList<>();
        //Establishing a connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USUARIOS)) {
            //Create statement
            System.out.println(preparedStatement);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            //Process ResultSet
            while (rs.next()) {
                String carnet = rs.getString("carnet");
                String nom_usuario = rs.getString("nom_usuario");
                String ape_usuario = rs.getString("ape_usuario");
                String tipo = rs.getString("tipo");
                String telcasa = rs.getString("telcasa");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                String estado = rs.getString("estado");
                String clave = rs.getString("clave");
                int acessosistemas = rs.getInt("acessosistemas");
                int esadministrador = rs.getInt("esadministrador");
                //We create the object
                usuarios.add(new Usuarios(carnet, nom_usuario, ape_usuario, tipo, telcasa, celular, email, estado, clave, acessosistemas, esadministrador));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return usuarios;
    }

    @Override
    public void insert(Usuarios usuarios) throws SQLException{
        System.out.println(INSERT_USUARIOS);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USUARIOS);){
            //Preparing the query
            preparedStatement.setString(1, usuarios.getNom_usuario());
            preparedStatement.setString(2, usuarios.getApe_usuario());
            preparedStatement.setString(3, usuarios.getTipo());
            preparedStatement.setString(4, usuarios.getTelcasa());
            preparedStatement.setString(5, usuarios.getCelular());
            preparedStatement.setString(6, usuarios.getEmail());
            preparedStatement.setString(7, usuarios.getEstado());
            preparedStatement.setString(8, usuarios.getClave());
            preparedStatement.setInt(9, usuarios.getAcessosistemas());
            preparedStatement.setInt(10, usuarios.getEsadministrador());
            //Execute statement
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean edit(Usuarios usuarios) throws SQLException{
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USUARIOS);){
            System.out.println("Updated Categoria: " + preparedStatement);
            //Prepare query
            preparedStatement.setString(1, usuarios.getNom_usuario());
            preparedStatement.setString(2, usuarios.getApe_usuario());
            preparedStatement.setString(3, usuarios.getTipo());
            preparedStatement.setString(4, usuarios.getTelcasa());
            preparedStatement.setString(5, usuarios.getCelular());
            preparedStatement.setString(6, usuarios.getEmail());
            preparedStatement.setString(7, usuarios.getEstado());
            preparedStatement.setString(8, usuarios.getClave());
            preparedStatement.setInt(9, usuarios.getAcessosistemas());
            preparedStatement.setInt(10, usuarios.getEsadministrador());
            preparedStatement.setString(11, usuarios.getCarnet());
            //Check is there is any changes
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(Usuarios usuarios) throws SQLException{
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USUARIOS);){
            //Prepare query
            preparedStatement.setString(1, usuarios.getCarnet());
            //Check is there is any changes
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
