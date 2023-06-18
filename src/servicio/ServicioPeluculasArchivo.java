package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeluculasArchivo implements IServicioPelicula{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeluculasArchivo(){
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            if (archivo.exists()){
                System.out.println("El archivo ya existe.");
            }else {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se creó el archivo.");
            }

        }catch (Exception e){
            System.out.println("Se produjo un error: " +e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        //Abrimos el archivo
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println(":: Listado de Películas ::");

            //Abrimos el achivo para lectura
            BufferedReader reader = new BufferedReader(new FileReader(archivo));

            //Leemos linea a linea el archivo
            String linea = reader.readLine();

            //leemos todas las lineas disponibles
            while (linea != null){
                Pelicula pelicula = new Pelicula(linea);
                System.out.println(pelicula);

                //seguimos leyendo la siguiente linea
                linea = reader.readLine();
            }

            //Cerrar el archivo
            reader.close();

        }catch (Exception e){
            System.out.println("Ocurrio un error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean add = false;

        File archivo = new File(NOMBRE_ARCHIVO);

        try {
            // Revisamos si el archivo existe
            add = archivo.exists();
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, add));

            //Agregamos pelicula ( toString)
            salida.println(pelicula);

            //Cerrar el archivo
            salida.close();

            System.out.println("Se agrego al archivo la película: " + pelicula);

        }catch (Exception e){
            System.out.println("Ocurrio un error al agregar una película: " + e.getMessage());
        }


    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            //Abrimos el achivo para lectura
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String lineaTexto = reader.readLine();

            int indice = 1;
            boolean encontrada = false;
            String peliculaBuscar = pelicula.getNombre();

            while (lineaTexto != null){
                //buscamos texto sin importar mayusculas o minusculas

                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }

                // leemos la siguiente linea
                lineaTexto = reader.readLine();

                indice++;
            }

            //imprimimos los resultado de la busqueda
            if (encontrada){
                System.out.println("Pelicula " + lineaTexto + "encontrada en el índice " + indice);
            }else {
                System.out.println("No se encontró la película: " + pelicula.getNombre());
            }

            reader.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar la película: " + e.getMessage());
        }
    }
}
