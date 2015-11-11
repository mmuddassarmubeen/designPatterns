/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserInterface.LabAssistantWorkArea;

import healthcare.Patient.Patient;
import healthcare.UserAccount.UserAccount;
import healthcare.WorkQueue.LabTestWorkRequest;
import healthcare.WorkQueue.MedicationWorkRequest;
import healthcare.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muddassar
 */
public class ManageMyTestsJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    /**
     * Creates new form ManageMyTestsJPanel
     */
    public ManageMyTestsJPanel(JPanel upc, UserAccount account) {
        initComponents();
        this.userProcessContainer = upc;
        this.userAccount = account;
        this.populateTable();
        
    }
    
    private void populateTable()
    {
        DefaultTableModel model = (DefaultTableModel) tblAllTests.getModel();
        model.setRowCount(0);
        for(WorkRequest request : this.userAccount.getWorkQueue().getWorkRequestList())
        {
            if(request instanceof MedicationWorkRequest)
            {
                Object[] row = new Object[4];
                Patient patient = ((MedicationWorkRequest)request).getPatient();
                row[0] = request; 
                row[1] = patient;
                row[2] = request.getSender();
                row[3] = request.getReceiver() == null ? null : request.getReceiver() ;
                model.addRow(row);
            }
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAllTests = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnUpdateTestResults = new javax.swing.JButton();

        tblAllTests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Patient", "Req Doctor", "Perf Lab Tech"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAllTests);

        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnUpdateTestResults.setText("Update Test Results");
        btnUpdateTestResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTestResultsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdateTestResults)
                        .addGap(86, 86, 86))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnUpdateTestResults))
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateTestResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTestResultsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblAllTests.getSelectedRow();
        if(selectedRow < 0)
        {
	    JOptionPane.showMessageDialog(null,"Please select a row");
            return;
        }
        MedicationWorkRequest workRequest = (MedicationWorkRequest)tblAllTests.getValueAt(selectedRow, 0);
        UpdateTestResultsJPanel utrjp = new UpdateTestResultsJPanel(userProcessContainer,workRequest);
        userProcessContainer.add("UpdateTestResultsJPanel", utrjp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnUpdateTestResultsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateTestResults;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAllTests;
    // End of variables declaration//GEN-END:variables
}