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
        showPartida.cantPiedras(unaPartida.getCantidadPiedras());
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
        showPartida.cantFichas(unaPartida.getJugador1().getCubos());
        System.out.println("");
        System.out.print("Jugador 2: " + unaPartida.getJugador2().getAlias());
        System.out.println("");
        showPartida.cantFichas(unaPartida.getJugador2().getCubos());
        System.out.println("\n");
        System.out.print("JUEGA: ");
        if (unaPartida.getTurno() == 1) {
            System.out.println(unaPartida.getJugador1().getAlias());
        }
        if (unaPartida.getTurno() == 2) {
            System.out.println(unaPartida.getJugador2().getAlias());
        }

    }

    //Muestra cantida de piedras
    private static void cantFichas(int[] cantFichas) {
        if (cantFichas != null) {
            for (int i = 0; i < cantFichas.length; i++) {
                for (int j = 0; j < cantFichas[i]; j++) {

                    switch (i) {

                        case 0:
                            //Celeste
                            showTablero.impFicha('C');
                            break;
                        case 1:
                            //Azul
                            showTablero.impFicha('A');
                            break;
                        case 2:
                            //Rojo
                            showTablero.impFicha('R');
                            break;

                        case 3:
                            //Verde
                            showTablero.impFicha('V');
                            break;
                        default:
                    }

                }

            }
        }
    }

}
