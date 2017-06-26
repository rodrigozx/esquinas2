/**
 * ***************************************************
 * Clase: Partida
 *
 * @author Rodrigo Blanco - 151251 - Programación II
 * *************************************************
 */
package Dominio;

import java.io.Serializable;
import java.util.*;
import javax.swing.JOptionPane;

public class Partida implements Serializable {

    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador ganador;
    private int turno;
    private boolean vsCpu;

    /* CONSTRUCTOR *************************************/
    public Partida() {
        this.jugador1 = null;
        this.jugador2 = null;
        this.turno = 1; //la partida siempre comienza con el turno para el jugador 1
        this.tablero = new Tablero();
        this.ganador = null;
        this.vsCpu = false;
        this.tablero.setCantCubosJug1(25);
        this.tablero.setCantCubosJug2(25);
    }

    /* CONSTRUCTOR POR PARAMETROS *************************************/
    public Partida(Jugador jugador1, Jugador jugador2, int turno, boolean versusCpu, int cantCubos) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turno = turno;
        this.tablero = new Tablero();
        this.ganador = null;
        this.vsCpu = versusCpu;
        this.tablero.setCantCubosJug1(25);
        this.tablero.setCantCubosJug2(25);
    }

    /* GETS Y SETS *************************************/
    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public int getTurno() {
        return this.turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Jugador getGanador() {
        return ganador;
    }
   
    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    /* METODOS *************************************/
    public int terminoPartida() {
        /*Valida el estado de la partida.
         si alguno de los jugadores no tiene más cubos, entonces terminó la partida.
         0-No hay ganador
         1-Ganador Jugador1
         2-Ganador Jugador2
         */
        int hayGanador = 0;
        if ((this.tablero.getCantCubosJug1() == 0) && (this.tablero.getCantCubosJug2() == 0)) {
               hayGanador = ganadorPartida();
        }else{
            //Si habandonaron
            if(this.getGanador()!= null){
               hayGanador = ganadorPartida();
            }
        }
        
        // si el estado permanece en 0 entonces no hay ganador.
        return hayGanador;
    }

    public int ganadorPartida() {

        //calculo las fichas en el tablero
        int elGanador;
        
        if(jugador1.equals(ganador)){
            elGanador = 1;
        }else{
            elGanador = 2;
        }
        return elGanador;
    }

    public void restaCubos(int cantCubos, boolean esResta) {

        int cantCubosActual;
        //Me fijo de quien es el turno
        if (this.getTurno() == 1) { //jugador 1
            cantCubosActual = this.getTablero().getCantCubosJug1();
            if (esResta) {
                this.getTablero().setCantCubosJug1(cantCubosActual - cantCubos);
            } else { //si no los resta, los está sumando
                this.getTablero().setCantCubosJug1(cantCubosActual + cantCubos);
            }
        } else { // es el jugador 2
            cantCubosActual = this.getTablero().getCantCubosJug2();
            if (esResta) {
                this.getTablero().setCantCubosJug2(cantCubosActual - cantCubos);
            } else { //si no los resta, los está sumando
                this.getTablero().setCantCubosJug2(cantCubosActual + cantCubos);
            }
        }
    }

    public Jugador getJugadorDeTurno() {
        Jugador elJugador;
        
        if (this.getTurno() == 1) {
            elJugador = this.getJugador1();
        } else {
            elJugador = this.getJugador2();
        }
        return elJugador;
    }
    
    public void cambioTurno() {

        if (this.getTurno() == 1) {
            this.setTurno(2);
        } else {
            this.setTurno(1);
        }
    }
    
    public void abandonar() {

        //Jugador 1 Abandona.
        if (this.getTurno() == 1) {
            this.setGanador(this.getJugador2());
        }
        //Jugador 2 Abandona.
        if (this.getTurno() == 2) {
            this.setGanador(this.getJugador1());
        }
    }

}
