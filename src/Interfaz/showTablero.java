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

        String colorBlack = Color.getColor("NEGROFDOBLANCO");//Negro y fondo blanco        

        System.out.print(colorBlack +"\n    ");
        for (int i = 0; i < cantColumnas; i++) {
            System.out.print((i + 1)+ "   ");
        }
        System.out.println("");
    }

    //Indice Izquierdo
    private static void abcIzquierda(int i) {
        String colorBlack = Color.getColor("NEGROFDOBLANCO");//Negro y fondo blanco         
        
        HashMap <Integer, String> mapLetras = new HashMap<>();
        mapLetras.put(0, "A ");
        mapLetras.put(1, "B ");
        mapLetras.put(2, "C ");
        mapLetras.put(3, "D ");
        mapLetras.put(4, "E ");
        mapLetras.put(5, "F ");
        
        System.out.print(colorBlack + mapLetras.get(i));//resetea a color negro
    }

    private static void borde(int i, int j, int[][] mat) {
        
        String colorBlack = Color.getColor("NEGROFDOBLANCO");//Negro y fondo blanco        
        String lineaAux = "";

        //Separador sólo vertical
        lineaAux = colorBlack + "  ";
        for(int x = 0; x < mat.length; x++){
            lineaAux += "*   ";
        }
        lineaAux+= "*";
        
        if (j == 0 && (i % 2 != 0)) {

            System.out.print(lineaAux +"\n");
            showTablero.abcIzquierda(i / 2);

        }

        //Separadores *
        if ((i % 2 == 0) && (j % 2 == 0) && (j < mat.length*2 -1)) {
            if (j == 0) {
                if (i > 1){
                    System.out.print( lineaAux +"\n");
                }
                System.out.print(colorBlack + "  ");
            }
            System.out.print(colorBlack + " ***");
        }

        if ((i % 2 != 0) && (j % 2 == 0)) {
            System.out.print(colorBlack +"*");
        }
        
        //Imprimo las fichas
        if ((i % 2 != 0) && (j % 2 != 0)) {
            impTorre(mat[i / 2][j / 2]);
        }
           
    }
    
    public static void impTorre(int torre) {
        //Este método es llamado por impTablero por cada ficha en la matriz
        //así sabe que debe imprimir dependiendo del tipo del valor

        /*
         Importo las definiciones de los colores de la clase Color.
         */
        String colorBlue = Color.getColor("AZULFDOBLANCO"); //Azul y fondo blanco
        String colorRed = Color.getColor("ROJOFDOBLANCO");//Rojo y fondo blanco
        String colorGreen = Color.getColor("VERDEFDOBLANCO");//Rojo y fondo blanco
        String colorBlack = Color.getColor("NEGROFDOBLANCO");//Negro y fondo blanco
        String colorMag = Color.getColor("MAGFDOBLANCO");//Negro y fondo blanco
        String resetColor = Color.getColor("SINFORMATO");//Sin formato ni color
    
        String impresTorre;
        impresTorre = colorRed + "E";
        
        if(torre > 0){
            
            //si la torre es del jugador1
            if(torre/10 == 1){
                //el segundo dígito es la cantidad
                impresTorre = colorRed + " "  + Integer.toString(torre%10)+ " " ;
            }else{//si la torre es del jugador2
                //el segundo dígito es la cantidad
                impresTorre = colorBlue + " " +Integer.toString(torre%10)+ " " ;
            }
        }else{
            impresTorre = colorBlack + "   ";
        }
            
        System.out.print(impresTorre);
    }

}

