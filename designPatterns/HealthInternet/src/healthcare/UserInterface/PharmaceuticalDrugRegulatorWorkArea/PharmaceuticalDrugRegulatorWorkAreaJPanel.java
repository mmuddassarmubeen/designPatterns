/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserInterface.PharmaceuticalDrugRegulatorWorkArea;

import healthcare.Department.PharmaceuticalDrugRegulatoryDepartment;
import healthcare.Enterprise.Enterprise;
import healthcare.Enterprise.PharmaceuticalEnterprise;
import healthcare.Network.PharmaceuticalCompaniesNetwork;
import healthcare.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Muddassar
 */
public class PharmaceuticalDrugRegulatorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private PharmaceuticalDrugRegulatoryDepartment drugRegulatoryDepartment;
    private UserAccount userAccount;
    private Enterprise pharmaEnterprise;
    /**
     * Creates new form FDADrugRegulatorWorkAreaJPanel
     */
    public PharmaceuticalDrugRegulatorWorkAreaJPanel(JPanel upc, PharmaceuticalDrugRegulatoryDepartment drugDepartment, UserAccount account, Enterprise drugEnterprise) {
        initComponents();
        this.userProcessContainer = upc;
        this.drugRegulatoryDepartment = drugDepartment;
        this.userAccount = account;
        this.pharmaEnterprise = drugEnterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBroadcastAlerts = new javax.swing.JButton();
        btnManageDrugs = new javax.swing.JButton();
        btnTrackReports = new javax.swing.JButton();

        btnBroadcastAlerts.setText("Broadcast Alerts");
        btnBroadcastAlerts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroadcastAlertsActionPerformed(evt);
            }
        });

        btnManageDrugs.setText("Manage Drugs");
        btnManageDrugs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageDrugsActionPerformed(evt);
            }
        });

        btnTrackReports.setText("Track Drug Reports");
        btnTrackReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTrackReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBroadcastAlerts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageDrugs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnManageDrugs)
                .addGap(29, 29, 29)
                .addComponent(btnBroadcastAlerts)
                .addGap(30, 30, 30)
                .addComponent(btnTrackReports)
                .addContainerGap(96, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageDrugsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageDrugsActionPerformed
        // TODO add your handling code here:
        ManageDrugsJPanel mdcjp = new ManageDrugsJPanel(userProcessContainer, this.drugRegulatoryDepartment, this.pharmaEnterprise.getName());
        userProcessContainer.add("ManageDrugsJPanel", mdcjp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageDrugsActionPerformed

    private void btnBroadcastAlertsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroadcastAlertsActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
        BroadcastAlertsJPanel mdcjp = new BroadcastAlertsJPanel(userProcessContainer,this.drugRegulatoryDepartment,this.userAccount);
        userProcessContainer.add("BroadcastAlertsJPanel", mdcjp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnBroadcastAlertsActionPerformed

    private void btnTrackReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackReportsActionPerformed
        // TODO add your handling code here:
        TrackDrugReportsJPanel mdcjp = new TrackDrugReportsJPanel(userProcessContainer,this.pharmaEnterprise);
        userProcessContainer.add("TrackDrugReportsJPanel", mdcjp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnTrackReportsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBroadcastAlerts;
    private javax.swing.JButton btnManageDrugs;
    private javax.swing.JButton btnTrackReports;
    // End of variables declaration//GEN-END:variables
}
