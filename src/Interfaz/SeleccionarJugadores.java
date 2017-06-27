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
import java.util.ArrayList;
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
    private Double timeLeft;
    
    public SeleccionarJugadores(Dominio.Sistema elModelo) {
        Modelo = elModelo;

        //Primero seteo la imagen de fondo
        this.setContentPane(new JLabel(background));

        initComponents();
        setLocationRelativeTo(null);//Ventana Centrada
        setResizable(false);//Impedir que se maximice
        setTitle("ESQUINAS - Seleccinar Jugadores");

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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListJugadoresSeleccionados = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListListaJugadores = new javax.swing.JList();
        jButQuitar = new javax.swing.JButton();
        jButAgregar = new javax.swing.JButton();
        jButJugar = new javax.swing.JButton();
        jBAtras = new javax.swing.JButton();
        jSTime = new javax.swing.JSlider();
        jLTime = new javax.swing.JLabel();
        jCBvsCPU = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
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

        jSTime.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jSTime.setMaximum(60);
        jSTime.setMinimum(10);
        jSTime.setValue(30);
        jSTime.setMaximumSize(new java.awt.Dimension(200, 16));
        jSTime.setMinimumSize(new java.awt.Dimension(200, 16));
        jSTime.setPreferredSize(new java.awt.Dimension(200, 20));
        jSTime.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSTimeStateChanged(evt);
            }
        });

        jLTime.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLTime.setForeground(new java.awt.Color(180, 180, 180));
        jLTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTime.setText("Segundos por turno: 30");
        jLTime.setAlignmentX(0.5F);

        jCBvsCPU.setBackground(new java.awt.Color(0, 0, 0));
        jCBvsCPU.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jCBvsCPU.setForeground(new java.awt.Color(255, 255, 255));
        jCBvsCPU.setText("Vs. CPU");
        jCBvsCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBvsCPUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jBAtras)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jCBvsCPU)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jButQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(54, 54, 54)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                                .addComponent(jSTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jCBvsCPU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jLTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSTime, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAtras))
                .addContainerGap(21, Short.MAX_VALUE))
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

    private Jugador jugadorEnLista(String alias){
                
        ArrayList <Jugador> lista = new ArrayList();
        lista = Modelo.getListaJugadores();
        boolean encontrado = false;
        Jugador elJugador = null;
        
        for (int i = 0; i < lista.size() && !encontrado; i++) {
            if (lista.get(i).getAlias().equals(alias)){
                elJugador = lista.get(i);
                encontrado = true;
            }
        }
        return elJugador;
    }
    
    private void jButJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButJugarActionPerformed
        
        //Accion al presionar el boton Jugar
        //Busco el jugador 1 en la lista original
        Jugador player1 = jugadorEnLista(dlmSeleccionar.get(0).toString());
        Jugador player2;
        
        if(jCBvsCPU.isSelected()){
            Jugador cpu = new Jugador();
            cpu.setAlias("CPU");
            cpu.setNombre("CPU");
            player2 = cpu;
        }else{
            //Busco el jugador 2 en la lista original
            player2 = jugadorEnLista(dlmSeleccionar.get(1).toString());            
        }
        Partida laPartida = new Partida( player1, player2, 1,jCBvsCPU.isSelected() , 25);
        Modelo.setPartida(laPartida);

        TableroJuego vTablero = new TableroJuego(Modelo, timeLeft);
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

    private void jSTimeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSTimeStateChanged
        timeLeft = (jSTime.getValue()*0.1);
        this.jLTime.setText("Segundos por turno: " + jSTime.getValue());
    }//GEN-LAST:event_jSTimeStateChanged

    private void jCBvsCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBvsCPUActionPerformed
        habilitarJugar();
    }//GEN-LAST:event_jCBvsCPUActionPerformed

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
        if (((dlmSeleccionar.getSize() == 2) && (!jCBvsCPU.isSelected())) || ((dlmSeleccionar.getSize()==1) && jCBvsCPU.isSelected())) {
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
    private javax.swing.JCheckBox jCBvsCPU;
    private javax.swing.JLabel jLTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jListJugadoresSeleccionados;
    private javax.swing.JList jListListaJugadores;
    private javax.swing.JSlider jSTime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}