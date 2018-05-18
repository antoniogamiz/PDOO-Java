/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GUI;

import deepspace.WeaponToUI;

/**
 *
 * @author antonio
 */
public class WeaponView extends javax.swing.JPanel {
        
    /**
     * Creates new form WeaponView
     */
    public WeaponView() {
        initComponents();
    }

    void setWeaponToUI(WeaponToUI weapon){
        typeField.setText(weapon.getType().toString());
        powerField.setText(Float.toString(weapon.getPower()));
        usesField.setText(Integer.toString(weapon.getUses()));
        repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        type = new javax.swing.JLabel();
        power = new javax.swing.JLabel();
        uses = new javax.swing.JLabel();
        typeField = new javax.swing.JLabel();
        powerField = new javax.swing.JLabel();
        usesField = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        type.setText("Tipo: ");
        type.setToolTipText("");

        power.setText("Potencia: ");

        uses.setText("Usos: ");

        typeField.setText("jLabel1");

        powerField.setText("jLabel1");

        usesField.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(type)
                    .addComponent(power)
                    .addComponent(uses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeField)
                    .addComponent(powerField)
                    .addComponent(usesField))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type)
                    .addComponent(typeField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(power)
                    .addComponent(powerField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uses)
                    .addComponent(usesField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel power;
    private javax.swing.JLabel powerField;
    private javax.swing.JLabel type;
    private javax.swing.JLabel typeField;
    private javax.swing.JLabel uses;
    private javax.swing.JLabel usesField;
    // End of variables declaration//GEN-END:variables


    
}
