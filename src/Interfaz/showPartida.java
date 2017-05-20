/*****************************************************
    Clase: showPartida
    @author Rodrigo Blanco - 151251 - Programación II
    **************************************************
*/
package Interfaz;

import Dominio.Partida;
import java.util.HashMap;
import java.util.Scanner;

public class showPartida {

    Scanner teclado = new Scanner(System.in);

    //Defino Constructores
    //Constructor sin parametros
    public showPartida() {

    }

    //Recorro la matriz y dibujo
    public static void datos(Partida unaPartida) {
        showPartida.datosJugadores(unaPartida);

    }

    //Muestra cantida de piedras
    private static void cantPiedras(int cantPiedras) {
        System.out.print("PIEDRAS: " + cantPiedras + " ");
        for (int i = 0; i < cantPiedras; i++) {
            System.out.print("#");

        }
        System.out.println("");
    }

    //Muestra Datos Jugadores
    private static void datosJugadores(Partida unaPartida) {
        System.out.println("Jugador 1: " + unaPartida.getJugador1().getAlias());
        //showPartida.cantFichas(unaPartida;
        System.out.println("");
        System.out.print("Jugador 2: " + unaPartida.getJugador2().getAlias());
        System.out.println("");
        //showPartida.cantFichas(unaPartida.getCantCubosJugador2());
        System.out.println("\n");
        System.out.print("JUEGA: ");
        if (unaPartida.getTurno() == 1) {
            System.out.println(unaPartida.getJugador1().getAlias());
        }
        if (unaPartida.getTurno() == 2) {
            System.out.println(unaPartida.getJugador2().getAlias());
        }

    }
   

}
