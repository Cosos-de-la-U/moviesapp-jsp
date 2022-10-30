package DAO;

import Interfaces.iLogin;
import Model.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DB.PostgresDriver.getConnection;
import static DB.PostgresDriver.printSQLException;
import static DB.Queries.qUsuarios.SELECT_USUARIOS_LOGIN;

public class LoginDAO implements iLogin {
    @Override
    public Usuarios logIn(String carnetRequested, String claveRequested) {
        Usuarios usuarioSession = null;
        //Establishing a connection
        try (Connection connection = getConnection();
             //Create statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USUARIOS_LOGIN);) {
            preparedStatement.setString(1, carnetRequested);
            preparedStatement.setString(2, claveRequested);
            System.out.println(preparedStatement);
            //Execute query
            ResultSet rs = preparedStatement.executeQuery();
            //Proccess the ResultSet object
            while (rs.next()){
                String carnet = rs.getString("carnet");
                String nom_usuario = rs.getString("nom_usuario");
                String ape_usuario = rs.getString("ape_usuario");
                String tipo = rs.getString("tipo");
                String telcasa = rs.getString("telcasa");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                String estado = rs.getString("estado");
                String clave = rs.getString("clave");
                int accessosistemas = rs.getInt("accessosistemas");
                int esadministrador = rs.getInt("esadministrador");
                usuarioSession = new Usuarios(carnet, nom_usuario, ape_usuario, tipo, telcasa, celular, email, estado, clave, accessosistemas, esadministrador);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return usuarioSession;
    }

    @Override
    public void logOut(Usuarios usuarios) {

    }
}
