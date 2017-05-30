package Interfaz;

import Dominio.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Image;

public class MenuPrincipal extends javax.swing.JFrame {

    private Sistema Modelo;
    private ImageIcon patronIco = new ImageIcon("src/Img/patronIco.png");
    private ImageIcon background = new ImageIcon("src/Img/background-menu.png");
    private Image stonesIcon = (new ImageIcon("src/Img/stonesicon.png").getImage());
    
    public MenuPrincipal(Sistema elModelo) {
        Modelo = elModelo;
        
        //Primero seteo la imagen de fondo
        this.setContentPane(new JLabel(background));
        
        //Inicializo los componentes
        initComponents();
        setLocationRelativeTo(null);//Ventana Centrada
        setResizable(false);//Impedir que se maximice
        setTitle("STONES - Menú Principal");
        
        //Seteo imagen de icono
        this.setIconImage(stonesIcon);

        //Seteo imagenes de los botones
        JbJugar.setIcon(new ImageIcon("src/Img/jugar.png"));
        JbRegistrarJugador.setIcon(new ImageIcon("src/Img/registrarjugadores.png"));
        jbInfo.setIcon(new ImageIcon("src/Img/info.png"));
        jbSalir.setIcon(new ImageIcon("src/Img/salir.png"));
        jbRanking.setIcon(new ImageIcon("src/Img/ranking.png"));

        //seteo el fondo transparente
        JbJugar.setOpaque(false);
        JbRegistrarJugador.setOpaque(false);
        jbInfo.setOpaque(false);
        jbSalir.setOpaque(false);
        jbRanking.setOpaque(false);  
        
        JbJugar.setContentAreaFilled(false);        
        JbRegistrarJugador.setContentAreaFilled(false);  
        jbInfo.setContentAreaFilled(false);  
        jbSalir.setContentAreaFilled(false);  
        jbRanking.setContentAreaFilled(false);

        //Dejo los botones sin texto
        JbJugar.setText("");
        JbRegistrarJugador.setText("");
        jbInfo.setText("");
        jbSalir.setText("");
        jbRanking.setText("");
        
        JbJugar.setBorderPainted(false);
        JbRegistrarJugador.setBorderPainted(false);
        jbInfo.setBorderPainted(false);
        jbSalir.setBorderPainted(false);
        jbRanking.setBorderPainted(false);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbRegistrarJugador = new javax.swing.JButton();
        JbJugar = new javax.swing.JButton();
        jbRanking = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("STONES - Menú Principal");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setIconImages(getIconImages());
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));

        JbRegistrarJugador.setText("Registrar Jugador");
        JbRegistrarJugador.setMargin(new java.awt.Insets(0, 14, 0, 14));
        JbRegistrarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbRegistrarJugadorActionPerformed(evt);
            }
        });

        JbJugar.setBackground(new java.awt.Color(240, 255, 255));
        JbJugar.setText("Jugar");
        JbJugar.setMargin(new java.awt.Insets(0, 14, 0, 14));
        JbJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbJugarActionPerformed(evt);
            }
        });

        jbRanking.setText("Ranking de Jugadores");
        jbRanking.setMargin(new java.awt.Insets(0, 14, 0, 14));
        jbRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRankingActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbInfo.setText("Salir");
        jbInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbRanking, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(JbJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JbRegistrarJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(311, 311, 311))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(JbJugar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JbRegistrarJugador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jbRanking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir)
                    .addComponent(jbInfo))
                .addGap(178, 178, 178))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbRegistrarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbRegistrarJugadorActionPerformed
        //Apertura de la ventana registrar jugador

        CrearJugador vCrearJugador = new CrearJugador(Modelo);
        vCrearJugador.setSize(900, 600);
        vCrearJugador.setVisible(true);
        vCrearJugador.setTitle("ESQUINAS - Crear Jugador");
        dispose();

    }//GEN-LAST:event_JbRegistrarJugadorActionPerformed

    private void jbRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRankingActionPerformed
        //Apertura de la ventana ranking jugador
        Ranking vRanking = new Ranking(Modelo);
        vRanking.setSize(900, 600);
        vRanking.setVisible(true);
        vRanking.setTitle("ESQUINAS - Ranking");
        dispose();


    }//GEN-LAST:event_jbRankingActionPerformed

    private void JbJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbJugarActionPerformed
        //Apertura de la ventana Jugar Partida
        if (Modelo.getListaJugadores().size() >= 2) {
            SeleccionarJugadores vSeleccionarJugadores = new SeleccionarJugadores(this.Modelo);
            vSeleccionarJugadores.setSize(900, 600);
            vSeleccionarJugadores.setVisible(true);
            vSeleccionarJugadores.setTitle("ESQUINAS - Seleccionar Jugadores");
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario tener al menos 2 Jugadores");
        }

    }//GEN-LAST:event_JbJugarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        try {
            //Guardo el modelo Actual
            Persistencia.ArchSistema.guardar(Modelo);
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Cierro Aplicacion.
        System.exit(0);


    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbInfoActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbJugar;
    private javax.swing.JButton JbRegistrarJugador;
    private javax.swing.JButton jbInfo;
    private javax.swing.JButton jbRanking;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables
}
