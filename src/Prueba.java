
import Dominio.*;
import Interfaz.showMenu;
import Interfaz.showPartida;
import Interfaz.showTablero;

public class Prueba {

    public static void main(String[] args) {
        int dato = 0; //Por defecto se ejecuta el menú princiapl.
        boolean isEnable;

        showMenu elMenu = new showMenu(0, true);

        Sistema miSistema = new Sistema();
        Tablero elTablero = new Tablero();

        //Cargamos el Menu Principal
        boolean repetir;//True repite el menú

        elMenu.showLogo(true);
        do {
            dato = elMenu.showMenuPrincipal(true, 4);
            repetir = false;
            switch (dato) {
                case 1:
                    //Se ejecuta el metodo mostrar Cabecera de Menú.
                    elMenu.showCabeceraMenu(true, "Menú Registrar Jugador");
                    //Se crea el objeto Jugador con los parametros.
                    //Luego se agrega al ArrayList de Jugadores

                    Jugador elJugador = new Jugador(elMenu.registrarJugadorAlias(miSistema.getListaJugadores()),
                            elMenu.registrarJugadorNombre(), elMenu.registrarJugadorEdad());

                    System.out.println(elJugador);

                    miSistema.agregarJugador((Jugador) elJugador);

                    repetir = true; //True Repite, False no repite menu principal.
                    break;
                //Elegir Carga de tablero
                case 2:
                    //Se ejecuta el metodo mostrar Cabecera de Menú.
                    elMenu.showCabeceraMenu(true, " Seleccione un tipo de tablero");
                    elMenu.setCargaTablero(true, 2, elTablero);
                    repetir = true; //True Repite, False no repite menu principal.
                    break;

                //Jugar
                case 3:
                    //Creo una partida.
                    boolean next = false;
                    //Selección de jugadores y arranque Partida.
                    if (!miSistema.numJugadoresMinimos()) {
                        System.out.println("!!! Error !!! ");
                        System.out.println("Es necesario tener al menos dos jugadores registrados ");
                        repetir = true; //True Repite, False no repite menu principal.
                        next = false;
                    } else {

                        Jugador jugador1 = elMenu.seleccionarJugador("Primero",
                                miSistema.getListaJugadores(), null);
                        Jugador jugador2 = elMenu.seleccionarJugador("Segundo",
                                miSistema.getListaJugadores(), jugador1);
                        Partida laPartida = new Partida(elTablero, jugador1, jugador2);

//                    Jugador jugador1 = new Jugador("fer", "Fernando", 29);
//                    Jugador jugador2 = new Jugador("Leti", "Leticia", 25);
                        //########################################################################
                        //Mostrar tablero y datos de los jugadores.
                        do {
                            //CICLO DE PARTIDA ##################################################
                            laPartida.setError(" ");

                            //Dibujo del Tablero
                            showTablero.show(laPartida.getTablero().getMatrizTablero());

                            //Dibujo de status de la partida.
                            showPartida.datos(laPartida);

                            //Se ingresa la jugada.
                            laPartida.validarJugada(elMenu.ingresarMovimiento(true));

                            //Imprimo el status de la jugada (error, si hay error)
                            System.out.println(laPartida.getError());

                            //Mensaje de AYUDA
                            if (laPartida.getError().contains("AYUDA")) {

                                //Muestra cada Ayuda.
                                for (int i = 0; i < laPartida.getPatronesPosibles(laPartida.getJugadorDeTurno(laPartida.getTurno())).size(); i++) {
                                    String itemAyuda;
                                    itemAyuda = laPartida.getPatronesPosibles(laPartida.getJugadorDeTurno(laPartida.getTurno())).get(i);
                                    mostrarItemAyuda(itemAyuda);
                                }
                            }
                            //Si un jugador quiere abandonar


                            //Si nadie Abandona o no hay ganador vuelve al "do"
                        } while ((laPartida.hayGanador() == 0));

                        //FIN PARTIDA #############################################################
                        /*
                         Asignamos el resultado al ranking.
                         */
                        if (laPartida.hayGanador() == 1) {
                            laPartida.getJugador1().setPartidas(1, 0);
                            laPartida.getJugador2().setPartidas(0, 1);
                            elMenu.showCabeceraMenu(true, "EL GANADOR ES: " + (laPartida.getJugador1().getAlias()));
                        }
                        if (laPartida.hayGanador() == 2) {
                            laPartida.getJugador2().setPartidas(1, 0);
                            laPartida.getJugador1().setPartidas(0, 1);
                            System.out.println("\n");
                            elMenu.showCabeceraMenu(true, "EL GANADOR ES: " + (laPartida.getJugador2().getAlias()));
                            System.out.println("\n");
                        }

                    }
                    /*
                     Comienza el ciclo de jugadas
                     */
                    /*
                     Fin Partida retorno menú principal
                     */
                    repetir = true; //True Repite, False no repite menu principal.
                    break;

                case 4:
                    elMenu.showMenuRanking(miSistema.getListaJugadores());
                    repetir = true; //True Repite, False no repite menu principal.
                    break;
                case 0:

                    //Salir del programa.
                    elMenu.showSaludo(true);
                    System.exit(1);
                    break;

            }
        } while (repetir == true);
    }

    private static void mostrarItemAyuda(String itemAyuda) {
        //tipoPatron
        char tipoPatron;
        String patron;
        String imprime;

        tipoPatron = itemAyuda.toUpperCase().charAt(2);
        patron = nombrePatron(tipoPatron);
        imprime = patron + " " + itemAyuda.toUpperCase().substring(3, 5) + " a " + itemAyuda.toUpperCase().substring(5, 7);
        System.out.println(imprime);
    }

    private static String nombrePatron(char tipoPatron) {

        String nombrePatron = "";

        switch (tipoPatron) {

            case 'S':
                nombrePatron = "SEPARADAS";
                break;

            case 'J':
                nombrePatron = "JUNTAS";
                break;

            case 'D':
                nombrePatron = "DIAGONAL";
                break;

            case 'C':
                nombrePatron = "CABALLO";
                break;
        }

        return nombrePatron;
    }

}
