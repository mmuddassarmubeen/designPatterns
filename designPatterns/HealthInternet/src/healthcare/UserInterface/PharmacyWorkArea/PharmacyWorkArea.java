/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserInterface.PharmacyWorkArea;

import healthcare.Department.PharmacyDepartment;
import healthcare.Drug.DrugCatalog;
import healthcare.Network.Network;
import healthcare.Network.PharmaceuticalCompaniesNetwork;
import healthcare.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Muddassar
 */
public class PharmacyWorkArea extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private PharmacyDepartment pharmacyDepartment;
    private PharmaceuticalCompaniesNetwork drugCompanyNetwork;
    private UserAccount userAccount;
    /**
     * Creates new form PharmacyWorkArea
     */
    public PharmacyWorkArea(JPanel upc, UserAccount account, PharmacyDepartment dept, PharmaceuticalCompaniesNetwork drugCompanyNetwork) {
        initComponents();
        this.userProcessContainer = upc;
        this.pharmacyDepartment = dept;
        this.drugCompanyNetwork = drugCompanyNetwork;
        this.userAccount = account;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnManagePrescriptions = new javax.swing.JButton();
        btnManageDrugs = new javax.swing.JButton();
        btnDrugAlerts = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnManagePrescriptions.setText("Manage Prescriptions");
        btnManagePrescriptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagePrescriptionsActionPerformed(evt);
            }
        });
        add(btnManagePrescriptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 200, -1));

        btnManageDrugs.setText("Manage Drugs");
        btnManageDrugs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageDrugsActionPerformed(evt);
            }
        });
        add(btnManageDrugs, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 200, -1));

        btnDrugAlerts.setText("Drug Alerts");
        btnDrugAlerts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrugAlertsActionPerformed(evt);
            }
        });
        add(btnDrugAlerts, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 200, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnManagePrescriptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagePrescriptionsActionPerformed
        // TODO add your handling code here:
        ManagePatientPrescriptionsJPanel muajp = new ManagePatientPrescriptionsJPanel(this.userProcessContainer,this.pharmacyDepartment, this.userAccount);
        userProcessContainer.add("ManagePatientPrescriptionsJPanel", muajp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
	layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManagePrescriptionsActionPerformed

    private void btnManageDrugsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageDrugsActionPerformed
        // TODO add your handling code here:
        ManageDrugInventoryJPanel mdijp = new ManageDrugInventoryJPanel(userProcessContainer, this.drugCompanyNetwork, pharmacyDepartment);
        userProcessContainer.add("ManageDrugInventoryJPanel", mdijp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
	layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageDrugsActionPerformed

    private void btnDrugAlertsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrugAlertsActionPerformed
        // TODO add your handling code here:
        DrugAlertsJPanel mdijp = new DrugAlertsJPanel(userProcessContainer,this.pharmacyDepartment);
        userProcessContainer.add("DrugAlertsJPanel", mdijp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
	layout.next(userProcessContainer);
    }//GEN-LAST:event_btnDrugAlertsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDrugAlerts;
    private javax.swing.JButton btnManageDrugs;
    private javax.swing.JButton btnManagePrescriptions;
    // End of variables declaration//GEN-END:variables
}