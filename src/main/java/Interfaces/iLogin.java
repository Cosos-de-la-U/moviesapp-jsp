package Interfaces;

import Model.Usuarios;

public interface iLogin {
    public Usuarios logIn(String carnet, String clave);
    public void logOut(Usuarios usuarios);
}
