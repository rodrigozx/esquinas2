/*
 * @author Rodrigo Blanco 
*/

package Dominio;

import java.util.*;

public class Tablero {

    //Matríz de torres de cubos
    /*
        Los valores en cada posición de las matrices corresponden a números.
        La codificación para identificar a que corresponde es la siguiente:
        - el primer dígito determina el color de la torre, donde:
            0 = no tiene color
            1 = corresponde al color del jugador 1
            2 = corresponde al color del jugador 2
        
        - el segundo digito determina la cantidad de cubos en la torre.
            0 =corresponde a que no existen cubos.
            5 es el valor máximo posible.
    */
    
    private int [][] matrizTablero;

    /* CONSTRUCTOR *************************************/
    public Tablero() {
        this.matrizTablero = new int[6][6];

    }

    /* CONSTRUCTOR POR PARAMETROS *************************************/
    public Tablero( int[][] matrizTablero ) {
        this.matrizTablero = matrizTablero;
    }

    /* GETS Y SETS *************************************/
    public int[][] getMatrizTablero() {
        return matrizTablero;
    }

    public void setMatrizTablero(int [][] matrizTablero) {
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
