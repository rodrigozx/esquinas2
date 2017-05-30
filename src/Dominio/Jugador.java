/**
 * ***************************************************
 * Clase: Jugador
 *
 * @author Rodrigo Blanco - 151251 - Programación II
 * *************************************************
 */
package Dominio;

import java.io.Serializable;
import java.util.*;

public class Jugador implements Serializable {

    private String alias;
    private String nombre;
    private int edad;
    private int[] partidas = new int[2];

    /*Significado de posisiones en array de Partidas:
     pos = 0 -Partidas Ganadas.
     pos = 1 -Partidas Perdidas.*/
    /* CONSTRUCTOR POR DEFECTO *************************************/
    public Jugador() {
        this.alias = "Sin Alias";
        this.nombre = "Sin Nombre";
        this.edad = 0;
        this.partidas = null;
    }

    /* CONSTRUCTOR POR PARAMETROS *************************************/
    public Jugador(String elAlias, String elNombre, int laEdad) {
        this.setAlias(elAlias);
        this.setNombre(elNombre);
        this.setEdad(laEdad);
        this.setPartidas(0, 0);
    }

    /* GETS Y SETS *************************************/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int unaEdad) {
        this.edad = unaEdad;
    }


    /* METODOS *************************************/
    public int[] getPartidas() {
        return this.partidas;
    }

    public void setPartidas(int ganada, int perdida) {
        int[] ranking = new int[2];
        ranking[0] = ganada;
        ranking[1] = perdida;
        this.partidas = ranking;
    }

    @Override //Dos jugadores son iguales si tienen el mismo alias.
    public boolean equals(Object obj) {
        boolean retorno;
        if (obj == null) {
            retorno = false;
        } else {
            retorno = (this.getAlias().equalsIgnoreCase(((Jugador) obj).getAlias()));
        }
        return retorno;

    }

    public String getPartidasGanadasToString() {
        int[] partidasGan = this.getPartidas();
        return Integer.toString(partidasGan[0]);
    }

    public String getPartidasPerdidasToString() {
        int[] partidasGan = this.getPartidas();
        return Integer.toString(partidasGan[0]);
    }

    //Defino el toString del Jugador.
    @Override
    public String toString() {
        return "Datos de Jugador: "
                + "\n" + "Alias : " + this.getAlias()
                + "\n" + "Nombre: " + this.getNombre()
                + "\n" + "Edad  : " + this.getEdad()
                + "\n" + "Partidas Ganadas: " + this.getPartidasGanadasToString()
                + "\n" + "Partidas Perdidas: " + this.getPartidasGanadasToString();
    }
}
