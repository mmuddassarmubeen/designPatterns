/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserInterface.PharmaceuticalDrugRegulatorWorkArea;

import healthcare.Commons.DrugStatusType;
import healthcare.Department.PharmaceuticalDrugRegulatoryDepartment;
import healthcare.Drug.Drug;
import healthcare.Drug.DrugCatalog;
import healthcare.UserAccount.UserAccount;
import healthcare.WorkQueue.DrugAlertWorkRequest;
import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Muddassar
 */
public class BroadcastAlertsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private PharmaceuticalDrugRegulatoryDepartment drugRegulatoryDepartment;
    private UserAccount userAccount;
    /**
     * Creates new form BroadcastAlertsJPanel
     */
    public BroadcastAlertsJPanel(JPanel upc, PharmaceuticalDrugRegulatoryDepartment drugSupplierDepartment, UserAccount account) {
        initComponents();
        this.userProcessContainer = upc;
        this.drugRegulatoryDepartment = drugSupplierDepartment;
        this.userAccount = account;
        this.populateDrugs();
        this.populateDrugStatus();
    }
    
    private void populateDrugs()
    {
        cmbDrugs.removeAllItems();
        for(Drug drug : this.drugRegulatoryDepartment.getDrugCatalog().getDrugList())
        {
            cmbDrugs.addItem(drug);
        }
    }
    
    private void populateDrugStatus()
    {
        cmbDrugStatus.removeAllItems();
        for(DrugStatusType drugStatus : DrugStatusType.values())
        {
            cmbDrugStatus.addItem(drugStatus);
        }
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
        cmbDrugs = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlertMessage = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btnSendAlert = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbDrugStatus = new javax.swing.JComboBox();

        jLabel1.setText("Broadcast Drug Alerts");

        cmbDrugs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Drugs");

        txtAlertMessage.setColumns(20);
        txtAlertMessage.setRows(5);
        jScrollPane1.setViewportView(txtAlertMessage);

        jLabel3.setText("Alert Message");

        btnSendAlert.setText("Send Alert");
        btnSendAlert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendAlertActionPerformed(evt);
            }
        });

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setText("Drug Status");

        cmbDrugStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(41, 41, 41)
                                .addComponent(cmbDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(57, 57, 57)
                                .addComponent(cmbDrugStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addGap(28, 28, 28)
                        .addComponent(btnSendAlert)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbDrugStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSendAlert)
                    .addComponent(btnBack))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSendAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendAlertActionPerformed
        // TODO add your handling code here:
        if(txtAlertMessage.getText().isEmpty() || cmbDrugs.getSelectedIndex()<0)
        {
            JOptionPane.showMessageDialog(null,"Please input valid values");
            return;
        }
        Drug drug = (Drug)cmbDrugs.getSelectedItem();
        DrugAlertWorkRequest wr = new DrugAlertWorkRequest();
        wr.setSender(this.userAccount);
        wr.setDrug(drug);
        wr.setAlert(txtAlertMessage.getText());
        this.userAccount.getWorkQueue().getWorkRequestList().add(wr);
        if( this.drugRegulatoryDepartment.getDrugUpdateSubscriptions().size() > 0
                && this.drugRegulatoryDepartment.getDrugUpdateSubscriptions().containsKey(drug))
        {
            this.drugRegulatoryDepartment.getDrugUpdateSubscriptions().get(drug).getWorkQueue().getWorkRequestList().add(wr);
            Logger logger = Logger.getLogger(this.getClass().toString());
            logger.log(Level.INFO,String.format("All networks alerted for the drug with status:%s ", drug.getName(),drug.getDrugStatus()));
            JOptionPane.showMessageDialog(null,"All Networks have been Alerted about this drug!");
        }
    }//GEN-LAST:event_btnSendAlertActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSendAlert;
    private javax.swing.JComboBox cmbDrugStatus;
    private javax.swing.JComboBox cmbDrugs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAlertMessage;
    // End of variables declaration//GEN-END:variables
}