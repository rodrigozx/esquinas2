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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class TableroJuego extends javax.swing.JFrame {

    private Sistema modelo;
    private Partida partida;
    private Tablero tablero;
    private int turnoActual = 1;

    //Se cargan las imágenes
    private ImageIcon salirIco = new ImageIcon("src/Img/salir.png");
    private ImageIcon background = new ImageIcon("src/Img/background-partida.png");
    private ImageIcon atrasIco = new ImageIcon("src/Img/volver.png");
    private ImageIcon jugarIco = new ImageIcon("src/Img/jugar.png");
    
    //Timer para turno
    public Double timeLeft;
    private JButton[][] botones;

    public TableroJuego(Sistema elModelo, Double defaultTimeLeft) {
        
        //Timer para turno
        this.timeLeft = defaultTimeLeft;
        
        modelo = elModelo;

        //Primero seteo la imagen de fondo
        setContentPane(new JLabel(background));

        //Busco el Partida y Tablero del Sistem
        tablero = modelo.getPartida().getTablero();
        partida = modelo.getPartida();

        initComponents();
        this.setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);//Ventana Centrada

        //seteo el fondo transparente
        jBAbandonar.setOpaque(false);
        jBAbandonar.setContentAreaFilled(false);

        //Dejo los botones sin texto
        jBAbandonar.setText("");

        //Status y Nombres de Jugadores
        jLJugador1Status.setText(Integer.toString(tablero.getCantCubosJug1()));
        jLJugador2Status.setText(Integer.toString(tablero.getCantCubosJug2()));
        jLJugador1.setText(partida.getJugador1().getAlias());
        jLJugador2.setText(partida.getJugador2().getAlias());

        //Siempre empieza jugando el Jugador 1
        turnoActual = partida.getTurno();

        this.showTablero();

        //Seteo abandonar
        jBAbandonar.setIcon(salirIco);

        //Comienzo el timer
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();
        jLJuega = new javax.swing.JLabel();
        jLJugador1 = new javax.swing.JLabel();
        jLJugador2 = new javax.swing.JLabel();
        jBAbandonar = new javax.swing.JButton();
        jLJugador1Status = new javax.swing.JLabel();
        jLJugador2Status = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLCubosAd = new javax.swing.JList<>();
        jLTimer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));

        panelJuego.setMaximumSize(new java.awt.Dimension(380, 380));
        panelJuego.setMinimumSize(new java.awt.Dimension(380, 380));
        panelJuego.setPreferredSize(new java.awt.Dimension(380, 380));

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        jLJuega.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLJuega.setForeground(new java.awt.Color(153, 0, 51));
        jLJuega.setText("Turno de: ");

        jLJugador1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLJugador1.setForeground(new java.awt.Color(255, 255, 255));
        jLJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLJugador1.setText("Jugador 1");

        jLJugador2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLJugador2.setForeground(new java.awt.Color(255, 255, 255));
        jLJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLJugador2.setText(" Jugador 2");

        jBAbandonar.setText("Abandonar");
        jBAbandonar.setBorderPainted(false);
        jBAbandonar.setContentAreaFilled(false);
        jBAbandonar.setMaximumSize(new java.awt.Dimension(80, 30));
        jBAbandonar.setMinimumSize(new java.awt.Dimension(80, 30));
        jBAbandonar.setPreferredSize(new java.awt.Dimension(80, 30));
        jBAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbandonarActionPerformed(evt);
            }
        });

        jLJugador1Status.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLJugador1Status.setForeground(new java.awt.Color(255, 255, 255));
        jLJugador1Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLJugador1Status.setText("jLabel1");

        jLJugador2Status.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLJugador2Status.setForeground(new java.awt.Color(255, 255, 255));
        jLJugador2Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLJugador2Status.setText("jLabel2");

        jLCubosAd.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jScrollPane1.setViewportView(jLCubosAd);

        jLTimer.setBackground(new java.awt.Color(180, 180, 180));
        jLTimer.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLTimer.setForeground(new java.awt.Color(255, 255, 255));
        jLTimer.setText("00:00:00");

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cubos Adicionales");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLTimer)
                    .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBAbandonar, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(jLJugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLJugador2Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLJugador1Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLJuega, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLJuega, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLTimer)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLJugador1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLJugador1Status)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLJugador2Status)
                                        .addGap(96, 96, 96)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBAbandonar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbandonarActionPerformed
        this.abandonar();

    }//GEN-LAST:event_jBAbandonarActionPerformed

    private void abandonar() {
        // Acción del boton abandonar.
        if (JOptionPane.showConfirmDialog(null, "Desea Abandonar la Partida?",
                "Confirmar Abandono", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
        }

        //Abandona el Jugador 1 - gana el Jugador 2
        if (turnoActual == 1) {
            partida.setGanador(partida.getJugador2());

            //Abandona el Jugador 2 - gana el Jugador 1
        } else {
            partida.setGanador(partida.getJugador1());
        }

        //Guardamos el modelo para persistir el Ranking de los jugadores.
        try {
            //Guardo el modelo Actual
            Persistencia.ArchSistema.guardar(modelo);
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        MenuPrincipal vMenuPrinipal = new MenuPrincipal(modelo);
        vMenuPrinipal.setTitle("ESQUINAS - Menú Principal");
        vMenuPrinipal.setSize(900, 600);
        vMenuPrinipal.setVisible(true);
        dispose();
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
    private javax.swing.JButton jBAbandonar;
    private javax.swing.JList<String> jLCubosAd;
    private javax.swing.JLabel jLJuega;
    private javax.swing.JLabel jLJugador1;
    private javax.swing.JLabel jLJugador1Status;
    private javax.swing.JLabel jLJugador2;
    private javax.swing.JLabel jLJugador2Status;
    private javax.swing.JLabel jLTimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables

    private void showTablero() {

        // crear botones y agregarlos al panel
        panelJuego.removeAll();
        panelJuego.setLayout(new GridLayout(7, 7));

        botones = new JButton[7][7];
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[0].length; j++) {
                JButton jButton = new JButton();
                if (j == 0 && i == 0) {
                    jButton.setOpaque(false);
                    jButton.setContentAreaFilled(false);
                }

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
                    int valorCelda = tablero.getMatrizTablero()[i][j];
                    renderContenidoBoton(jButton, valorCelda);
                }
                botones[i][j] = jButton;
                botones[i][j].setMargin(new Insets(-5, -5, -5, -5));
            }
        }
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

            // cuando se presiona un botón, se ejecutará este método
            clickBotonMatriz(x, y);
        }
    }

    //Llenar el JCbox con La lista de jugadores
    DefaultListModel dlmCuboAd = new DefaultListModel();

    public void getCubosAd(String[] lista) {

        jLCubosAd.removeAll();
        dlmCuboAd.clear();
        String fila = "";
        String columna = "";

        for (int i = 1; i < lista.length; i++) {
            fila = lista[i].substring(0, 1);
            columna = lista[i].substring(1, 2);
            fila = numLetra(Integer.parseInt(fila));
            dlmCuboAd.addElement(fila + " " + columna);
        }
        jLCubosAd.setModel(dlmCuboAd);
    }

    private void clickBotonMatriz(int fila, int columna) {

        String retorno = "";
        String primerValor = "";
        String[] listaRetorno;

        //Si es una casilla Libre del casillero
        if (tablero.getMatrizTablero()[fila][columna] == 0) {

            //Coloco el cubo en el lugar seleccionado
            retorno = tablero.colocarCubo(fila, columna, turnoActual);
            listaRetorno = retorno.split("#");
            primerValor = listaRetorno[0];

            //Borro lista de cubos adicionales
            jLCubosAd.removeAll();
            dlmCuboAd.clear();

            switch (primerValor) {

                case "OK":

                    //Creo y muestro la lista de cubos adicionales.
                    listaRetorno = retorno.split("#");
                    getCubosAd(listaRetorno);

                    //Resto los cubos del jugador
                    partida.restaCubos(listaRetorno.length, true);
                    break;

                case "FIN":
                    //Si la jugada esta ok, entonces debo revisar si existe ganador
                    JOptionPane.showMessageDialog(null, "Ganador: " + partida.terminoPartida());
                    break;

                default:
                    JOptionPane.showMessageDialog(null, retorno, "Jugada Incorrecta!", JOptionPane.WARNING_MESSAGE);
            }
        }
        actualizarPanelJuego(primerValor);
        this.showTablero();
    }

    private void renderContenidoBoton(JButton boton, int valor) {

        //Si tiene cubos ingresados
        if (valor > 0) {

            //Jugador 1 (rojo)
            if (valor < 20) {
                //cantidad
                valor = valor % 10;
                switch (valor) {
                    case 1:
                        boton.setBackground(new Color(255, 90, 90));
                        break;
                    case 2:
                        boton.setBackground(new Color(240, 60, 60));
                        break;
                    case 3:
                        boton.setBackground(new Color(200, 35, 35));
                        break;
                    case 4:
                        boton.setBackground(new Color(160, 20, 10));
                        break;
                    case 5:
                        boton.setBackground(new Color(110, 0, 0));
                        break;
                    default:
                        boton.setBackground(new Color(255, 0, 0));
                }
                boton.setText(Integer.toString(valor % 10));

                //Jugador 2 (azul)
            } else {
                //cantidad
                valor = valor % 10;

                switch (valor) {
                    case 1:
                        boton.setBackground(new Color(90, 160, 240));
                        break;
                    case 2:
                        boton.setBackground(new Color(50, 110, 240));
                        break;
                    case 3:
                        boton.setBackground(new Color(30, 70, 230));
                        break;
                    case 4:
                        boton.setBackground(new Color(20, 40, 210));
                        break;
                    case 5:
                        boton.setBackground(new Color(0, 0, 180));
                        break;
                    default:
                        boton.setBackground(new Color(0, 0, 255));
                }
                boton.setText(Integer.toString(valor % 10));
            }

            //Si no tiene cubos, entonces está vacío
        } else {
            boton.setText("");
        }
        boton.setForeground(Color.yellow);
    }

    private void actualizarPanelJuego(String retorno) {

        //Actualizo cantidad de cubos por jugadores
        jLJugador1Status.setText(Integer.toString(tablero.getCantCubosJug1()));
        jLJugador2Status.setText(Integer.toString(tablero.getCantCubosJug2()));

        //Si no hay Ganador.
        if (partida.terminoPartida() == 0 && (retorno.toUpperCase().equals("OK"))) {

            partida.cambioTurno();

            //Busco el Alias del jugador de turno y lo muestro en el panel
            jLJuega.setText(partida.getJugadorDeTurno().getAlias());

            //Siempre empieza jugando el Jugador 1
            turnoActual = partida.getTurno();
        } else {
            if (retorno.toUpperCase().equals("FIN")) {
                JOptionPane.showMessageDialog(null, "Ganador: " + partida.terminoPartida());
                MenuPrincipal vMenuPrinipal = new MenuPrincipal(modelo);
                vMenuPrinipal.setTitle("ESQUINAS - Menú Principal");
                vMenuPrinipal.setSize(900, 600);
                vMenuPrinipal.setVisible(true);
                dispose();
            }
        }
    }

    ActionListener countDown = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            timeLeft -= 100;
            SimpleDateFormat df = new SimpleDateFormat("mm:ss:S");
            jLTimer.setText(df.format(timeLeft));
            if (timeLeft <= 0) {
                timer.stop();
            }
        }
    };
    Timer timer = new Timer(100, countDown);

//    //Timer para turno
//    Timer timer = new Timer(1000, new TimerListener());
//
//    class TimerListener implements ActionListener{
//        int elapsedSeconds = 30;
//
//        public void actionPerformed(ActionEvent evt){
//            elapsedSeconds--;
//            jLTimer.setText(elapsedSeconds);
//            if(elapsedSeconds <= 0){
//                timer.stop();
//                wrong()
//                // fill'er up here...
//            }
//        }
//
//    }    
}
