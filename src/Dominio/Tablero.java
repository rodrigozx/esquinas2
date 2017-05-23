/** ***************************************************
 * Clase: Tablero
 *
 * @author Rodrigo Blanco - 151251 - Programación II
 * *************************************************
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

    public String colocarCubo(int fila, int columna, int turno) {
        /*
        Coloco cubo en la posición solicitada
         */
        String retorno;
        int cubo;
        
        //valido la jugada 
        retorno = validarJugada(fila, columna, turno);

        if (retorno.equals("OK")) {
            //coloco el cubo en la posición.
            cubo = (turno * 10) + 1;
            // 11 - significa 1 cubo del jugador 1
            // 21 - significa 1 cubo del jugador 2
            this.getMatrizTablero()[fila][columna] = cubo;
            cubo = ingresoCubosEsquinas(fila, columna, turno,true);
            System.out.println("cubos adicionales: " + Integer.toString(cubo));
        } else {
            //Si existe error al colorcar el cubo
        }

        return retorno;
    }

    public String validarJugada(int fila, int columna, int turno) {
        /*Este método valida la jugada contolando:
             - que no exista ganador.
             - que quien juega tenga cubos.
             - que la posición dónde se quiere colocar el cubo esté vacía.
             - que la posición tenga cubos adyascentes (excepto 1ra. jugada).
             - que no se forme un cuadrado de 2x2.
         */
        String retorno;

        //No existe ganador y tienen cubos
        if (this.cantCubosJug1 > 0 && this.getCantCubosJug2() > 0) {
            retorno = "OK";

            //Si el valor de la casilla no es mayor a 0
            if (!((this.getMatrizTablero()[fila][columna]) > 0)) {

                retorno = this.controlCuadrados(fila, columna);

            } else {
                //Está ocupada por otro cubo
                retorno = "Casilla Ocupada";
            }
        } else {
            retorno = "FIN";
        }
        return retorno;
    }

    public void tableroInicial() {
        for (int i = 0; i < this.matrizTablero.length; i++) {
            for (int j = 0; j < this.matrizTablero[i].length; j++) {
                this.matrizTablero[i][j] = 0;
            }
        }
    }

    
    
    public String controlCuadrados(int fila, int columna) {
        /*
        Control que no se formen cuadrados al ingresar el cubo
        y que existas torres adyascentes.
         */

        String retorno;
        retorno = "OK";
        int casillasOcupadas = 0;
        int casillasOcupadasTotal = 0;

        //arriba izquierda
        casillasOcupadas += casillaOcupada(fila - 1, columna - 1);
        casillasOcupadas += casillaOcupada(fila - 1, columna);
        casillasOcupadas += casillaOcupada(fila, columna - 1);
        casillasOcupadasTotal += casillasOcupadas;

        if (casillasOcupadas < 3) {
            casillasOcupadas = 0;
            //arriba derecha
            casillasOcupadas += casillaOcupada(fila - 1, columna);
            casillasOcupadas += casillaOcupada(fila - 1, columna + 1);
            casillasOcupadas += casillaOcupada(fila, columna + 1);
            casillasOcupadasTotal += casillasOcupadas;

            if (casillasOcupadas < 3) {
                casillasOcupadas = 0;
                //abajo derecha
                casillasOcupadas += casillaOcupada(fila, columna + 1);
                casillasOcupadas += casillaOcupada(fila + 1, columna + 1);
                casillasOcupadas += casillaOcupada(fila + 1, columna);
                casillasOcupadasTotal += casillasOcupadas;

                if (casillasOcupadas < 3) {
                    casillasOcupadas = 0;
                    //abajo izquierda
                    casillasOcupadas += casillaOcupada(fila + 1, columna);
                    casillasOcupadas += casillaOcupada(fila + 1, columna - 1);
                    casillasOcupadas += casillaOcupada(fila, columna - 1);
                    casillasOcupadasTotal += casillasOcupadas;

                    if (casillasOcupadas < 3) {

                        if ((casillasOcupadasTotal == 0) && ((this.getCantCubosJug1() < 25) || this.getCantCubosJug2() < 25)) {

                            retorno = "No hay Torres adyascentes ocupadas!";

                        } else {
                            retorno = "OK";
                        }

                    } else {
                        retorno = "Error, se forma cuadrado!";
                    }

                } else {
                    retorno = "Error, se forma cuadrado!";
                }
            } else {
                retorno = "Error, se forma cuadrado!";
            }

        } else {
            retorno = "Error, se forma cuadrado!";
        }
        return retorno;
    }

    public int casillaOcupada(int fila, int columna) {
        int retorno = 0;
        if ((fila >= 0) && (fila < (this.getMatrizTablero().length)) && (columna >= 0) && (columna < (this.getMatrizTablero().length))) {
            if (this.getMatrizTablero()[fila][columna] > 0) {
                retorno = 1;
            }
        }
        return retorno;
    }
    public int ingresoCubosEsquinas(int fila, int columna, int turno, boolean esJugada){
        
        int cubosIngresados = 0;
        boolean hayTorre = true;
        
        //Si esJugada == false, es para calcular posible cubos a ingresar
        
        //Busco esquinas por filas decreciente ********************
        for (int i = fila-1; (i >= 0) && hayTorre; i--) {

            //Si la casilla anterior por filas tiene cubos
            hayTorre = (casillaOcupada(i,columna)>0);
            
            if((hayTorre)){

                //Reviso que la torre sea menor a 5
                if( ((this.getMatrizTablero()[i][columna])%10) < 5){
                    //Reviso la columna anterior de esa fila
                    if((casillaOcupada(i,columna-1)>0)){
                        //Si tiene, es una esquina
                        //Sumo un cubo a esa esquina
                        cubosIngresados++;
                        if(esJugada){
                            setCuboAdicional(i,columna,turno);
                        }
                    }
                    //Reviso la columna posterior de esa fila
                    if((casillaOcupada(i,columna+1)>0)){
                        //Si tiene, esuna esquina
                        //Sumo un cubo a esa esquina     
                        cubosIngresados++;
                        if(esJugada){                        
                            setCuboAdicional(i,columna,turno);                        
                        }
                    }
                }
            }
        }
        
        hayTorre = true;
        
        //Busco esquinas por filas crecientes ********************
        for (int i = fila+1; (i < this.getMatrizTablero().length) && hayTorre; i++) {

            //Si la casilla posterior por filas tiene cubos
            hayTorre = (casillaOcupada(i,columna)>0);
            
            if((hayTorre)){

                //Reviso que la torre sea menor a 5
                if( ((this.getMatrizTablero()[i][columna])%10) < 5){
                    //Reviso la columna anterior de esa fila
                    if((casillaOcupada(i,columna-1)>0)){
                        //Si tiene, esuna esquina
                        //Sumo un cubo a esa esquina
                        cubosIngresados++;
                        if(esJugada){
                            setCuboAdicional(i,columna,turno);                            
                        }                        
                    }
                    //Reviso la columna posterior de esa fila
                    if((casillaOcupada(i,columna+1)>0)){
                        //Si tiene, esuna esquina
                        //Sumo un cubo a esa esquina     
                        cubosIngresados++;
                        if(esJugada){
                            setCuboAdicional(i,columna,turno);                              
                        }                        
                    }
                }
            }
        }

        hayTorre = true;
        //Busco esquinas por columnas crecientes ********************
        for (int j = columna+1; (j < this.getMatrizTablero().length) && hayTorre; j++) {

            //Si la casilla posterior por columnas tiene cubos
            hayTorre = (casillaOcupada(fila,j)>0);
            
            if((hayTorre)){

                //Reviso que la torre sea menor a 5
                if( ((this.getMatrizTablero()[fila][j])%10) < 5){
                    
                    //Reviso la fila anterior de esa columna
                    if((casillaOcupada(fila-1,j)>0)){
                        //Si tiene, es una esquina
                        //Sumo un cubo a esa esquina
                        cubosIngresados++;
                        if(esJugada){
                            setCuboAdicional(fila,j,turno);
                        }                        
                    }
                    //Reviso la fila posterior de esa columna
                    if((casillaOcupada(fila+1,j)>0)){
                        //Si tiene, es una esquina
                        //Sumo un cubo a esa esquina     
                        cubosIngresados++;
                        if(esJugada){
                            setCuboAdicional(fila,j,turno);
                        }                        
                    }
                }
            }
        }

        hayTorre = true;
        
        //Busco esquinas por columnas decrecientes ********************
        for (int j = columna-1; (j >= 0) && hayTorre; j--) {

            //Si la casilla posterior por columnas tiene cubos
            hayTorre = (casillaOcupada(fila,j)>0);
            
            if((hayTorre)){

                //Reviso que la torre sea menor a 5
                if( ((this.getMatrizTablero()[fila][j])%10) < 5){
                    
                    //Reviso la fila anterior de esa columna
                    if((casillaOcupada(fila-1,j)>0)){
                        //Si tiene, es una esquina
                        //Sumo un cubo a esa esquina
                        cubosIngresados++;
                        if(esJugada){
                            setCuboAdicional(fila,j,turno);
                        }                        
                    }
                    //Reviso la fila posterior de esa columna
                    if((casillaOcupada(fila+1,j)>0)){
                        //Si tiene, es una esquina
                        //Sumo un cubo a esa esquina     
                        cubosIngresados++;
                        if(esJugada){
                            setCuboAdicional(fila,j,turno);                                                    
                        }                        
                    }
                }
            }
        }
        return cubosIngresados;
    }
    
    public void jugadaCpu(){
        int maximo;
        maximo=0;
        String control;
        int cantCalc;
        for (int i = 0; i < this.getMatrizTablero().length; i++) {
            for (int j = 0; j < this.getMatrizTablero().length; j++) {
               control = this.controlCuadrados(i, j);
               if ((control).equals("ok")){
                   cantCalc = this.ingresoCubosEsquinas(i, maximo, j, true);
               }
            }
        }
    }
    
    public void setCuboAdicional(int fila, int columna, int turno){
        int torre;
        torre = this.getMatrizTablero()[fila][columna];
        
        //la unidad es la cantidad de cubos.
        //la decena es el número del jugador.
        torre = ((torre%10) + 1 ) + (10 * turno);
        this.getMatrizTablero()[fila][columna] = torre;
    }
}
