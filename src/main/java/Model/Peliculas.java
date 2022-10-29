package Model;

public class Peliculas {
    private int idpelicula;
    private String nombre;
    private String nomb_ingles;
    private int yearp;
    private int duracion;

    public Peliculas(int idpelicula, String nombre, String nomb_ingles, int yearp, int duracion) {
        this.idpelicula = idpelicula;
        this.nombre = nombre;
        this.nomb_ingles = nomb_ingles;
        this.yearp = yearp;
        this.duracion = duracion;
    }

    public Peliculas(int idpelicula, String nombre, String nomb_ingles, int yearp) {
        this.idpelicula = idpelicula;
        this.nombre = nombre;
        this.nomb_ingles = nomb_ingles;
        this.yearp = yearp;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomb_ingles() {
        return nomb_ingles;
    }

    public void setNomb_ingles(String nomb_ingles) {
        this.nomb_ingles = nomb_ingles;
    }

    public int getYearp() {
        return yearp;
    }

    public void setYearp(int yearp) {
        this.yearp = yearp;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
