/*
 * @author Rodrigo Blanco 
 * @author Fernando Rivera
 */
package Dominio;

import Dominio.Torre;
import java.util.*;

public class Tablero {

    //Matríz de fichas
    private Torre[][] matrizTablero;

    /* CONSTRUCTOR *************************************/
    public Tablero() {
        this.matrizTablero = new Torre[6][6];
    }

    /* CONSTRUCTOR POR PARAMETROS *************************************/
    public Tablero( Torre[][] matrizTablero ) {
        this.matrizTablero = matrizTablero;
    }

    /* GETS Y SETS *************************************/
    public Torre[][] getMatrizTablero() {
        return matrizTablero;
    }

    public void setMatrizTablero(Torre [][] matrizTablero) {
        this.matrizTablero = matrizTablero;
    }

   /* METODOS *************************************/
   public int getPuntosJugador(Jugador jugador){
       int puntos=0;

       return puntos;
   } 
   

   
}
