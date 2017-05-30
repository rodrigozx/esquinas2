package Interfaz;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import Dominio.Jugador;
import Dominio.Sistema;
import Excepciones.*;
import Persistencia.*;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Rodrigo
 */
public class CrearJugador extends javax.swing.JFrame {

    private Sistema Modelo;
    private String alias = "";
    private String nombre = "";
    private int edad = 0;
    private int largoAliasNombrePermitido = 15; //para restringir el largo de nombre y alias en pantalla
    private Image stonesIcon = (new ImageIcon("src/Img/stonesicon.png").getImage());
    private ImageIcon background = new ImageIcon("src/Img/background-crearJugador.png");
    private ImageIcon atrasIco = new ImageIcon("src/Img/volver.png");
    private ImageIcon crearIco = new ImageIcon("src/Img/crear.png");

    /**
     *
     * @param elModelo
     */
    public CrearJugador(Sistema elModelo) {

        Modelo = elModelo;

        //Primero seteo la imagen de fondo
        this.setContentPane(new JLabel(background));

        //Inicializo los componentes
        initComponents();
        setLocationRelativeTo(null);//Ventana Centrada
        setResizable(false);//Impedir que se maximice
        setTitle("STONES - Crear Jugador");

        //Seteo imagen de icono
        this.setIconImage(stonesIcon);


        //Seteo imagenes de los botones
        jbCrear.setIcon(crearIco);
        jbAtras.setIcon(atrasIco);

        //seteo el fondo transparente
        jbCrear.setOpaque(false);
        jbAtras.setOpaque(false);
        jTextFAlias.setOpaque(false);
        jTextFNombre.setOpaque(false);
        
        jbCrear.setContentAreaFilled(false);
        jbAtras.setContentAreaFilled(false);


        jbCrear.setBorderPainted(false);
        jbAtras.setBorderPainted(false);


        //tooltips de ayuda
        jbCrear.setToolTipText("Presione aquí para crear el jugador");
        jbAtras.setToolTipText("Presione aquí para volver al Menú Principal");

        //Sin texto
        jbCrear.setText("");
        jbAtras.setText("");
        jTextFAlias.setText(null);
        jTextFNombre.setText(null);
        
        jTextFAlias.setBorder(null);
        jTextFNombre.setBorder(null);
        
        this.getListaEdades();
        jbCrear.setEnabled(true);        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFAlias = new javax.swing.JTextField();
        jTextFNombre = new javax.swing.JTextField();
        jComBEdad = new javax.swing.JComboBox();
        jbCrear = new javax.swing.JButton();
        jbAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("STOES - Crear Jugador");
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));

        jTextFAlias.setBackground(new java.awt.Color(0, 102, 0));
        jTextFAlias.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jTextFAlias.setForeground(new java.awt.Color(255, 255, 255));
        jTextFAlias.setText("Ingrese un ALIAS");
        jTextFAlias.setToolTipText("Ingrese un ALIAS");
        jTextFAlias.setMaximumSize(new java.awt.Dimension(250, 42));
        jTextFAlias.setMinimumSize(new java.awt.Dimension(250, 42));
        jTextFAlias.setPreferredSize(new java.awt.Dimension(250, 42));
        jTextFAlias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFAliasFocusLost(evt);
            }
        });
        jTextFAlias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFAliasActionPerformed(evt);
            }
        });
        jTextFAlias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFAliasKeyTyped(evt);
            }
        });

        jTextFNombre.setBackground(new java.awt.Color(0, 102, 0));
        jTextFNombre.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jTextFNombre.setForeground(new java.awt.Color(255, 255, 255));
        jTextFNombre.setText("Ingrese un NOMBRE");
        jTextFNombre.setToolTipText("Ingrese un NOMBRE");
        jTextFNombre.setMaximumSize(new java.awt.Dimension(250, 42));
        jTextFNombre.setMinimumSize(new java.awt.Dimension(250, 42));
        jTextFNombre.setPreferredSize(new java.awt.Dimension(250, 42));
        jTextFNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFNombreFocusLost(evt);
            }
        });
        jTextFNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFNombreKeyTyped(evt);
            }
        });

        jComBEdad.setBackground(new java.awt.Color(171, 186, 185));
        jComBEdad.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jComBEdad.setForeground(new java.awt.Color(255, 255, 255));
        jComBEdad.setToolTipText("Seleccione una Edad");
        jComBEdad.setMaximumSize(new java.awt.Dimension(200, 42));
        jComBEdad.setMinimumSize(new java.awt.Dimension(200, 42));
        jComBEdad.setPreferredSize(new java.awt.Dimension(200, 42));
        jComBEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComBEdadActionPerformed(evt);
            }
        });

        jbCrear.setText("Crear");
        jbCrear.setMaximumSize(new java.awt.Dimension(200, 50));
        jbCrear.setPreferredSize(new java.awt.Dimension(200, 42));
        jbCrear.setSelected(true);
        jbCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearActionPerformed(evt);
            }
        });

        jbAtras.setText("Atras");
        jbAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jComBEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jbCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(130, 130, 130)))
                .addComponent(jbAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jTextFAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jTextFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jComBEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearActionPerformed

        //Intenta crear el jugador nuevo
        try {

            if (this.aliasOK(jTextFAlias.getText()) && this.nombreOK(jTextFNombre.getText())) {
                Jugador unJugador = new Jugador(alias, nombre, edad);
                Modelo.agregarJugador(unJugador);
                JOptionPane.showMessageDialog(null, unJugador);
                jTextFAlias.setText(null);
                jTextFNombre.setText(null);
                jComBEdad.setSelectedIndex(0);

                //Intenta guardar en el modelo
                try {
                    Persistencia.ArchSistema.guardar(Modelo);
                } catch (IOException ex) {
                    Logger.getLogger(CrearJugador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jbCrearActionPerformed

    private void jbAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtrasActionPerformed
        MenuPrincipal vMenuPrinipal = new MenuPrincipal(Modelo);
        vMenuPrinipal.setSize(this.getSize());
        vMenuPrinipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_jbAtrasActionPerformed

    //Selecciono la edad
    private void jComBEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComBEdadActionPerformed
        edad = (int) jComBEdad.getSelectedItem();
    }//GEN-LAST:event_jComBEdadActionPerformed

    private void jTextFNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFNombreFocusLost

    }//GEN-LAST:event_jTextFNombreFocusLost

    private void jTextFAliasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFAliasKeyTyped

     //para que no ingresen más de 15 caracteres
     if(jTextFAlias.getText().length()>=largoAliasNombrePermitido) {  
       jTextFAlias.setText(jTextFAlias.getText().substring(0, largoAliasNombrePermitido));
     }
        
    }//GEN-LAST:event_jTextFAliasKeyTyped

    private void jTextFAliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFAliasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFAliasActionPerformed

    private void jTextFAliasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFAliasFocusLost

    }//GEN-LAST:event_jTextFAliasFocusLost

    private void jTextFNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFNombreKeyTyped
     //para que no ingresen más de 15 caracteres
     if(jTextFNombre.getText().length()>= largoAliasNombrePermitido) {  
       jTextFNombre.setText(jTextFNombre.getText().substring(0, largoAliasNombrePermitido));
     }
    }//GEN-LAST:event_jTextFNombreKeyTyped


    private boolean aliasOK(String unAlias) {
        boolean retorno; //false
        String texto = unAlias;
        texto = texto.replaceAll("\\s+", "");

        if (texto.length() == 0) {
            JOptionPane.showMessageDialog(null, "Campo Alias Vacío");
            retorno = false;
        } else {
            if (this.existeAlias(texto)) {
                JOptionPane.showMessageDialog(null, "Ya existe un Jugador\n"
                        + "con el alias: " + texto);
                retorno = false;
            } else {
                alias = texto;
                retorno = true;
            }

        }

        return retorno;
    }

    private boolean nombreOK(String unNombre) {
        boolean retorno; //false
        String texto = unNombre;
        texto = texto.replaceAll("\\s+", "");

        if (texto.length() == 0) {
            JOptionPane.showMessageDialog(null, "Campo Nombre Vacío");
            retorno = false;
        } else {

            nombre = texto;
            retorno = true;
        }

        return retorno;
    }



    private boolean existeAlias(String unAlias) {
        boolean retorno = false;
        Jugador unJugador = new Jugador(unAlias, "temp", 0);

        if (Modelo.getListaJugadores().contains(unJugador)) {
            retorno = true;
        }
        return retorno;
    }

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
            java.util.logging.Logger.getLogger(CrearJugador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearJugador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearJugador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearJugador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //      new CrearJugador().setVisible(true);
            }
        });
    }

    /**
     *
     */
    public void getListaEdades() {
        int listaEdades[] = new int[95];
        int edadMinima = 5;
        for (int i = 0; i < listaEdades.length; i++) {
            jComBEdad.addItem(i + edadMinima);
        }
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComBEdad;
    private javax.swing.JTextField jTextFAlias;
    private javax.swing.JTextField jTextFNombre;
    private javax.swing.JButton jbAtras;
    private javax.swing.JButton jbCrear;
    // End of variables declaration//GEN-END:variables

}
