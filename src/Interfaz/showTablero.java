/*****************************************************
    Clase: showTablero
    @author Rodrigo Blanco - 151251 - Programación II
    **************************************************
*/
package Interfaz;

import java.util.HashMap;

public class showTablero {

//Recorro la matriz y dibujo
    public static void show(int[][] laMat) {
        boolean paso = false;

        for (int i = 0; i < ((laMat.length * 2) + 1); i++) {
            for (int j = 0; j < (laMat[0].length * 2) + 1; j++) {
                //Dibuja el indice superior 
                if (!paso) {
                    numSup(laMat[i].length);
                    paso = true;
                    i = 0;
                }
                if (paso) {
                    borde(i, j, laMat);
                }
            }
            System.out.println();
        }
    }

    //Indice Superior Números
    private static void numSup(int cantColumnas) {
        System.out.println("");
        System.out.print("  ");
        for (int i = 0; i < cantColumnas; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println("");
    }

    //Indice Izquierdo Letras
    private static void abcIzquierda(int i) {
        HashMap<Integer, String> mapLetras = new HashMap<>();
        mapLetras.put(0, "A ");
        mapLetras.put(1, "B ");
        mapLetras.put(2, "C ");
        mapLetras.put(3, "D ");
        mapLetras.put(4, "E ");
        mapLetras.put(5, "F ");
        System.out.print(((char) 27 + "[0m" )+ mapLetras.get(i));//resetea a color negro
    }

    private static void borde(int i, int j, int[][] mat) {
        if (j == 0 && (i % 2 != 0)) {
            //  System.out.println();
            showTablero.abcIzquierda(i / 2);
        }
        //Si i es par colocamos filas +-+-
        //Caso que es par colocamos +
        if ((i % 2 == 0) && (j % 2 == 0)) {
            if (j == 0) {
                System.out.print((char) 27 + "[0m" + "  ");
            }
            System.out.print((char) 27 + "[0m" + "+");
        }
        //Caso que es impar colocamos -
        if ((i % 2 == 0) && (j % 2 != 0)) {
            System.out.print((char) 27 + "[0m" + "-");
        }

        //Si i es impar colocamos filas |"Car"
        //Caso que es par colocamos +
        if ((i % 2 != 0) && (j % 2 == 0)) {
            System.out.print((char) 27 + "[0m" +"|");
        }
        //Caso que es impar colocamos -
        if ((i % 2 != 0) && (j % 2 != 0)) {
            impTorre(mat[i / 2][j / 2]);
        }
    }
    
    public static void impTorre(int torre) {
        //Este método es llamado por impTablero por cada ficha en la matriz
        //así sabe que debe imprimir dependiendo del tipo del valor
        String impresTorre;
        switch(torre){
            case 0:
                impresTorre = " ";
                break;
            default:
                impresTorre = " ";
                break;
        }
        System.out.print(impresTorre);
    }

}

