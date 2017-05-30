/*
 3) (máximo 3 puntos): Cargar los datos de los jugadores desde un archivo de texto, cuyo nombre y

 ubicación lo indicará el usuario. Por cada jugador, habrá una línea con: nombre#edad#alias. Si el

 jugador ya existe (ya fue ingresado su alias) se actualiza su nombre y edad.
 */
package Persistencia;

import java.util.*;
import java.io.*;
import Dominio.*;
import java.nio.file.Files;
import Excepciones.*;

/**
 *
 * @author rblanco
 */
public class ImpExpJugadores {

    public static ArrayList<Jugador> importarJugadores(String nombreArchivo) {
        ArrayList<Jugador> listaImpJugadores = new ArrayList();

        try {
            FileReader r = new FileReader(nombreArchivo);
            BufferedReader buffer = new BufferedReader(r);

            String temp = "";

            //leo cada línea del archivo
            while (temp != null) {

                temp = buffer.readLine();
                if (temp == null) {
                    break;
                } else {
                    //Codifico línea de jugador y lo ingreso
                    listaImpJugadores.add(codificoLinea(temp));
                }
            }

        } catch (Exception e) {

        }

        return listaImpJugadores;
    }

    public static Jugador codificoLinea(String linea) {

        Jugador nuevoJugador = new Jugador();

        //Elimino posibles espacios en blanco
        linea = linea.replaceAll("\\s+", "");

        boolean faltanDatos = true;
        String datoLinea;

        //Paso los datos de la línea a un array 
        String[] datos = linea.split("#");

        //Si la cantidad de datos es "3", entonces 
        //la cantidad de datos en la línea es correcta
        if (datos.length == 3) {

            nuevoJugador.setNombre(datos[0]);
            nuevoJugador.setEdad(Integer.parseInt(datos[1]));
            nuevoJugador.setAlias(datos[2]);
        }
        return nuevoJugador;
    }

    public static boolean exportarJugadores(ArrayList<Jugador> listaJugadores, String nombreArchivo) {
        boolean retorno = false;
        String linea;
        String extension = ".TXT";
        boolean extensionOk;

        extensionOk = nombreArchivo.toUpperCase().substring(nombreArchivo.length() - 5, nombreArchivo.length()).equals(extension);

        if (!extensionOk) {

            nombreArchivo += ".txt";
        }

        File f; //Creo Tipo de archivo
        f = new File(nombreArchivo);

        try {
            FileWriter w = new FileWriter(f);
            try (BufferedWriter bw = new BufferedWriter(w)) {
                PrintWriter wr = new PrintWriter(bw);

                for (Jugador listaJugadore : listaJugadores) {
                    linea = listaJugadore.getNombre() + "#";
                    linea += listaJugadore.getEdad() + "#";
                    linea += listaJugadore.getAlias() + "#";
                    wr.append(linea);
                    bw.newLine();
                }

            }

            retorno = Files.exists(f.toPath());//se grabó el archivo?

        } catch (IOException e) {

            //mostrar excepciones
        }

        return retorno;
    }

}
