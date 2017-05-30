package Interfaz;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Dominio.Jugador;
import Dominio.Sistema;
import java.awt.Image;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.*;

public class Ranking extends javax.swing.JFrame {

    private Sistema Modelo;
    private Image stonesIcon = (new ImageIcon("src/Img/stonesicon.png").getImage());    
    private ImageIcon background = new ImageIcon("src/Img/background-ranking.png");
    private ImageIcon atrasIco = new ImageIcon("src/Img/volver.png");
    private ImageIcon crearIco = new ImageIcon("src/Img/crear.png");
    
    public Ranking(Sistema elModelo) {

        Modelo = elModelo;

        //Primero seteo la imagen de fondo
        this.setContentPane(new JLabel(background));

        //Inicializo los componentes
        initComponents();
        setLocationRelativeTo(null);//Ventana Centrada        setLocationRelativeTo(null);//Ventana Centrada
        setResizable(false);//Impedir que se maximice
        setTitle("STONES - Crear Jugador");

        //Seteo imagen de icono
        this.setIconImage(stonesIcon);

        //Seteo imagenes de los botones
        jBAtras.setIcon(atrasIco);

        //seteo el fondo transparente
        jBAtras.setOpaque(false);
        jBAtras.setContentAreaFilled(false);
        jBAtras.setBorderPainted(false);

        //tooltips de ayuda
        jBAtras.setToolTipText("Presione aquí para volver al Menú Principal");
        jBAtras.setText("");
        this.cargarTablaRanking(Modelo.ordenarPorRanking());

        //Visibilidad de la grilla
        jScrollPane2.getViewport().setOpaque(false);
        jTRAnking.setBackground(new Color(213, 134, 145, 123));
        jScrollPane2.getViewport().setBackground(new Color(213, 134, 145, 123));
        jTRAnking.setOpaque(false);
        jScrollPane2.setOpaque(false);
        jScrollPane2.setForeground(new Color(255,255,255,255));
        jScrollPane2.getViewport().setForeground(new Color(255,255,255,255));
        
        //Centrado
        DefaultTableCellRenderer celdasCentradas = new DefaultTableCellRenderer();
        celdasCentradas.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        jTRAnking.getColumn("Posición").setCellRenderer( celdasCentradas );
        jTRAnking.getColumn("Alias").setCellRenderer( celdasCentradas );
        jTRAnking.getColumn("Ganadas").setCellRenderer( celdasCentradas );
        jTRAnking.getColumn("Perdidas").setCellRenderer( celdasCentradas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBAtras = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTRAnking = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setSize(new java.awt.Dimension(900, 600));

        jBAtras.setText("Atras");
        jBAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtrasActionPerformed(evt);
            }
        });

        jScrollPane2.setPreferredSize(new java.awt.Dimension(800, 402));

        jTRAnking.setForeground(new java.awt.Color(255, 255, 255));
        jTRAnking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTRAnking);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBAtras)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jBAtras)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("ESQUINAS - Ranking");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtrasActionPerformed
        MenuPrincipal vMenuPrinipal = new MenuPrincipal(this.Modelo);
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
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //        new Ranking().setVisible(true);
            }
        });
    }

    public void cargarTablaRanking(ArrayList<Jugador> unaListaJugadoresOrd) {
        String[] columnas = {"Posición", "Alias", "Ganadas", "Perdidas"};
        DefaultTableModel dtm = new DefaultTableModel(null, columnas);

        for (int i = 0; i < unaListaJugadoresOrd.size(); i++) {
            String[] fila = {"" + (i + 1), "" + unaListaJugadoresOrd.get(i).getAlias(), "" + unaListaJugadoresOrd.get(i).getPartidas()[0],
                "" + unaListaJugadoresOrd.get(i).getPartidas()[1]};

            dtm.addRow(fila);
        }

        jTRAnking.setModel(dtm);
        jTRAnking.setEnabled(false);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtras;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTRAnking;
    // End of variables declaration//GEN-END:variables
}
