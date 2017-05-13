/*
 * @author Rodrigo Blanco 
 * @author Fernando Rivera
 */
package Dominio;

import java.util.*;

public class Sistema {

    //Atributos del Sistema
    private ArrayList<Jugador> listaJugadores;
    private Partida partida;

    //Constructor del Sistema
    public Sistema() {
        this.listaJugadores = new ArrayList();

        //La partida se crea al seleccionar nueva partida
        //this.partida = new Partida();
    }

    /**
     * *****************************************************
     */
    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public void agregarJugador(Jugador unJugador) {
        this.getListaJugadores().add(unJugador);
    }

    /**
     * **********************************************
     */
    /*Metodo para ordenar Lista Jugadores segun su ranking
     */
    public ArrayList ordenarPorRanking() {
        //Internamente, utiliza el criterio definido en la instancia pasada como parámetro (CriterioDecdreciente)
        return this.getListaJugadores();

    }

    public static boolean validarAliasJugador(Jugador unJugador) {
        boolean noExisteJugador = true;

        return noExisteJugador;
    }

    //Configuración de en que posición se guarda la cantidad de fichas
    public static int posEnArrayTipoFicha(String tipoFicha) {

        int posicionArrayTipoFicha;
        switch (tipoFicha) {

            case "A"://Azul
                posicionArrayTipoFicha = 0;
                break;

            case "C"://Celeste
                posicionArrayTipoFicha = 1;
                break;

            case "V"://Verde
                posicionArrayTipoFicha = 2;
                break;

            case "R"://Roja
                posicionArrayTipoFicha = 3;
                break;

            case "P"://Piedra
                posicionArrayTipoFicha = 4;
                break;

            default:
                posicionArrayTipoFicha = 0;
        }

        return posicionArrayTipoFicha;
    }

    //Configuración color de ficha según int
    public static char tipoFicha(int numero) {

        char colorFicha;
        switch (numero) {

            case 1://Azul
                colorFicha = 'A';
                break;

            case 2://Celeste
                colorFicha = 'C';
                break;

            case 3://Verde
                colorFicha = 'V';
                break;

            case 4://Roja
                colorFicha = 'R';
                break;

            case 5://Piedra
                colorFicha = 'P';
                break;

            default:
                colorFicha = ' ';
        }

        return colorFicha;
    }

        //Metodo que valida que el sistema tenga al menos 2 Jugadores.
    public boolean numJugadoresMinimos() {
        boolean retorno = false;
        if (this.getListaJugadores().size() >= 2) {
            retorno = true;
        }
        return retorno;
    }
    
}
