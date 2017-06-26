package Prueba;


import Dominio.*;
import Interfaz.MenuPrincipal;
import java.io.IOException;

public class Prueba {

    private static Sistema Modelo = new Sistema();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
 
        Modelo = Persistencia.ArchSistema.recuperar();
        MenuPrincipal vMenuPrincipal = new MenuPrincipal(Modelo);
        vMenuPrincipal.setVisible(true);
    }
}
