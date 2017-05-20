/*****************************************************
    Clase: Partida
    @author Rodrigo Blanco - 151251 - Programación II
    **************************************************
*/

package Dominio;

import java.util.*;

public class Partida {

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
        this.tablero = null;
        this.ganador = null;
        this.vsCpu = false;
    }

    /* CONSTRUCTOR POR PARAMETROS *************************************/
    public Partida(Jugador jugador1, Jugador jugador2, int turno, Tablero elTablero, boolean versusCpu, int cantCubos) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turno = turno; //se deja abierto para posibles modificaciones.
        this.tablero = elTablero;
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
          si alguno de los jugadores no tiene más fichas, entonces terminó la partida.
         0-No hay ganador
         1-Ganador Jugador1
         2-Ganador Jugador2
         */
        int estado = 0;
        if (!(this.tablero.getCantCubosJug1() == 0 && (this.tablero.getCantCubosJug2() == 0))) {
              estado =  ganadorPartida();
            }
        
        // si el estado permanece en 0 entonces no hay ganador.
        return estado;
        
    }

     public int ganadorPartida(){
        
        //calculo las fichas en el tablero
        int estado = 0;
        
        return estado;
     }
     
    public void sumarRestaCubo(int cantidadFichas, String tipoFicha, boolean esSuma) {

        Jugador jugadorAux;
        int posJugador;

        if (this.getTurno() == 1) {
            jugadorAux = this.getJugador1();
        } else {
            jugadorAux = this.getJugador2();
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

    private boolean validaAbandonar(String ingreso) {

        boolean confirmar;
        if (ingreso.equalsIgnoreCase("X")) {
            confirmar = true;
        } else {
            confirmar = false;
        }
        return confirmar;
    }

    public void abandonar() {

        //Jugador 1 Abandona.
        if (this.turno == 1) {
            this.ganador = this.jugador2;
        }
        //Jugador 2 Abandona.
        if (this.turno == 2) {
            this.ganador = this.jugador1;
        }

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
     Antes de usar este metodo validamos la existencia de los cubos.
     */
    private boolean ingresarCubo(int i, int j, Jugador jugadorTurno, Jugador jugadorEspera) {
        boolean retorno = false;

        /*
         Si no hay cubo en el lugar y el jugador tiene almenos 1 cubo
         */

        return retorno;
    }
  
}
