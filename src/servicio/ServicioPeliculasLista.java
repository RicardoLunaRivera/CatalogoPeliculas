package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPelicula{

    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista(){
        this.peliculas =  new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("\n:: Listado de Películas ::");

        /*          "System.out::println"
                Se llama "referencia de método" y es un azúcar sintáctico
                Es la referencia del método útil: el operador "::"  indica que invocará el método println con un parámetro,
                 cuyo nombre no especifica explícitamente.
         */
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agreró la película: " + pelicula.getNombre() + ". Con el ID: " + pelicula.getIdPelicula());
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        int index = peliculas.indexOf(pelicula);
        if (index == -1)
            System.out.println("La película no fue encontrada.");
        else
            System.out.println("Se encontró la película: " + pelicula.getNombre() + " con los siguientes datos:" +
                    "-Fecha de Estreno: " + pelicula.getFechaEstreno() + ". -Director: " + pelicula.getDirector() + "." +
                    " En el índice: " + index);

    }

/*    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula("Batman","11/11/11", "Nolan");
        IServicioPelicula servicioPelicula =  new ServicioPeliculasLista();

        servicioPelicula.agregarPelicula(pelicula1);
        servicioPelicula.listarPeliculas();


        servicioPelicula.buscarPelicula(new Pelicula("Conant"));
    }*/
}
