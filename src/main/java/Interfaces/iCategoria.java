package Interfaces;

import Model.Categoria;

import java.sql.SQLException;
import java.util.List;

public interface iCategoria {
    public Categoria select(int id);
    public List<Categoria> selectAll();
    public void insert(Categoria categoria) throws SQLException;
    public boolean edit(Categoria categoria) throws SQLException;
    public boolean delete(int id) throws SQLException;
}
