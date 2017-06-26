/**
 * ***************************************************
 * Clase: Sistema
 *
 * @author Rodrigo Blanco - 151251 - Programación II
 * *************************************************
 */
package Dominio;

import java.io.Serializable;
import java.util.*;

public class Sistema implements Serializable {

    //Atributos del Sistema
    private ArrayList<Jugador> listaJugadores;
    private Partida partida;
    private ArrayList<Partida> listaPartidasGuardadas;
    
    //Constructor del Sistema
    public Sistema() {
        this.listaJugadores = new ArrayList();
        this.listaPartidasGuardadas = new ArrayList();
        //La partida se crea al seleccionar nueva partida
        //this.partida = new Partida();
    }

    /*
     **********************************************
     Gets y Sets
     */

    public ArrayList<Partida> getListaPartidasGuardadas() {
        return listaPartidasGuardadas;
    }

    public void setListaPartidasGuardadas(ArrayList<Partida> listaPartidasGuardadas) {
        this.listaPartidasGuardadas = listaPartidasGuardadas;
    }
    
    
    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Jugador getJugador(int jugador) {
        return this.listaJugadores.get(jugador);
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

    public void eliminarJugador(Jugador unJugador) {
        this.getListaJugadores().remove(unJugador);
    }

    /*
     **********************************************
     Método para ordenar Lista Jugadores según su ranking
     */
    public ArrayList ordenarPorRanking() {
        //Internamente, utiliza el criterio definido en la instancia pasada como parámetro (CriterioDecdreciente)
        return this.getListaJugadores();

    }

    public boolean validarAliasJugador(Jugador unJugador) {
        boolean noExisteJugador = true;

        return noExisteJugador;
    }

    //Método que valida que el sistema tenga al menos 1 Jugador.
    public boolean numJugadoresMinimos() {
        boolean retorno = false;
        if (this.getListaJugadores().size() >= 1) {
            retorno = true;
        }
        return retorno;
    }

    //Método que devuelve cantidad de Jugadores registrados.

    public int numJugadoresRegistrados() {
        int retorno = this.getListaJugadores().size();
        return retorno;
    }
}
