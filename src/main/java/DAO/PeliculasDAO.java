package DAO;


import Interfaces.iPeliculas;
import Model.Peliculas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.PostgresDriver.getConnection;
import static DB.PostgresDriver.printSQLException;
import static DB.Queries.qPeliculas.*;


public class PeliculasDAO implements iPeliculas {

    @Override
    public Peliculas select(int id) {
        Peliculas peliculas = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PELICULAS);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idpeliculas = rs.getInt("idpeliculas");
                String nombre = rs.getString("nombre");
                String nombreIngles = rs.getString("nomb_ingles");
                int yearp = rs.getInt("yearp");
                int duracion = rs.getInt("duracion");
                peliculas = new Peliculas(idpeliculas, nombre, nombreIngles, yearp, duracion);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return peliculas;
    }

    @Override
    public List<Peliculas> selectAll() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Peliculas> peliculas = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PELICULAS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idpeliculas = rs.getInt("idpeliculas");
                String nombre = rs.getString("nombre");
                String nombreIngles = rs.getString("nomb_ingles");
                int yearp = rs.getInt("yearp");
                int duracion = rs.getInt("duracion");
                peliculas.add(new Peliculas(idpeliculas, nombre, nombreIngles, yearp, duracion));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return peliculas;
    }

    @Override
    public void insert(Peliculas peliculas) throws SQLException {
        System.out.println(INSERT_PELICULAS);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PELICULAS)) {
            preparedStatement.setString(1, peliculas.getNombre());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean edit(Peliculas peliculas) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PELICULAS);) {
            System.out.println("updated Peliculas:"+statement);
            statement.setString(1, peliculas.getNombre());
            statement.setString(2, peliculas.getNomb_ingles());
            statement.setInt(3, peliculas.getYearp());
            statement.setInt(4, peliculas.getDuracion());
            statement.setInt(5, peliculas.getIdpelicula());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PELICULAS);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
