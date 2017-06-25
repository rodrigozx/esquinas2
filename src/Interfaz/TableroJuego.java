/** ***************************************************
 * Clase: TableroJuego
 *
 * @author Rodrigo Blanco - 151251 - Programación II
 * *************************************************
 */
package Interfaz;

import Dominio.Jugador;
import Dominio.Partida;
import Dominio.Sistema;
import Dominio.Tablero;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
//import java.awt.Image;
//import java.awt.MenuComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;

public class TableroJuego extends javax.swing.JFrame {

    private Sistema Modelo;
    private ImageIcon background = new ImageIcon("src/Img/background-selecJugadores.png");
    private ImageIcon atrasIco = new ImageIcon("src/Img/volver.png");
    private ImageIcon jugarIco = new ImageIcon("src/Img/jugar.png");
    private JButton[][] botones;

    public TableroJuego(Sistema elModelo) {
        Modelo = elModelo;
        initComponents();
        this.setVisible(true);
        setResizable(false);
        this.showTablero(elModelo.getPartida().getTablero());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(581, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableroJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableroJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableroJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableroJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables

    private void showTablero(Tablero elTablero) {

        // crear botones y agregarlos al panel
        panelJuego.removeAll();
        panelJuego.setLayout(new GridLayout(7, 7));
        botones = new JButton[7][7];
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[0].length; j++) {
                JButton jButton = new JButton();
                if ((i == 0 || j == 0)) {
                    if (i == 0 && j == 0) {
                        jButton.setText(Integer.toString(j));
                        jButton.setVisible(false);
                        panelJuego.add(jButton);
                    } else {
                        if (i == 0) {
                            jButton.setText(Integer.toString(j));
                            panelJuego.add(jButton);
                            jButton.setEnabled(false);
                        }
                        if (j == 0) {
                            jButton.setText(numLetra(i));
                            panelJuego.add(jButton);
                            jButton.setEnabled(false);
                        }
                    }
                } else {

                    jButton.addActionListener(new ListenerBotonTablero(i, j));
                    panelJuego.add(jButton);
                    int valorCelda = elTablero.getMatrizTablero()[i][j];
                    jButton.setText(Integer.toString(valorCelda));
                }

                botones[i][j] = jButton;
                botones[i][j].setMargin(new Insets(-5, -5, -5, -5));

            }

        }

        //Border thickBorder = new LineBorder(Color.WHITE, 5);
    }

    //Metodo para el indice, recibe un número y retorna la letra que 
    // corresponde.
    private String numLetra(int i) {
        HashMap<Integer, String> mapLetras = new HashMap<>();
        mapLetras.put(0, "A");
        mapLetras.put(1, "A");
        mapLetras.put(2, "B");
        mapLetras.put(3, "C");
        mapLetras.put(4, "D");
        mapLetras.put(5, "E");
        mapLetras.put(6, "F");
        return mapLetras.get(i);

    }
    
    private class ListenerBotonTablero implements ActionListener {

        private int x;
        private int y;

        public ListenerBotonTablero(int i, int j) {
            // en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

//            //Si ingreso Piedra
//            switch (laJugada) {
//
//                case "P": //Poner piedra.
//                    accionPonerPiedra(x, y);
//                    //Mensaje error.
//
//                    break;
//                default:
//                    clickBotonMatriz(x, y);
//                    break;
//
//            }            
            // cuando se presiona un botón, se ejecutará este método
            clickBotonMatriz(x, y);
        }
    }

    private void clickBotonMatriz(int fila, int columna) {
        
        JOptionPane.showMessageDialog(null, "you click fila: " + fila + " and columna: " + columna);
        this.showTablero(Modelo.getPartida().getTablero());
        
    }   

    
 
}
