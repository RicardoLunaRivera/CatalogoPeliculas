package dominio;

import java.util.Objects;

public class Pelicula {
    private int idPelicula;
    private String nombre;
    private String fechaEstreno;
    private String director;

    private static int contadorPeliculas;

    public Pelicula(){
        idPelicula = ++contadorPeliculas;
    }

    public Pelicula(String nombre){
        this.nombre = nombre;
    }

    public Pelicula(String nombre, String fechaEstreno, String director){
        this();
        this.nombre = nombre;
        this.fechaEstreno = fechaEstreno;
        this.director = director;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula pelicula = (Pelicula) o;

        return Objects.equals(nombre, pelicula.nombre);
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        return result;
    }


/*    @Override
    public String toString() {
        return "Pelicula{" +
                "idPelicula=" + idPelicula +
                ", nombre='" + nombre + '\'' +
                ", fechaEstreno='" + fechaEstreno + '\'' +
                ", director='" + director + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return this.nombre;
    }
}
