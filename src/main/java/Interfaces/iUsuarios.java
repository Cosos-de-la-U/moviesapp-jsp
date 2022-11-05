package Interfaces;

import Model.Usuarios;

import java.sql.SQLException;
import java.util.List;

public interface iUsuarios {
    public Usuarios select(String carnet);
    public List<Usuarios> selectAll();
    public void insert(Usuarios usuarios) throws SQLException;
    public boolean edit(Usuarios usuarios) throws SQLException;
    public boolean delete(String carnet) throws SQLException;
}
