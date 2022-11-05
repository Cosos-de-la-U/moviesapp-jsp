package Interfaces;

import Model.Usuarios;
import Enum.TipoUsuario;

public interface iLogin {
    public Usuarios logIn(String carnet, String clave);
    public TipoUsuario validate(Usuarios usuarios);
    public void logOut(Usuarios usuarios);
}
