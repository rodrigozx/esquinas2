/*****************************************************
    Clase: Tablero
    @author Rodrigo Blanco - 151251 - Programación II
    **************************************************
*/

package Dominio;

import java.util.*;

public class Tablero {

    //Matríz de int (cubos)
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
    
        Para la identificación de los dígitos se divide entre 10, resultando
        el entero = al primer dígito y el resto en el segundo.
     */
    private int[][] matrizTablero;
    private int cantCubosJug1;
    private int cantCubosJug2;

    /* CONSTRUCTOR *************************************/
    public Tablero() {
        this.matrizTablero = new int[6][6];
        this.cantCubosJug1 = 25;
        this.cantCubosJug2 = 25;
    }

    /* CONSTRUCTOR POR PARAMETROS *************************************/
    public Tablero(int[][] matrizTablero, int cantCubos) {
        this.matrizTablero = matrizTablero;
        this.cantCubosJug1 = cantCubos;
        this.cantCubosJug2 = cantCubos;
    }

    /* GETS Y SETS *************************************/
    public int[][] getMatrizTablero() {
        return matrizTablero;
    }

    public void setMatrizTablero(int[][] matrizTablero) {
        this.matrizTablero = matrizTablero;
    }
    
    public int getCantCubosJug1() {
        return this.cantCubosJug1;
    }

    public int getCantCubosJug2() {
        return this.cantCubosJug2;
    }

    public void setCantCubosJug1(int cantCubosJug1) {
        this.cantCubosJug1 = cantCubosJug1;
    }

    public void setCantCubosJug2(int cantCubosJug2) {
        this.cantCubosJug2 = cantCubosJug2;
    }
   
    /* METODOS *************************************/
    public int getPuntosJugador(Jugador jugador) {
        int puntos = 0;

        return puntos;
    }

   
    public boolean colocarCubo(String jugada, int turno) {
        /*
        Coloco cubo en la posición solicitada
        Devuelvo false si da error
        */
        boolean jugadaOk;
        
        //valido la jugada 
        jugadaOk = validarJugada(jugada, turno);

        return jugadaOk;
    }

    public boolean validarJugada(String jugada, int turno) {
        /*Este método valida la jugada contolando:
             - que no exista ganador.
             - que quien juega tenga cubos.
             - que la posición dónde se quiere colocar el cubo esté vacía.
             - que la posición tenga cubos adyascentes (excepto 1ra. jugada).
             - que no se forme un cuadrado de 2x2.
         */
        
        boolean jugadaOk;
        jugadaOk = false;
        int[] coordenadas1;
        int[] coordenadas2;
        return jugadaOk;
    }

    public void tableroInicial(){
        for (int i = 0; i < this.matrizTablero.length; i++) {
            for (int j = 0; j < this.matrizTablero[i].length; j++) {
                this.matrizTablero[i][j] = 0;
            }
        }
    }
    
}
