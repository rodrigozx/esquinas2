/** ***************************************************
 * Clase: Prueba
 *
 * @author Rodrigo Blanco - 151251 - Programación II
 * *************************************************
 */
package Prueba;

import Dominio.*;
import Interfaz.*;

public class Prueba {

    
    public static void main(String[] args) {

    //Se crea el sistema del juego
    Sistema miSistema = new Sistema();

    //Se crea el menu a mostrar
    showMenu elMenu = new showMenu(0, true);
    
        int dato = 0; //Por defecto se ejecuta el menú princiapl.

        //Carga del Menu Principal
        boolean repetir; //True repite el menú
            elMenu.showLogo(true);
        
        do {
            dato = elMenu.showMenuPrincipal(true, 4);
            repetir = false;
            switch (dato) {

                //Registro de Jugador **********************************************************************
                case 1:
                    registroDeJugador(miSistema,elMenu);
                    repetir = true; //True Repite, False no repite menu principal.
                    break;

                //Jugar 1 vs 1 **********************************************************************
                case 2:
                    iniciarPartida(2,miSistema,elMenu); //Son dos jugadores.
                    repetir = true; //True Repite, False no repite menu principal.
                    break;

                //Jugar 1 vs CPU **********************************************************************
                case 3:
                    iniciarPartida(1, miSistema, elMenu); //Es un sólo jugador.
                    repetir = true; //True Repite, False no repite menu principal.                    
                    break;

                //Muestra el Ranking de jugadores *****************************************************
                case 4:
                    elMenu.showMenuRanking(miSistema.getListaJugadores());
                    repetir = true; //True Repite, False no repite menu principal.
                    break;

                //Sale del programa **********************************************************************                    
                case 0:
                    elMenu.showSaludo(true);
                    System.exit(1);
                    break;
                default:
                    repetir = true; //True Repite, False no repite menu principal.
            }
        } while (repetir == true);
    }
    
    public static void registroDeJugador(Sistema miSistema, showMenu elMenu) {
        //Se ejecuta el metodo mostrar Cabecera de Menú.
        elMenu.showCabeceraMenu(true, "Menú Registrar Jugador");

        //Se crea el objeto Jugador con los parametros.
        //Luego se agrega al ArrayList de Jugadores
        Jugador elJugador = new Jugador(elMenu.registrarJugadorAlias(miSistema.getListaJugadores()),
                elMenu.registrarJugadorNombre(), elMenu.registrarJugadorEdad());

        System.out.println(elJugador);

        miSistema.agregarJugador((Jugador) elJugador);

    }

    public static void iniciarPartida(int cantJugadores, Sistema miSistema, showMenu elMenu) {
        
        //Creo una partida.
        boolean next = false;
        boolean vsCpu;
        
        //Veo si es un jugaor sólo
        if (cantJugadores == 2){
            vsCpu =false;
        }else {vsCpu = true;}
        
        //Selección de jugadores y arranque Partida. ******************************************
        //si existe menos de un jugador registrado
        if (!miSistema.numJugadoresMinimos() && (vsCpu == false)) {
            elMenu.mostrarMensaje("Error! la cantidad de jugadores registrados");
            if (!miSistema.numJugadoresMinimos() && (vsCpu == true)){
                elMenu.mostrarMensaje("es de al menos uno para ésta partida");
            }else{
                elMenu.mostrarMensaje("es de al menos dos para este tipo de partida");
            }
            next = false;
        } else {
            if (miSistema.numJugadoresRegistrados() == 1 && (vsCpu == false)) {
                elMenu.mostrarMensaje("Error! la cantidad de jugadores registrados");
                elMenu.mostrarMensaje("es de al menos dos para este tipo de partida");
            }
            Jugador jugador1 = elMenu.seleccionarJugador("Primero",
                    miSistema.getListaJugadores(), null);
            Jugador jugador2 = elMenu.seleccionarJugador("Segundo",
                    miSistema.getListaJugadores(), jugador1);
            Partida laPartida = new Partida(jugador1, jugador2,1, null,vsCpu, 25);
//                    Jugador jugador1 = new Jugador("Rolo", "Rodrigo", 33);
//                    Jugador jugador2 = new Jugador("Viky", "Virginia", 29);
            
            //Mostrar tablero y datos de los jugadores.
            do {
                //CICLO DE PARTIDA ##################################################
                //Dibujo del Tablero
                //showTablero.show(laPartida.getCantCubosJugador1()); ///muestro la estadística 

                //Dibujo de status de la partida.
                showPartida.datos(laPartida);

                //Se ingresa la jugada.
                //laPartida(elMenu.ingresarMovimiento(true));

                //Si un jugador quiere abandonar
                //Si nadie Abandona o no hay ganador vuelve al "do"
            } while ((laPartida.terminoPartida() == 0)); //mientra haya jugadores con fichas.

            //FIN PARTIDA #############################################################
            /*
             Asignamos el resultado al ranking.
             */
            if (laPartida.terminoPartida() == 1) {
                laPartida.getJugador1().setPartidas(1, 0);
                laPartida.getJugador2().setPartidas(0, 1);
                elMenu.showCabeceraMenu(true, "EL GANADOR ES: " + (laPartida.getJugador1().getAlias()));
            }
            if (laPartida.terminoPartida() == 2) {
                laPartida.getJugador2().setPartidas(1, 0);
                laPartida.getJugador1().setPartidas(0, 1);
                System.out.println("\n");
                elMenu.showCabeceraMenu(true, "EL GANADOR ES: " + (laPartida.getJugador2().getAlias()));
                System.out.println("\n");
            }

        }
        /*
         Fin Partida retorno menú principal
         */

    }

}
