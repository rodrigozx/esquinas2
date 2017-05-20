/** ***************************************************
 * Clase: color
 *
 * @author Rodrigo Blanco - 151251 - Programación II
 * *************************************************
 */
package Interfaz;

public class Color {

    public String getColor(String nombreColor) {

        String impColor;

        switch (nombreColor) {
            case "NEGRO":
                impColor = "";
                break;
            case "ROJO":
                impColor = "";
                break; //31
            case "VERDE":
                impColor = "";
                break;  //32
            case "AMARILO":
                impColor = "";
                break; //33 
            case "AZUL":
                impColor = "";
                break; //34
            case "MAGENTA":
                impColor = "";
                break;//35
            case "CYAN":
                impColor = "";
                break;//36
            case "BLANCO":
                impColor = "";
                break;//37
                
            //FONDOS COLOREADOS
            case "NEGROFDO":
                impColor = "";
                break;//40 
            case "ROJOFDO":
                impColor = "";
                break;//41
            case "VERDEFDO":
                impColor = "";
                break; //42
            case "AMARILLOFDO":
                impColor = "";
                break;//43 
            case "AZULFDO":
                impColor = "";
                break; //44
            case "MAGENTAFDO":
                impColor = "";
                break; //45
            case "CYANFDO":
                impColor = "";
                break;//46
            case "BLANCOFDO":
                impColor = "";
                break;//47
                
            //FORMATOS DE FUENTES
            case "NEGRITA":
                impColor = "";
                break; //1
            case "NORMAL":
                impColor = "";
                break; //21
            case "SUBRAYADO":
                impColor = "";
                break; //4
            case "NOSUBRAYADO":
                impColor = "";
                break;//24
            
            //FUENTE Y FONDO COLOREADOS
            case "AZULFDOBLANCO":
                impColor = "[34;47m";
                break;//; //Azul y fondo blanco
            case "ROJOFDOBLANCO":
                impColor = "[31;47m";
                break;//; //Rojo y fondo blanco
            case "NEGROFDOBLANCO":
                impColor = "[00;47m";
                break;//; //Negrozul y fondo blanco                

            //SIN FORMATOS NI COLORES
            case "SINFORMATO": 
                impColor =  "[00;00m";;
                break;//0
                
            default:
                throw new IllegalArgumentException("No existe el color: " + nombreColor);
        }
            //Código completo para alterar color
            impColor = (char) 27 + impColor;
            return impColor;
        }
    
}
