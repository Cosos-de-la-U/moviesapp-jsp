package DB.Queries;

public class qPeliculas {
    //BASIC
    public static final String SELECT_PELICULAS = "SELECT * FROM peliculas WHERE idpelicula = ?;";
    public static final String SELECT_ALL_PELICULAS = "SELECT * FROM peliculas;";
    public static final String INSERT_PELICULAS = "INSERT INTO peliculas(nombre, nomb_ingles, yearp, duracion) VALUES (?, ?, ?, ?);";
    public static final String UPDATE_PELICULAS = "UPDATE  peliculas SET nombre = ?, nomb_ingles = ?, yearp = ?, duracion = ? WHERE idpelicula = ?;";
    public static final String DELETE_PELICULAS = "DELETE FROM peliculas WHERE idpelicula = ?;";

    //VIEW


    //EXTRA
}
