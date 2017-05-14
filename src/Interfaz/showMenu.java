package Interfaz;

import Dominio.Jugador;
import Dominio.Tablero;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class showMenu {

    Scanner teclado = new Scanner(System.in);
    Scanner tecladoS = new Scanner(System.in);

    //Definición de variables
    private int opcion; //Referencia la opción ingresada por el usuario
    private int menuNav; //Referencia el menú seleccionado
    private boolean opcionOk;
    private int cantOpcionesMenu; //Defino cuantas opciones tendra el menú
    private boolean menuEnable; //Controla Si el menú puede mostrarse o no.

    //Defino Constructores
    //Constructor sin parametros
    public showMenu() {
        this.setOpcion(0, true);//Menú principal por defecto
        this.setMenuNav(00);//Menú princiapl por defecto
        this.setOpcionOk(true);
        this.setMenuEnable(true);

    }

    //Constructor con parametros
    public showMenu(int unMenuNav, boolean isEnable) {
        this.setMenuNav(unMenuNav);
        this.setMenuEnable(isEnable);

    }

    //Defino los metodos de acceso y modificación
    public void setOpcion(int unaOpcion, boolean isEnable) {
        unaOpcion = opcion;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setMenuNav(int unMenuNav) {
        unMenuNav = menuNav;
    }

    public int getMenuBrousing() {
        return menuNav;
    }

    public void setOpcionOk(boolean unaOpcionOk) {
        unaOpcionOk = opcionOk;
    }

    public boolean getOpcionOk() {
        return opcionOk;
    }

    public void setMenuEnable(boolean unMenuEnable) {
        unMenuEnable = menuEnable;
    }

    public boolean getMenuEnable() {
        return menuEnable;
    }

    public boolean inOpcionOk(int unaopcionUsuario) {
        return unaopcionUsuario <= this.getCantOpcionesMenu();
    }

//Este metodo repite el menú en caso de que la opción no sea valida
    //Parametros:
    //a-Resultado del metodo que verifica que la opción ingresada
    //este en el rango
    //b-Inidica que menú deseamos repetir
    public void repetirMenu(boolean inOpcionOk, int menuNav, String banner) {
        if (inOpcionOk = false) {
            System.out.println("!!! La opción ingresada es incorrecta !!!");
            System.out.println(banner);

        }
    }

    public void setCantOpcionesMenu(int unaCantOpciones) {
        cantOpcionesMenu = unaCantOpciones;
    }

    public int getCantOpcionesMenu() {
        return cantOpcionesMenu;
    }

    //Metodo lectura de enteros
    public int leerInt(String texto) {
        int retorno = Integer.MIN_VALUE;
        int flag = 0;
        while (flag == 0) {
            try {
                System.out.print(texto);
                retorno = teclado.nextInt();
                flag = 1;
            } catch (Exception e) {
                System.out.println("Debe ingresar un dato numérico.");
                teclado.next();

            }

        }

        return retorno;
    }

    //Metodo lectura de enteros
    public String leerString() {
        String retorno;
        retorno = tecladoS.nextLine().replaceAll("\\s+", "");
        while (retorno.isEmpty()) {

            System.out.println("Debe ingresar un dato.");
            retorno = tecladoS.nextLine().replaceAll("\\s+", "");

        }

        return retorno;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void showLogo(boolean isEnable) {

        String colorBlue = (char) 27 + "[34;47m"; //Azul y fondo gris
        String colorRed = (char) 27 + "[31;47m";//Rojo y fondo gris
        String colorBlack = (char) 27 + "[00;47m";//Negro y fondo gris

        String resetColor = (char) 27 + "[00;00m";

        
        if (isEnable) {
            System.out.println(""
                    + "\n" + colorBlue + "#################################################################################################"
                    + "\n" + colorBlue + "##                                                                                             ##"
                    + "\n" + colorBlue + "##   "+ colorRed +"#######"+ colorBlack +"                                        $$                               "+ colorBlue +"#######   ##"
                    + "\n" + colorBlue + "##   "+ colorRed +"#######"+ colorBlack +"                                        $$                               "+ colorBlue +"#######   ##"
                    + "\n" + colorBlue + "##   "+ colorRed +"###    "+ colorBlack +" $$$$$$    $$$$$$$   $$$$$$   $$    $$      $$$$$$$    $$$$$$    $$$$$$$ "+ colorBlue +"    ###   ##"
                    + "\n" + colorBlue + "##   "+ colorRed +"###    "+ colorBlack +"$$    $$  $$        $$    $$  $$    $$  $$  $$    $$        $$  $$       "+ colorBlue +"    ###   ##"
                    + "\n" + colorBlue + "##          "+ colorBlack               +"$$$$$$$$   $$$$$$   $$    $$  $$    $$  $$  $$    $$   $$$$$$$   $$$$$$  "+ colorBlue +"          ##"
                    + "\n" + colorBlue + "##   ###    "+ colorBlack               +"$$              $$  $$   $$$  $$    $$  $$  $$    $$  $$    $$        $$ "+ colorBlue +"    ###   ##"                    
                    + "\n" + colorBlue + "##   ###    "+ colorBlack               +" $$$$$$$  $$$$$$$    $$$$$$$$  $$$$$$   $$  $$    $$   $$$$$$$  $$$$$$$  "+ colorBlue +"    ###   ##"
                    + "\n" + colorBlue + "##   #######"+ colorBlack               +"                           $$$                                           "+ colorBlue +"#######   ##"
                    + "\n" + colorBlue + "##   #######                                                                         #######   ##"                            
                    + "\n" + colorBlue + "##                                                                                             ##"
                    + "\n" + colorBlue + "#################################################################################################"
                    + "\n" + colorBlue + "##                          by Rodrigo Blanco(151251) - May/2017 - v.1.0.0                     ##"
                    + "\n" + colorBlue + "#################################################################################################"
                    + "\n" + resetColor + "");
        }
    }
                   
                          

    public void showSaludo(boolean isEnable) {
        //Saludo al Salir del Juego.
        String color = (char) 27 + "[34;47m"; //Azul y fondo blanco
        String resetColor = (char) 27 + "[00;00m";

        if (isEnable) {
            System.out.println(""
                    + "\n" + color + "#############################################################################################################################################"
                    + "\n" + color + "##                                                                                                                                         ##"
                    + "\n" + color + "##     ▄████  ██▀███  ▄▄▄      ▄████▄   ██▓▄▄▄        ██████     ██▓███  ▒█████   ██▀███      ▄▄▄██▀▀▀█    ██   ▄████  ▄▄▄       ██▀███    ##"
                    + "\n" + color + "##    ██▒ ▀█▒▓██ ▒ ██▒████▄   ▒██▀ ▀█  ▓██▒████▄    ▒██    ▒    ▓██░  ██▒██▒  ██▒▓██ ▒ ██▒      ▒██   ██  ▓██▒ ██▒ ▀█▒▒████▄    ▓██ ▒ ██▒  ##"
                    + "\n" + color + "##   ▒██░▄▄▄░▓██ ░▄█ ▒██  ▀█▄ ▒▓█    ▄ ▒██▒██  ▀█▄  ░ ▓██▄      ▓██░ ██▓▒██░  ██▒▓██ ░▄█ ▒      ░██  ▓██  ▒██░▒██░▄▄▄░▒██  ▀█▄  ▓██ ░▄█ ▒  ##"
                    + "\n" + color + "##   ░▓█  ██▓▒██▀▀█▄ ░██▄▄▄▄██▒▓▓▄ ▄██▒░██░██▄▄▄▄██   ▒   ██▒   ▒██▄█▓▒ ▒██   ██░▒██▀▀█▄     ▓██▄██▓ ▓▓█  ░██░░▓█  ██▓░██▄▄▄▄██ ▒██▀▀█▄    ##"
                    + "\n" + color + "##   ░▒▓███▀▒░██▓ ▒██▒▓█   ▓██▒ ▓███▀ ░░██░▓█   ▓██▒▒██████▒▒   ▒██▒ ░  ░ ████▓▒░░██▓ ▒██▒    ▓███▒  ▒▒█████▓ ░▒▓███▀▒ ▓█   ▓██▒░██▓ ▒██▒  ##"
                    + "\n" + color + "##    ░▒   ▒ ░ ▒▓ ░▒▓░▒▒   ▓▒█░ ░▒ ▒  ░░▓  ▒▒   ▓▒█░▒ ▒▓▒ ▒ ░   ▒▓▒░ ░  ░ ▒░▒░▒░ ░ ▒▓ ░▒▓░    ▒▓▒▒░  ░▒▓▒ ▒ ▒  ░▒   ▒  ▒▒   ▓▒█░░ ▒▓ ░▒▓░  ##"
                    + "\n" + color + "##     ░   ░   ░▒ ░ ▒░ ▒   ▒▒ ░ ░  ▒    ▒ ░ ▒   ▒▒ ░░ ░▒  ░ ░   ░▒ ░      ░ ▒ ▒░   ░▒ ░ ▒░    ▒ ░▒░  ░░▒░ ░ ░   ░   ░   ▒   ▒▒ ░  ░▒ ░ ▒░  ##"
                    + "\n" + color + "##   ░ ░   ░   ░░   ░  ░   ▒  ░         ▒ ░ ░   ▒   ░  ░  ░     ░░      ░ ░ ░ ▒    ░░   ░     ░ ░ ░   ░░░ ░ ░ ░ ░   ░   ░   ▒     ░░   ░   ##"
                    + "\n" + color + "##         ░    ░          ░  ░ ░       ░       ░  ░      ░                 ░ ░     ░         ░   ░     ░           ░       ░  ░   ░       ##"
                    + "\n" + color + "##                            ░                                                                                                            ##"
                    + "\n" + color + "#############################################################################################################################################"
                    + "\n" + resetColor + "");
        }
    }

    //Cabecera Menu.
    public void showCabeceraMenu(boolean isEnable, String elTitulo) {

        //Centrar título
        String titulo;
        titulo = centrarTituloMenu(elTitulo, 54);
        titulo = titulo.replaceAll("#", " ");

        //Color del título
        String color = (char) 27 + "[34;47m"; //Azul y fondo blanco

        if (isEnable == true) {
            System.out.print(""
                    + "\n" + color + ""
                    + "\n" + color + "##########################################################"
                    + "\n" + color + "##" + titulo + color + "##"
                    + "\n" + color + "##########################################################");
        }
    }

    public int showMenuPrincipal(boolean isEnable, int cantOpciones) {
        //Se define la cantidad de opciones que tiene el menú.
        this.setCantOpcionesMenu(cantOpciones);

        String color;
        color = (char) 27 + "[34;47m"; //Azul y fondo blanco
        String mensaje = "MENU PRINCIPAL";
        showCabeceraMenu(isEnable, mensaje);

        if (isEnable) {
            do {
                System.out.print(""
                        + "\n" + color + "##  Digite la opción deseada:                           ##"
                        + "\n" + color + "##                                                      ##"
                        + "\n" + color + "##  1- Registro de Jugador.                             ##"
                        + "\n" + color + "##  2- Jugar partida manual.                            ##"
                        + "\n" + color + "##  3- Jugar partida contra la computadora.             ##"
                        + "\n" + color + "##  4- Ranking de Jugadores.                            ##"
                        + "\n" + color + "##                                                      ##"
                        + "\n" + color + "##  0- Fin.                                             ##"
                        + "\n" + color + "##                                                      ##"
                        + "\n" + color + "##########################################################"
                        + "\n" + "");

                opcion = this.leerInt("Opción: ");
            } while (this.inOpcionOk(opcion) == false);
        }
        return opcion;
    }

    /*
     Registrar Jugador
     */
    //El metodo recibe el arraylist de Jugadores para validar el alias.
    public String registrarJugadorAlias(ArrayList<Jugador> unaListaJugadores) {
        String alias;
        String mensaje = "";
        boolean resultado = false;

        do {
            resultado = false;
            System.out.print("\n Ingrese un Alias:" + mensaje);
//            alias = tecladoS.nextLine();
                        alias = leerString();
            for (int i = 0; i < unaListaJugadores.size(); i++) {
                if (unaListaJugadores.get(i).getAlias().equalsIgnoreCase(alias) == true) {
                    resultado = true;
                    mensaje = ", diferente !!!";
                }
            }
        } while (resultado == true);
        return alias;
    }

//El metodo recibe el arraylist de Jugadores para validar el alias.
    public String registrarJugadorNombre() {
        String nombre;
        do {
            System.out.print(" Ingrese su Nombre:");
            nombre = tecladoS.nextLine();;

        } while (nombre == null);
        return nombre;
    }

    public int registrarJugadorEdad() {
        int edad = 0;
        boolean resultado = false;

        do {
            edad = this.leerInt("Ingrese su Edad: ");
            if (edad >= 5) {
                resultado = true;
                System.out.println("");//salto de línea
            } else {
                System.out.println("##  El juego esta permitido para mayores a 5 años !!!");
            }

        } while (resultado != true);

        return edad;
    }

    public void showMenuRanking(ArrayList<Jugador> unaListaJugadores) {
        //Ranking de Jugadores
        String color;
        color = (char) 27 + "[34;47m"; //Azul y fondo blanco

    System.out.println(""
                + "\n" + color + "####################################################"
                + "\n" + color + "##                                                ##"
                + "\n" + color + "##    ┏┓┏┓┏┓ ┏━━━┓        ┏┓             ┏┓┏┓┏┓   ##"
                + "\n" + color + "##    ┃┃┃┃┃┃ ┃┏━┓┃        ┃┃             ┃┃┃┃┃┃   ##"
                + "\n" + color + "##    ┃┃┃┃┃┃ ┃┗━┛┃┏━━┓┏━┓ ┃┃┏┓┏┓┏━┓ ┏━━┓ ┃┃┃┃┃┃   ##"
                + "\n" + color + "##    ┗┛┗┛┗┛ ┃┏┓┏┛┃┏┓┃┃┏┓┓┃┗┛┛┣┫┃┏┓┓┃┏┓┃ ┗┛┗┛┗┛   ##"
                + "\n" + color + "##    ┏┓┏┓┏┓ ┃┃┃┗┓┃┏┓┃┃┃┃┃┃┏┓┓┃┃┃┃┃┃┃┗┛┃ ┏┓┏┓┏┓   ##"
                + "\n" + color + "##    ┗┛┗┛┗┛ ┗┛┗━┛┗┛┗┛┗┛┗┛┗┛┗┛┗┛┗┛┗┛┗━┓┃ ┗┛┗┛┗┛   ##"
                + "\n" + color + "##                                  ┏━┛┃          ##"
                + "\n" + color + "##                                  ┗━━┛          ##"
                + "\n" + color + "####################################################"
                + "\n" + "");


        if (unaListaJugadores.isEmpty()) {
            System.out.println("##    No hay jugadores ingresados en el sistema !!!");

        } else {
            System.out.println("## Posición - Alias - Ganadas - Perdidas               ##");
            for (int i = 0; i < unaListaJugadores.size(); i++) {
                System.out.println("##    " + (i + 1) + "     -    " + unaListaJugadores.get(i).getAlias()
                        + "   -    " + unaListaJugadores.get(i).getPartidas()[0]
                        + "   -    " + unaListaJugadores.get(i).getPartidas()[1]);

            }
        }

    }

    //Selecciono Jugador:
    //Si no tengo al cantidad minima de jugadores en el sismtea da error y devuelve jugador=null
    //si tengo el minimo o mas retorno el jugador seleccionado.
    public Jugador seleccionarJugador(String turno, ArrayList unaListaJugadores, Jugador otroJugador) {
        int numJugador = Integer.MIN_VALUE;//Numero del Jugador en la lista
        Jugador unJugador = null;

        for (int i = 0; i < unaListaJugadores.size(); i++) {
            unJugador = (Jugador) unaListaJugadores.get(i);
            System.out.println(i + 1 + "-" + unJugador.getAlias());
        }

        do {
            System.out.println("##");
            System.out.println("## Digite el número del Jugador " + turno);
            numJugador = this.leerInt("Opción: ");
            unJugador = (Jugador) unaListaJugadores.get(numJugador - 1);

            if (otroJugador != null && unJugador.equals(otroJugador)) {
                System.out.println("El Jugador " + otroJugador.getAlias() + "ya fue elegido!!!");
                numJugador = 0;
            }

        } while ((numJugador < 1) || numJugador > unaListaJugadores.size());

        return unJugador;
    }

    public void setCargaTablero(boolean isEnable, int cantOpciones, Tablero unTablero) {
        int tipoCarga = 1;
        //Se define la cantidad de opciones que tiene el menú.
        this.setCantOpcionesMenu(cantOpciones);

        String color;
        color = (char) 27 + "[34;47m"; //Azul y fondo blanco

        if (isEnable) {
            do {
                System.out.print(""
                        + "\n" + color + "##                                                      ##"
                        + "\n" + color + "##  1- Tablero por defecto.                             ##"
                        + "\n" + color + "##  2- Tablero al azar.                                 ##"
                        + "\n" + color + "##                                                      ##"
                        + "\n" + color + "##########################################################"
                        + "\n" + "");

                opcion = this.leerInt("Opción: ");

            } while (this.inOpcionOk(opcion) == false);

        }

    }

    /*Metodos pedir datos de jugada.
     */
    public String ingresarMovimiento(boolean isEnable) {
        String retorno = null;

        String color;
        color = (char) 27 + "[34;47m"; //Azul y fondo blanco
        String mensaje = "Próximo Movimiento";
        showCabeceraMenu(isEnable, mensaje);

        if (isEnable) {
            System.out.println(""
                    + "\n" + color + "## " + "Ingrese su Jugada:");

            retorno = this.tecladoS.nextLine();

        }

        return retorno;

    }

    public String centrarTituloMenu(String elTitulo, int cantCaracteres) {

        elTitulo = elTitulo.trim();

        int largo;
        String tituloCentrado = elTitulo;

        largo = elTitulo.length();
        int faltaCaracteres = (cantCaracteres - largo);
        faltaCaracteres = faltaCaracteres / 2;
        if (largo < cantCaracteres) {

            tituloCentrado = padLString(tituloCentrado, faltaCaracteres);
            tituloCentrado = padRString(tituloCentrado, faltaCaracteres);
        }

        return tituloCentrado.trim();
    }

    public static String padRString(String elTitulo, int espacios) {

        for (int i = 1; i < espacios; i++) {
            //termino uno antes por el punto
            elTitulo = " ".concat(elTitulo);
        }
        elTitulo = "#".concat(elTitulo);

        return elTitulo;
    }

    public String padLString(String elTitulo, int espacios) {

        for (int i = 1; i < espacios; i++) {
            //termino uno antes por el punto
            elTitulo = elTitulo.concat(" ");
        }
        elTitulo = elTitulo.concat("#");
        return elTitulo;
    }

    public boolean confimaMensaje(String mensaje) {
        boolean confirmacion;
        int respuesta;
        String mensajeOpciones;
        String color;
        color = (char) 27 + "[34;47m"; //Azul y fondo blanco
        showCabeceraMenu(true, mensaje);

        do {
            mensajeOpciones = (""
                    + "\n" + color + "##                                                      ##"
                    + "\n" + color + "##  1- Confirmar                                        ##"
                    + "\n" + color + "##  2- Cancelar                                         ##"
                    + "\n" + color + "##                                                      ##"
                    + "\n" + color + "##########################################################"
                    + "\n" + "Opción: ");

            respuesta = leerInt(mensajeOpciones);

        } while (respuesta != 1 && respuesta != 2);

        confirmacion = (respuesta == 1);// si es 1 es true
        return confirmacion;
    }

}
