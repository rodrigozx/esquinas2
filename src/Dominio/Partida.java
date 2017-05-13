/*
 * @author Rodrigo Blanco 
 * @author Fernando Rivera
 */
package Dominio;

import java.util.*;
import Dominio.*;

public class Partida {

    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private int fichasJugador1;
    private int fichasJugador2;
    private Jugador ganador;
    private int turno;
    private boolean vsCpu;


    /* CONSTRUCTOR *************************************/
    /* CONSTRUCTOR POR PARAMETROS *************************************/
    public Partida(Tablero elTablero, Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turno = 1;
        this.tablero = elTablero;
        this.fichasJugador1 = 25;
        this.fichasJugador2 = 25;
        this.ganador = null;
        this.vsCpu = false;
    }

    /* CONSTRUCTOR POR PARAMETROS *************************************/
    public Partida(Jugador jugador1, Jugador jugador2, int turno, Tablero elTablero, int fichasJugador1, int fichasJugador2,boolean versusCpu) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turno = turno;
        this.tablero = elTablero;
        this.fichasJugador1 = fichasJugador1;
        this.fichasJugador2 = fichasJugador1;
        this.ganador = null;
        this.vsCpu = versusCpu;
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
        return turno;
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
    /*Valida el estado de la partida.
     0-No hay ganador
     1-Ganador Jugador1
     2-Ganador Jugador2
     */
    public int hayGanador() {

        if (!(this.jugador1.getCubosTotal() == 0 && (this.jugador2.getCubosTotal() == 0))) {
            if (this.jugador1.getCubosTotal() == 0) {
                this.setEstado(1);
            }
            if (this.jugador2.getCubosTotal() == 0) {
                this.setEstado(2);
            }
        }
        return estado;
    }

    public void sumarRestaCubo(int cantidadFichas, String tipoFicha, boolean esSuma) {

        Jugador jugadorAux;
        int posFichas;

        if (this.getTurno() == 1) {
            jugadorAux = this.getJugador1();
        } else {
            jugadorAux = this.getJugador2();
        }

        //Busco en que posición guardo éste tipo de ficha y le sumo o resto la cantidad
        posFichas = Sistema.posEnArrayTipoFicha(tipoFicha);
        if (esSuma) {
            jugadorAux.getCubos()[posFichas] = jugadorAux.getCubos()[posFichas] + cantidadFichas;
        } else {
            if (jugadorAux.getCubos()[posFichas] > 0) {
                jugadorAux.getCubos()[posFichas] = jugadorAux.getCubos()[posFichas] - cantidadFichas;
            } else {
                this.error = (jugadorAux.getAlias() + " no tiene fichas " + tipoFicha);
            }
        }
    }




    public Jugador getJugadorDeTurno(int turno) {
        Jugador elJugador;
        if (turno == 1) {
            elJugador = this.getJugador1();
        } else {
            elJugador = this.getJugador2();
        }

        return elJugador;
    }

    public String validarJugada(String movimiento) {
        String salida = "";
        String aux;
        int[] coordenadas1;
        int[] coordenadas2;
        char ficha;
        char ficha2;
        /*
         Tipos de entradas:
         (Piedra)
         PH A5
         PD A4
         (Patron)
         PDJ B4 B5
         PDS A3 A5 R
         PDC A5 B3 A
         PDD D2 C1 RC
         */
        //Quito los espacios en caso que existan
        movimiento = movimiento.replaceAll("\\s+", "");

        //Si la jugada es mayor a 4 caracteres, entonces es un patrón
        if (movimiento.length() > 4) {
            boolean movOk;

            //PATRONES 
            switch (movimiento.length()) {

                case 7: //PATRON DOS PIEDRAS JUNTAS "PDJ"
                    aux = movimiento.substring(0, 3);
                    if (aux.equalsIgnoreCase("PDJ")) {

                        //Coordenadas de primera piedra.
                        coordenadas1 = this.ingresarCoordenadas(movimiento.substring(3, 5));
                        if (this.getError().contains("Coordenadas OK")) {

                            //Coordenadas de segunda piedra.
                            coordenadas2 = this.ingresarCoordenadas(movimiento.substring(5, 7));
                            if (this.getError().contains("Coordenadas OK")) {

                                movOk = ingresarPatronPDJ(coordenadas1[0], coordenadas1[1], coordenadas2[0], coordenadas2[1], this.getJugadorDeTurno(this.getTurno()));

                            } else {
                                //Ya esta seteado el error
                            }
                        } else {
                            //Ya esta seteado el error
                        }
                    } else {
                        this.setError("El movimiento ingresado no es valido");
                    }
                    break;

                case 8: //PATRON DOS PIEDRAS SEPARADAS "PDS"
                    aux = movimiento.substring(0, 3);

                    if (aux.equalsIgnoreCase("PDS")) {

                        //Coordenadas de primera piedra.
                        coordenadas1 = this.ingresarCoordenadas(movimiento.substring(3, 5));
                        if (this.getError().contains("Coordenadas OK")) {

                            //Coordenadas de segunda piedra.                                
                            coordenadas2 = this.ingresarCoordenadas(movimiento.substring(5, 7));
                            if (this.getError().contains("Coordenadas OK")) {
                                ficha = movimiento.toUpperCase().charAt(7);
                                movOk = ingresarPatronPDS(coordenadas1[0], coordenadas1[1], ficha, coordenadas2[0], coordenadas2[1], this.getJugadorDeTurno(this.getTurno()));
                            } else {
                                //Ya esta seteado el error
                            }
                        } else {
                            //Ya esta seteado el error
                        }

                    } else {
                        //PATRON DOS CABALLO "PDC"
                        if (aux.equalsIgnoreCase("PDC")) {

                            //Coordenadas de primera piedra.
                            coordenadas1 = this.ingresarCoordenadas(movimiento.substring(3, 5));
                            if (this.getError().contains("Coordenadas OK")) {

                                //Coordenadas de segunda piedra.                                
                                coordenadas2 = this.ingresarCoordenadas(movimiento.substring(5, 7));
                                if (this.getError().contains("Coordenadas OK")) {
                                    ficha = movimiento.toUpperCase().charAt(7);
                                    movOk = ingresarPatronPDC(coordenadas1[0], coordenadas1[1], ficha, coordenadas2[0], coordenadas2[1], this.getJugadorDeTurno(this.getTurno()));
                                } else {
                                    //Ya esta seteado el error
                                }
                            } else {
                                //Ya esta seteado el error
                            }
                        } else {
                            this.setError("El movimiento ingresado no es valido");
                        }
                    }
                    break;

                case 9:
                    aux = movimiento.substring(0, 3);
                    if (aux.equalsIgnoreCase("PDD")) {

                        //Coordenadas de primera piedra.
                        coordenadas1 = this.ingresarCoordenadas(movimiento.substring(3, 5));
                        if (this.getError().contains("Coordenadas OK")) {

                            //Coordenadas de segunda piedra.                                
                            coordenadas2 = this.ingresarCoordenadas(movimiento.substring(5, 7));
                            if (this.getError().contains("Coordenadas OK")) {
                                ficha = movimiento.toUpperCase().charAt(7);
                                ficha2 = movimiento.toUpperCase().charAt(8);
                                movOk = ingresarPatronPDD(coordenadas1[0], coordenadas1[1], ficha, ficha2, coordenadas2[0], coordenadas2[1], this.getJugadorDeTurno(this.getTurno()));
                            } else {
                                //Ya esta seteado el error
                            }
                        } else {
                            //Ya esta seteado el error
                        }
                    } else {
                        this.setError("El movimiento ingresado no es valido");
                    }
                    break;
                default:
                    this.setError("El movimiento ingresado no es valido");
                    break;
            }

        } else { //NO ES UN PATRON

            switch (movimiento.length()) {

                case 1: //ABANDONAR O AYUDA
                    aux = movimiento.substring(0);

                    if (validaAbandonar(aux)) {
                        this.setError("!!! Abandona !!!");

                    } else {
                        if (aux.equalsIgnoreCase("A")) {

                            String mensaje = "";
                            if (this.getPatronesPosibles(this.getJugadorDeTurno(this.getTurno())).size() > 0) {
                                mensaje = "AYUDA";

                            } else {
                                if (mensaje.equalsIgnoreCase("")) {
                                    mensaje = "\n No existen patrones posibles para este jugador";
                                }
                            }
                            this.setError(mensaje);
                        }
                    }
                    break;

                case 2: //DESCARTA FICHA
                    aux = movimiento.substring(0, 1);

                    if (aux.equalsIgnoreCase("D")) {
                        this.setError("Movimiento OK");
                        switch (movimiento.substring(1, 2).toUpperCase()) {
                            case "C":
                                if (this.getJugadorDeTurno(this.getTurno()).getCuboColor('C') > 0) {
                                    this.getJugadorDeTurno(this.getTurno()).setCuboColor('C', -1);
                                } else {
                                    this.setError("No hay mas fichas Celestes");
                                }
                                break;
                            case "A":
                                if (this.getJugadorDeTurno(this.getTurno()).getCuboColor('A') > 0) {
                                    this.getJugadorDeTurno(this.getTurno()).setCuboColor('A', -1);
                                } else {
                                    this.setError("No hay mas fichas Azules");
                                }
                                break;
                            case "V":
                                if (this.getJugadorDeTurno(this.getTurno()).getCuboColor('V') > 0) {
                                    this.getJugadorDeTurno(this.getTurno()).setCuboColor('V', -1);
                                } else {
                                    this.setError("No hay mas fichas Verdes");
                                }
                                break;
                            case "R":
                                if (this.getJugadorDeTurno(this.getTurno()).getCuboColor('R') > 0) {
                                    this.getJugadorDeTurno(this.getTurno()).setCuboColor('R', -1);
                                } else {
                                    this.setError("No hay mas fichas Rojas");
                                }
                                break;
                            default:
                                this.setError("El movimiento ingresado no es valido.Ficha");
                                break;
                        }
                    } else {
                        this.setError("El movimiento ingresado no es valido.");
                    }
                    break;

                case 4: // INGRESA PIEDRA EN FORMATO HORIZONTAL Y DIAGONAL
                    aux = movimiento.substring(0, 2);
                    int[] coordenadas; //int[2]
                    if (aux.equalsIgnoreCase("PH") || aux.equalsIgnoreCase("PD")) {
                        coordenadas = this.ingresarCoordenadas(movimiento.substring(2, 4));
                        if (this.getError().contains("Coordenadas OK")) {
                            if (this.getTurno() == 1) {
                                this.ingresarPiedra(coordenadas[0], coordenadas[1], movimiento.substring(1, 2), jugador1, jugador2);
                            }
                            if (this.getTurno() == 2) {
                                this.ingresarPiedra(coordenadas[0], coordenadas[1], movimiento.substring(1, 2), jugador2, jugador1);
                            }
                        }
                    } else {
                        this.setError("El movimiento ingresado no es valido");
                    }
                    break;
                default:
                    this.setError("El movimiento ingresado no es valido");
                    break;

            }
        }
        return salida;
    }

    private boolean validaAbandonar(String ingreso) {

        boolean confirmar;
        if (ingreso.equalsIgnoreCase("X")) {
            confirmar = true;
        } else {
            this.setError("El movimiento ingresado no es valido");
            confirmar = false;
        }
        return confirmar;
    }

    public void abandonar() {

        //Si abandona el otro jugador queda con 0 fichas.
        int[] fichas = new int[4];
        //Jugador 1 Abandona.
        if (this.turno == 1) {
            this.getJugador2().setCubos(fichas);
            this.setEstado(2);
        }
        //Jugador 2 Abandona.
        if (this.turno == 2) {
            this.getJugador1().setCubos(fichas);
            this.setEstado(1);
        }

        this.setError("Abandona");
    }

    private int[] ingresarCoordenadas(String coordenada) {
        /*Posiciones:
         0-Filas
         1-Columnas
         */
        int[] lasCoordendas = new int[2];
        int cantFilas = this.getTablero().getMatrizTablero().length;
        int cantColumnas = this.getTablero().getMatrizTablero()[0].length;
        //Tomo el primero caracter y si es letra lo referencio a la Fila.
        String retorno = "Coordenadas OK\n"; //Mensaje de salida.
        String laFila = null;
        int laColumna = Integer.MIN_VALUE;
        int numFila = 0;
        boolean letraOk = false;
        boolean numOk = true;
        HashMap<Integer, String> mapLetras = new HashMap<>();
        mapLetras.put(0, "A");
        mapLetras.put(1, "B");
        mapLetras.put(2, "C");
        mapLetras.put(3, "D");
        mapLetras.put(4, "E");
        mapLetras.put(5, "F");

        laFila = coordenada.trim().substring(0, 1);
        laFila = laFila.toUpperCase();

        //Valido el primer Caracter de la Fila que sea una letra valida
        for (int i = 0; i < cantFilas; i++) {
            if (mapLetras.get(i).equalsIgnoreCase(laFila)) {
                letraOk = true;
                numFila = i;
            }
        }
        if (!letraOk) {
            retorno = "!!! El valor de la fila es Incorrecto !!! \n";
        }

        //Valido el segundo caracter sea un número y que sea valido.
        try {
            laColumna = Integer.parseInt(coordenada.trim().substring(1, 2));

        } catch (Exception e) {
            retorno = retorno + " !!! El valor de la columna debe ser númerico !!! \n";
            numOk = false;

        }
        if ((laColumna < 1) || (laColumna > cantColumnas)) {
            retorno = " !!! El valor de la columna esta fuera de rango !!! \n";
            numOk = false;
        }

        lasCoordendas[0] = numFila;
        lasCoordendas[1] = laColumna - 1;
        this.setError(retorno);
        return lasCoordendas;

    }

    /*
     Retorna la coordenada en formato correcto para mostrsela al jugador.
     */
    private String retornarCorrdenada(String laCoordenada) {
        String retorno = "";

        HashMap<Integer, String> mapLetras = new HashMap<>();
        mapLetras.put(1, "A");
        mapLetras.put(2, "B");
        mapLetras.put(3, "C");
        mapLetras.put(4, "D");
        mapLetras.put(5, "E");
        mapLetras.put(6, "F");

        retorno = laCoordenada.substring(0, 3)
                + mapLetras.get(Integer.parseInt(laCoordenada.trim().substring(3, 4)))
                + laCoordenada.trim().substring(4, 5)
                + mapLetras.get(Integer.parseInt(laCoordenada.trim().substring(5, 6)))
                + laCoordenada.substring(6, 7);
        return retorno;
    }

    /*
     Antes de usar este metodo validamos la existencia de piedras.
     */
    private boolean ingresarCubo(int i, int j, String orientacion, Jugador jugadorTurno, Jugador jugadorEspera) {
        boolean retorno = false;
        this.setError("Movimiento OK");
        //Restamos Piedra.
        /*
         Si no hay piedra y la partida cuenta con al menos "1" piedra.
         */
        if (this.getTablero().getMatrizTablero()[i][j] != '#' && this.getCantidadPiedras() > 0
                && this.getTablero().getMatrizTablero()[i][j] != ' ') {
            this.setCantidadPiedras(this.getCantidadPiedras() - 1);

            //Toma la ficha y se la asigna al jugador.
            jugadorTurno.setCuboColor(this.getTablero().getMatrizTablero()[i][j], 1);

            //Colocamos la piedra
            this.getTablero().getMatrizTablero()[i][j] = '#';
            /*
             Asignamos piedras al oponente.
             */
            if (orientacion.equalsIgnoreCase("H")) {
                if (j > 0 && this.getTablero().getMatrizTablero()[i][j - 1] != '#') {
                    jugadorEspera.setCuboColor(this.getTablero().getMatrizTablero()[i][j - 1], 1);
                    this.getTablero().getMatrizTablero()[i][j - 1] = ' ';

                }
                if ((j < (this.getTablero().getMatrizTablero()[0].length - 1)) && (this.getTablero().getMatrizTablero()[i][j + 1] != '#')) {
                    jugadorEspera.setCuboColor(this.getTablero().getMatrizTablero()[i][j + 1], 1);
                    this.getTablero().getMatrizTablero()[i][j + 1] = ' ';
                }
                if (i > 0 && this.getTablero().getMatrizTablero()[i - 1][j] != '#') {
                    jugadorEspera.setCuboColor(this.getTablero().getMatrizTablero()[i - 1][j], 1);
                    this.getTablero().getMatrizTablero()[i - 1][j] = ' ';
                }
                if ((i < (this.getTablero().getMatrizTablero().length - 1)) && (this.getTablero().getMatrizTablero()[i + 1][j] != '#')) {
                    jugadorEspera.setCuboColor(this.getTablero().getMatrizTablero()[i + 1][j], 1);
                    this.getTablero().getMatrizTablero()[i + 1][j] = ' ';
                }
            } else {

                if (orientacion.equalsIgnoreCase("D")) {
                    if ((i > 0 && j > 0) && this.getTablero().getMatrizTablero()[i - 1][j - 1] != '#') {
                        jugadorEspera.setCuboColor(this.getTablero().getMatrizTablero()[i - 1][j - 1], 1);
                        this.getTablero().getMatrizTablero()[i - 1][j - 1] = ' ';
                    }
                    if ((i > 0 && j < (this.getTablero().getMatrizTablero()[0].length - 1)) && (this.getTablero().getMatrizTablero()[i - 1][j + 1] != '#')) {
                        jugadorEspera.setCuboColor(this.getTablero().getMatrizTablero()[i - 1][j + 1], 1);
                        this.getTablero().getMatrizTablero()[i - 1][j + 1] = ' ';
                    }
                    if (((i < this.getTablero().getMatrizTablero().length - 1)
                            && (j < this.getTablero().getMatrizTablero()[0].length - 1)) && this.getTablero().getMatrizTablero()[i + 1][j + 1] != '#') {
                        jugadorEspera.setCuboColor(this.getTablero().getMatrizTablero()[i + 1][j + 1], 1);
                        this.getTablero().getMatrizTablero()[i + 1][j + 1] = ' ';
                    }
                    if ((i < this.getTablero().getMatrizTablero().length - 1)
                            && (j > 0) && (this.getTablero().getMatrizTablero()[i + 1][j - 1] != '#')) {
                        jugadorEspera.setCuboColor(this.getTablero().getMatrizTablero()[i + 1][j - 1], 1);
                        this.getTablero().getMatrizTablero()[i + 1][j - 1] = ' ';
                    }
                }
            }

        } else {

            if (this.getTablero().getMatrizTablero()[i][j] == ' ') {
                this.setError("!!! Movimiento invalido !!!\n    No hay ficha en esa posición\n ");
            }
            if (this.getTablero().getMatrizTablero()[i][j] == '#') {
                this.setError("!!! Movimiento invalido !!!\n    Hay una piedra en la posición indicada\n ");

            }

            if (this.getCantidadPiedras() == 0) {
                this.setError("!!! No hay piedras disponibles !!!\n");
            }
        }
        return retorno;
    }
