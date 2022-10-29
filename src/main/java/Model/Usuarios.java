package Model;

public class Usuarios {
    private String carnet;
    private String nom_usuario;
    private String ape_usuario;
    private String tipo;
    private String celular;
    private String estado;
    private String clave;
    private int accessosistemas;
    private int esadministrador;

    public Usuarios(String carnet, String nom_usuario, String ape_usuario, String tipo, String celular, String estado, String clave, int accessosistemas, int esadministrador) {
        this.carnet = carnet;
        this.nom_usuario = nom_usuario;
        this.ape_usuario = ape_usuario;
        this.tipo = tipo;
        this.celular = celular;
        this.estado = estado;
        this.clave = clave;
        this.accessosistemas = accessosistemas;
        this.esadministrador = esadministrador;
    }

    public Usuarios(String carnet, String nom_usuario, String ape_usuario, String tipo, String celular, String estado, String clave, int esadministrador) {
        this.carnet = carnet;
        this.nom_usuario = nom_usuario;
        this.ape_usuario = ape_usuario;
        this.tipo = tipo;
        this.celular = celular;
        this.estado = estado;
        this.clave = clave;
        this.esadministrador = esadministrador;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public String getApe_usuario() {
        return ape_usuario;
    }

    public void setApe_usuario(String ape_usuario) {
        this.ape_usuario = ape_usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getAccessosistemas() {
        return accessosistemas;
    }

    public void setAccessosistemas(int accessosistemas) {
        this.accessosistemas = accessosistemas;
    }

    public int getEsadministrador() {
        return esadministrador;
    }

    public void setEsadministrador(int esadministrador) {
        this.esadministrador = esadministrador;
    }
}
