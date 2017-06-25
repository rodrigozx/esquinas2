/** ***************************************************
 * Clase: SeleccionarJugadores
 *
 * @author Rodrigo Blanco - 151251 - Programación II
 * *************************************************
 */

package Interfaz;

import Dominio.Jugador;
import Dominio.Partida;
import Dominio.Sistema;
import java.awt.Image;
import java.awt.MenuComponent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SeleccionarJugadores extends javax.swing.JFrame {

    private Sistema Modelo;
    private Image stonesIcon = (new ImageIcon("src/Img/stonesicon.png").getImage());
    private ImageIcon background = new ImageIcon("src/Img/background-selecJugadores.png");
    private ImageIcon atrasIco = new ImageIcon("src/Img/volver.png");
    private ImageIcon jugarIco = new ImageIcon("src/Img/jugar.png");
    private ImageIcon expJugIco = new ImageIcon("src/Img/expJugIco.png");

    public SeleccionarJugadores(Dominio.Sistema elModelo) {
       Modelo = elModelo;

        //Primero seteo la imagen de fondo
        this.setContentPane(new JLabel(background));

        initComponents();
        setLocationRelativeTo(null);//Ventana Centrada
        setResizable(false);//Impedir que se maximice
        setTitle("STONES - Importar/Exportar Jugadores");
        
        //Seteo imagen de icono
        this.setIconImage(stonesIcon);
        
       //Seteo imagenes de los botones
        jButJugar.setIcon(jugarIco);
        jBAtras.setIcon(atrasIco);

        //seteo el fondo transparente
        jButJugar.setOpaque(false);
        jBAtras.setOpaque(false);
        
        jButJugar.setContentAreaFilled(false);
        jBAtras.setContentAreaFilled(false);

        jButJugar.setBorderPainted(false);
        jBAtras.setBorderPainted(false);
        
        //Sin texto
        jButJugar.setText("");
        jBAtras.setText("");
        
        //tooltips de ayuda
       jButJugar.setToolTipText("Presiona aquí para comenzar la partida!");
        jBAtras.setToolTipText("Cliquea aquí para volver al Menú Principal");
        
        jButJugar.setEnabled(true);
        jBAtras.setEnabled(true);
        
        this.getJugadoresList(elModelo.getListaJugadores());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListJugadoresSeleccionados = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListListaJugadores = new javax.swing.JList();
        jButQuitar = new javax.swing.JButton();
        jButAgregar = new javax.swing.JButton();
        jButJugar = new javax.swing.JButton();
        jBAtras = new javax.swing.JButton();

        jButton2.setText(">");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));

        jLabel1.setText("Seleccione los jugadores y luego pulse Jugar.");

        jScrollPane1.setViewportView(jListJugadoresSeleccionados);

        jScrollPane2.setViewportView(jListListaJugadores);

        jButQuitar.setText("<");
        jButQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButQuitarActionPerformed(evt);
            }
        });

        jButAgregar.setText(">");
        jButAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButAgregarActionPerformed(evt);
            }
        });

        jButJugar.setText("Jugar");
        jButJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButJugarActionPerformed(evt);
            }
        });

        jBAtras.setText("Atras");
        jBAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBAtras)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(60, 60, 60)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jButQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(54, 54, 54))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBAtras))
                    .addComponent(jButJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Llenar el JCbox con La lista de jugadores
    DefaultListModel dlmListaJugadores = new DefaultListModel();

    public void getJugadoresList(ArrayList<Jugador> unaListaJugadores) {

        jListListaJugadores.removeAll();

        for (int i = 0; i < unaListaJugadores.size(); i++) {
            dlmListaJugadores.addElement(unaListaJugadores.get(i).getAlias());
        }
        jListListaJugadores.setModel(dlmListaJugadores);
    }


    private void jButQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButQuitarActionPerformed
        /*
         Accion de quitar de la lista de jugadores.
         */

        dlmListaJugadores.addElement(jListJugadoresSeleccionados.getSelectedValue());
        jListListaJugadores.setModel(dlmListaJugadores);
        dlmSeleccionar.removeElement(jListJugadoresSeleccionados.getSelectedValue());

        this.habilitarJugar();
    }//GEN-LAST:event_jButQuitarActionPerformed

    DefaultListModel dlmSeleccionar = new DefaultListModel();
    private void jButAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButAgregarActionPerformed
        /*
         Acción al agregar un jugador a la segunda lista pinchando en la primera.
         */
        if (jListListaJugadores.getSelectedValue() != null) {
            if (dlmSeleccionar.getSize() < 2) {
                dlmSeleccionar.addElement(jListListaJugadores.getSelectedValue());
                jListJugadoresSeleccionados.setModel(dlmSeleccionar);
                dlmListaJugadores.removeElement(jListListaJugadores.getSelectedValue());
            } else {
                JOptionPane.showMessageDialog(null, "Solo puede marcar dos Jugadores\n"
                        + "Si lo desea puede marcar uno y quitarlo.");
            }
            this.habilitarJugar();
        }
    }//GEN-LAST:event_jButAgregarActionPerformed

    private void jButJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButJugarActionPerformed
        //Accion al presionar el boton Jugar
        //Posición del jugador 1 en el arrayList.
       Partida laPartida = new Partida((Jugador) dlmSeleccionar.get(0), (Jugador) dlmSeleccionar.get(1),1,false,25);
        Modelo.setPartida(laPartida);
        TableroJuego vTablero = null;
        vTablero = new TableroJuego(Modelo);
        vTablero.setSize(900, 600);
        vTablero.setTitle("Esquinas - Partida en Juego");
        vTablero.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButJugarActionPerformed

    //Acción Boton atras
    private void jBAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtrasActionPerformed
        MenuPrincipal vMenuPrinipal = new MenuPrincipal(Modelo);
        vMenuPrinipal.setSize(this.getSize());
        vMenuPrinipal.setVisible(true);
        dispose();

    }//GEN-LAST:event_jBAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    private void habilitarJugar() {
        if (dlmSeleccionar.getSize() == 2) {
            jButJugar.setEnabled(true);
        } else {
            jButJugar.setEnabled(false);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtras;
    private javax.swing.JButton jButAgregar;
    private javax.swing.JButton jButJugar;
    private javax.swing.JButton jButQuitar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jListJugadoresSeleccionados;
    private javax.swing.JList jListListaJugadores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
