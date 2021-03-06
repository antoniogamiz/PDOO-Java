/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GUI;

import Controller.Controller;

import View.View;

import deepspace.CombatResult;
import deepspace.GameUniverseToUI;

import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * 
 *
 * @author antonio
 */
public class MainView extends javax.swing.JFrame implements View {
    
    //Para poder acceder a el desde todos los elementos de la vista
    static Controller controller; 
    
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        //Para que la aplicacion finalice cuando se cierre la interfaz
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e){ 
                controller.finish(0); 
            }
        });
        
        setTitle("DeepSpace 1.0");
        
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stationPanel = new javax.swing.JPanel();
        enemyPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        nextTurnButton = new javax.swing.JButton();
        combatButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        nextTurnButton.setText("Siguiente Turno");
        nextTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnButtonActionPerformed(evt);
            }
        });

        combatButton.setText("Combatir");
        combatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(stationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(enemyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nextTurnButton)
                                    .addComponent(jButton1))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enemyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(combatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextTurnButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(32, 32, 32))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nextTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnButtonActionPerformed
        // TODO add your handling code here:
        if( controller.nextTurn() )
            combatButton.setEnabled(true);
    }//GEN-LAST:event_nextTurnButtonActionPerformed

    private void combatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatButtonActionPerformed
        // TODO add your handling code here:
        if( controller.combat() != CombatResult.NOCOMBAT )
            combatButton.setEnabled(false);
    }//GEN-LAST:event_combatButtonActionPerformed

    
    //Metodos heredados de la interfaz
    @Override
    public void setController(Controller c){
        controller=c;
    }
    
    @Override
    public void updateView(){
        
        stationPanel.removeAll();
        
        GameUniverseToUI modelToUI = controller.getUIversion();
        SpaceStationView spaceView = new SpaceStationView();
        spaceView.setSpaceStationToUI(modelToUI.getCurrentStation());
        stationPanel.add( spaceView );
        
        enemyPanel.removeAll();
        EnemyView enemyView = new EnemyView();
        enemyView.setEnemyToUI(modelToUI.getCurrentEnemy());
        enemyPanel.add( enemyView );
        
        repaint();
        revalidate();
    }
    
    @Override
    public void showView(){ this.setVisible(true); }

    public ArrayList<String> getNames(){
        NamesCapture namesCaptureDialog = new NamesCapture(this);
        return namesCaptureDialog.getNames();
    }
    
    @Override
    public void showNextTurnError(){
        JOptionPane.showMessageDialog(
                this,
                "Debes combatir antes\nde pasar de turno.\n O cumplir tu castigo.",
                "No puedes pasar de turno",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    public void showEnemyWinsMessage(){
        JOptionPane.showMessageDialog(
                this,
                "Has perdido el combate!\nCumple tu castigo.",
                "Has perdido el combate!",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    public void showStationEscapesMessage(){
        JOptionPane.showMessageDialog(
                this,
                "Has escapado del combate!\nEres una gallinan espacial!.",
                "GALLINA!",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    @Override
    public void showYouWinMessage(){
        JOptionPane.showMessageDialog(
                this,
                "Has ganado el combate!\nDisfruta de tu botín",
                "Has ganado el combate!",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    @Override
    public void showYouWinAndConvertMessage(){
        JOptionPane.showMessageDialog(
                this,
                "Has ganado el combate!\nDisfruta de tu botín.\n Y además te has convertido!",
                "Has ganado el combate!",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    @Override
    public void showVictoryMessage(){
        JOptionPane.showMessageDialog(
                this,
                "Has ganado el juego!\nEnhorabuena!.",
                "¡VICTORIA!",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combatButton;
    private javax.swing.JPanel enemyPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton nextTurnButton;
    private javax.swing.JPanel stationPanel;
    // End of variables declaration//GEN-END:variables
}
