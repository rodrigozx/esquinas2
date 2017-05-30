
package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Dominio.Sistema;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;


public class ArchSistema {

    public static void guardar(Sistema miSistema) throws IOException {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("elSistemaData.obj"))) {
            salida.writeObject(miSistema);
        }
    }

    public static Sistema recuperar() throws IOException, ClassNotFoundException {
        Sistema elSistema = null;
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("elSistemaData.obj"))) {
            elSistema = (Sistema) entrada.readObject();
        } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Archivo de persistencia no encontrado");
        }
        return elSistema;

    }

}
