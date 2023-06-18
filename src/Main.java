import dominio.Pelicula;
import servicio.IServicioPelicula;
import servicio.ServicioPeliculasLista;
import servicio.ServicioPeluculasArchivo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        // agregar la implementación de servicio- Para crear la lista de elementos
        //IServicioPelicula servicioPelicula = new ServicioPeliculasLista();

        // se crea la implementación para guarda rlos datos en el disco
        IServicioPelicula servicioPelicula = new ServicioPeluculasArchivo();

        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(sc , servicioPelicula);
            }catch (Exception e){
                System.out.println("Se produjo un error: " + e);
            }

            System.out.println();
        }

    }

    private static void mostrarMenu(){
        System.out.println("\n :: CATÁLOGO DE PELÍCULAS :: \n 1- Agregar Película. \n 2- Listar Películas. " +
                "\n 3- Buscar Película \n 4- Salir. \n :: Escoge una opción:: ");
    }

    private static boolean ejecutarOpciones(Scanner sc, IServicioPelicula servicioPelicula){
        int opcion = sc.nextInt();
        boolean salir = false;
        switch (opcion){
            case 1:
                sc.nextLine();
                System.out.print("Ingresa el nombre de la película: ");
                String nombrePelicula = sc.nextLine();

                System.out.print("Ingresa el año de la película: ");
                String annioPelicula =  sc.nextLine();


                System.out.print("Ingresa el nombre del director: ");
                String nombreDirector = sc.nextLine();

                servicioPelicula.agregarPelicula(new Pelicula(nombrePelicula,annioPelicula,nombreDirector));
                break;

            case 2:
                servicioPelicula.listarPeliculas();
                break;

            case 3:
                sc.nextLine();
                System.out.println("¿Qué película quieres buscar?: ");
                String buscarPelicula = sc.nextLine();

                servicioPelicula.buscarPelicula(new Pelicula(buscarPelicula));
                break;

            case 4:
                System.out.println("Hasta pronto...");
                salir = true;
                break;

            default:
                System.out.println("Opción no reconocida: " + opcion);
        }
        return salir;
    }
}