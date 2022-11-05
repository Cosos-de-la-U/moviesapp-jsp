package Interfaces;

import Model.Peliculas;

import java.sql.SQLException;
import java.util.List;

public interface iPeliculas {
    public Peliculas select(int id);
    public List<Peliculas> selectAll();
    public void insert(Peliculas peliculas) throws SQLException;
    public boolean edit(Peliculas peliculas) throws SQLException;
    public boolean delete(int id) throws SQLException;
}
