/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GUI;

import deepspace.GameState;

import deepspace.SpaceStationToUI;
import deepspace.WeaponToUI;
import deepspace.ShieldToUI;

import java.util.ArrayList;
import java.awt.Component;

/**
 *
 * @author antonio
 */
public class SpaceStationView extends javax.swing.JPanel {

    private HangarView currentHangarView;
    
    /**
     * Creates new form SpaceStationView
     */
    public SpaceStationView() {
        initComponents();
    }

    void setSpaceStationToUI(SpaceStationToUI s){
        
        weaponsPanel.removeAll();
        shieldsPanel.removeAll();
        hangarPanel.removeAll();
        
        if( MainView.controller.getState() == GameState.INIT || MainView.controller.getState() == GameState.AFTERCOMBAT ){
            EquipButton.setEnabled(true);
            discardButton.setEnabled(true);
            discardHangarButton.setEnabled(true);
        }
        else{
            EquipButton.setEnabled(false);
            discardButton.setEnabled(false);
            discardHangarButton.setEnabled(false);
            
        }
        
        stationName.setText( s.getName() );
        ammoPowerLabel.setText( Float.toString( s.getAmmoPower() ) );
        shieldPowerLabel.setText( Float.toString( s.getShieldPower() ) );
        fuelUnitsLabel.setText( Float.toString( s.getFuelUnits() ) );
        medalsLabel.setText( Integer.toString( s.getnMedals() ) );
        
        ArrayList<WeaponToUI> weapons = s.getWeapons();
        WeaponView wView;
        for( WeaponToUI weapon : weapons ){
            wView = new WeaponView();
            wView.setWeaponToUI(weapon);
            weaponsPanel.add( wView ); 
        }


        ArrayList<ShieldToUI> shields = s.getShieldBoosters();
        ShieldBoosterView sView;
        for( ShieldToUI shield : shields ){
            sView = new ShieldBoosterView();
            sView.setShieldToUI(shield);
            shieldsPanel.add( sView ); 
        }
        
        currentHangarView = new HangarView();
        if( s.getHangar() == null )
            currentHangarView.setHangarToUI(null);
        else
            currentHangarView.setHangarToUI( s.getHangar() );
        
        hangarPanel.add(currentHangarView);

        String hangarTitle = (s.getHangar() != null) ? "Hangar con "+ Integer.toString( s.getHangar().getMaxElements() ) + " lugares": "No dispone de hangar";
        hangarPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), hangarTitle));

        
        repaint();
        revalidate();
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ammoPowerLabel = new javax.swing.JLabel();
        shieldPowerLabel = new javax.swing.JLabel();
        fuelUnitsLabel = new javax.swing.JLabel();
        medalsLabel = new javax.swing.JLabel();
        stationName = new javax.swing.JLabel();
        EquipButton = new javax.swing.JButton();
        discardButton = new javax.swing.JButton();
        discardHangarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        weaponsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        shieldsPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        hangarPanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(525, 550));

        jLabel1.setText("Potencia de Ataque: ");

        jLabel2.setText("Potencia de Defensa: ");

        jLabel3.setText("Nivel de Combustible: ");

        jLabel4.setText("Medallas: ");

        ammoPowerLabel.setText("jLabel5");

        shieldPowerLabel.setText("jLabel5");

        fuelUnitsLabel.setText("jLabel5");

        medalsLabel.setText("jLabel5");

        stationName.setText("jLabel5");

        EquipButton.setText("Equipar");
        EquipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EquipButtonActionPerformed(evt);
            }
        });

        discardButton.setText("Descartar");
        discardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardButtonActionPerformed(evt);
            }
        });

        discardHangarButton.setText("Descartar Hangar completo");
        discardHangarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardHangarButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Potenciadores de Fuego"));
        jScrollPane1.setViewportView(weaponsPanel);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Potenciadores de Defensa"));
        jScrollPane2.setViewportView(shieldsPanel);

        jScrollPane3.setViewportView(hangarPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(ammoPowerLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(shieldPowerLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(medalsLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(fuelUnitsLabel)))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(stationName))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(EquipButton)
                        .addGap(18, 18, 18)
                        .addComponent(discardButton)
                        .addGap(18, 18, 18)
                        .addComponent(discardHangarButton)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stationName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(ammoPowerLabel)
                    .addComponent(fuelUnitsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(shieldPowerLabel)
                    .addComponent(medalsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EquipButton)
                    .addComponent(discardButton)
                    .addComponent(discardHangarButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EquipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EquipButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<Integer> selectedWeapon = currentHangarView.getSelectedWeapons();        
        for( int i=selectedWeapon.size()-1; i>=0; i-- ){
            MainView.controller.mountWeaponFromHangar( selectedWeapon.get(i));
        }
        
        ArrayList<Integer> selectedShield = currentHangarView.getSelectedShields();
        for( int i=selectedShield.size()-1; i>=0; i-- ){
            MainView.controller.mountShieldBoosterFromHangar( selectedShield.get(i) - selectedWeapon.size());
        }
        System.out.println(MainView.controller.getState());
    }//GEN-LAST:event_EquipButtonActionPerformed

    private void discardHangarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardHangarButtonActionPerformed
        // TODO add your handling code here:
        MainView.controller.discardHangar();
    }//GEN-LAST:event_discardHangarButtonActionPerformed

    private void discardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardButtonActionPerformed
        // TODO add your handling code here:
        int aux;
        
        ArrayList<Integer> selected = currentHangarView.getSelectedWeapons();        
        for( int i=selected.size()-1; i>=0; i-- ){
            MainView.controller.discardWeaponFromHangar( selected.get(i) );
        }
        aux=selected.size();
        
        selected = currentHangarView.getSelectedShields();
        for( int i=selected.size()-1; i>=0; i-- ){
            MainView.controller.discardShieldBoosterFromHangar( selected.get(i) - aux );
        }
        
        selected = getSelectedWeapons();
        for( int i=selected.size()-1; i>=0; i-- ){
            MainView.controller.discardWeapon( selected.get(i) );
        }
        
        selected = getSelectedShields();
        for( int i=selected.size()-1; i>=0; i-- ){
            MainView.controller.discardShieldBooster( selected.get(i) );
        }

        
    }//GEN-LAST:event_discardButtonActionPerformed


    ArrayList<Integer> getSelectedWeapons () {
        ArrayList<Integer> selectedWeapons = new ArrayList();
        int i = 0;
        for (Component c : weaponsPanel.getComponents()) {
            if (((WeaponView) c).isSelected()) {
                selectedWeapons.add(i);
            }
            i++;
        }
        return selectedWeapons;
    }

    ArrayList<Integer> getSelectedShields () {
        ArrayList<Integer> selectedShields = new ArrayList();
        int i = 0;
        for (Component c : shieldsPanel.getComponents()) {
            if (((ShieldBoosterView) c).isSelected()) {
                selectedShields.add(i);
            }
            i++;
        }
        return selectedShields;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EquipButton;
    private javax.swing.JLabel ammoPowerLabel;
    private javax.swing.JButton discardButton;
    private javax.swing.JButton discardHangarButton;
    private javax.swing.JLabel fuelUnitsLabel;
    private javax.swing.JPanel hangarPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel medalsLabel;
    private javax.swing.JLabel shieldPowerLabel;
    private javax.swing.JPanel shieldsPanel;
    private javax.swing.JLabel stationName;
    private javax.swing.JPanel weaponsPanel;
    // End of variables declaration//GEN-END:variables
}
