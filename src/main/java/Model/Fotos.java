package Model;

public class Fotos {
    private int idfoto;
    private int idpelicula;
    private String foto;
    private String primera;

    public Fotos(int idfoto, int idpelicula, String foto, String primera) {
        this.idfoto = idfoto;
        this.idpelicula = idpelicula;
        this.foto = foto;
        this.primera = primera;
    }

    public Fotos(int idfoto, int idpelicula, String primera) {
        this.idfoto = idfoto;
        this.idpelicula = idpelicula;
        this.primera = primera;
    }

    public int getIdfoto() {
        return idfoto;
    }

    public void setIdfoto(int idfoto) {
        this.idfoto = idfoto;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPrimera() {
        return primera;
    }

    public void setPrimera(String primera) {
        this.primera = primera;
    }
}
