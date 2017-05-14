/*
 * @author Rodrigo Blanco 
 * @author Fernando Rivera
 */
package Dominio;

import java.util.*;

public class Tablero {

    //Matríz de fichas
    private String [][] matrizTablero;

    /* CONSTRUCTOR *************************************/
    public Tablero() {
        this.matrizTablero = new String[6][6];
    }

    /* CONSTRUCTOR POR PARAMETROS *************************************/
    public Tablero( String[][] matrizTablero ) {
        this.matrizTablero = matrizTablero;
    }

    /* GETS Y SETS *************************************/
    public String[][] getMatrizTablero() {
        return matrizTablero;
    }

    public void setMatrizTablero(String [][] matrizTablero) {
        this.matrizTablero = matrizTablero;
    }

   /* METODOS *************************************/
   public int getPuntosJugador(Jugador jugador){
       int puntos=0;

       return puntos;
   } 
   
   //Coloco cubo en la posición solicitada
   //Devuelvo false si da error
   public boolean colocarCubo(char color , String posicion){
       boolean jugadaOk;
       //valido la jugada 
       jugadaOk = validarJugada(color,posicion);
       
       return jugadaOk;
   }
   
   //valido si la jugada es posible
    public boolean validarJugada(char color, String posicion){
       boolean jugadaOk;
       jugadaOk = false;
       
       return jugadaOk;
   }
}
