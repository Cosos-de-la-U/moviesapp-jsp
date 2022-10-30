package DB.Queries;

public class qUsuarios {
    //BASIC
    public static final String SELECT_USUARIOS = "SELECT * FROM usuarios WHERE idusuarios = ?;";
    public static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuarios;";
    public static final String INSERT_USUARIOS = "INSERT INTO usuarios(usuarios) VALUES (?);";
    public static final String UPDATE_USUARIOS = "UPDATE usuarios SET usuarios WHERE idusuarios = ?;";
    public static final String DELETE_USUARIOS = "DELETE FROM usuarios WHERE idusuarios = ?;";

    //VIEW


    //EXTRA
    public static final String SELECT_USUARIOS_LOGIN = "SELECT * FROM usuarios WHERE carnet = ? AND clave = ?;";
}
