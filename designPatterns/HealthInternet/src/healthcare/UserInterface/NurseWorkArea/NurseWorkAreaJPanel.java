/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserInterface.NurseWorkArea;

import healthcare.Department.DoctorDepartment;
import healthcare.Department.PatientDepartment;
import healthcare.Department.SocialGroup;
import healthcare.Enterprise.Enterprise;
import healthcare.Network.SocialNetwork;
import healthcare.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Muddassar
 */
public class NurseWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private PatientDepartment patientDepartment;
    private DoctorDepartment doctorDepartment;
    private Enterprise enterprise;
    
     
    /**
     * Creates new form NurseWorkArea
     */
    public NurseWorkAreaJPanel(JPanel upc,UserAccount account, PatientDepartment patDept,DoctorDepartment docDept, Enterprise enterprise) {
        initComponents();
        this.userAccount = account;
        this.patientDepartment = patDept;
        this.doctorDepartment = docDept;
        this.userProcessContainer = upc;
        this.enterprise = enterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdmit = new javax.swing.JButton();
        btnPatientProfileRequests = new javax.swing.JButton();
        btnPatientHistoryRequest = new javax.swing.JButton();

        btnAdmit.setText("Admit Patient");
        btnAdmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmitActionPerformed(evt);
            }
        });

        btnPatientProfileRequests.setText("Patient Profile Request(Hospital)");
        btnPatientProfileRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientProfileRequestsActionPerformed(evt);
            }
        });

        btnPatientHistoryRequest.setText("Patient History Request(Social)");
        btnPatientHistoryRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientHistoryRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPatientProfileRequests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPatientHistoryRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnAdmit)
                .addGap(35, 35, 35)
                .addComponent(btnPatientProfileRequests)
                .addGap(32, 32, 32)
                .addComponent(btnPatientHistoryRequest)
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmitActionPerformed
        // TODO add your handling code here:
        AdmitPatientJPanel apjp = new AdmitPatientJPanel(userProcessContainer,userAccount, this.patientDepartment, this.doctorDepartment);
        userProcessContainer.add("AdmitPatientJPanel", apjp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnAdmitActionPerformed

    private void btnPatientProfileRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientProfileRequestsActionPerformed
        // TODO add your handling code here:
        PatientProfileRequestsJPanel pprjp = new PatientProfileRequestsJPanel(userProcessContainer,this.enterprise);
        userProcessContainer.add("PatientProfileRequestsJPanel", pprjp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnPatientProfileRequestsActionPerformed

    private void btnPatientHistoryRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientHistoryRequestActionPerformed
        // TODO add your handling code here:
        PatientHistoryRequestsJPanel pprjp = new PatientHistoryRequestsJPanel(userProcessContainer,this.enterprise);
        userProcessContainer.add("PatientHistoryRequestsJPanel", pprjp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnPatientHistoryRequestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmit;
    private javax.swing.JButton btnPatientHistoryRequest;
    private javax.swing.JButton btnPatientProfileRequests;
    // End of variables declaration//GEN-END:variables
}
