/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserInterface.DoctorWorkArea;

import healthcare.Commons.WorkRequestStatusType;
import static healthcare.Department.DepartmentType.Patient;
import healthcare.Department.DoctorDepartment;
import healthcare.Department.LabDepartment;
import healthcare.Patient.Patient;
import healthcare.Patient.PatientStatus;
import healthcare.UserAccount.UserAccount;
import healthcare.WorkQueue.AdmitPatientWorkRequest;
import healthcare.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muddassar
 */
public class ManageAllAdmittedPatientsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private DoctorDepartment doctorDepartment;
    
    /**
     * Creates new form ManagePatientJPanel
     */
    public ManageAllAdmittedPatientsJPanel(JPanel upc, UserAccount account, DoctorDepartment docDep) {
        initComponents();
        this.userProcessContainer = upc;
        this.userAccount = account;
        this.doctorDepartment = docDep;
        
        populatePatientsTable();
    }
    
    private void populatePatientsTable()
    {
        DefaultTableModel model = (DefaultTableModel) tblAllAdmittedPatients.getModel();
        model.setRowCount(0);
        
        for (WorkRequest request : doctorDepartment.getWorkQueue().getWorkRequestList()){
            if(request instanceof AdmitPatientWorkRequest && request.getStatus().equals(WorkRequestStatusType.Created))
            {
                Patient patient = ((AdmitPatientWorkRequest)request).getPatient();
                
                    Object[] row = new Object[3];
                    row[0] = request; 
                    row[1] = patient;
                    row[2] = request.getSender();
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
        tblAllAdmittedPatients = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnAssignToMe = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAllAdmittedPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request", "Patient", "Attending Nurse"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAllAdmittedPatients);
        if (tblAllAdmittedPatients.getColumnModel().getColumnCount() > 0) {
            tblAllAdmittedPatients.getColumnModel().getColumn(0).setResizable(false);
            tblAllAdmittedPatients.getColumnModel().getColumn(1).setResizable(false);
            tblAllAdmittedPatients.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 388, 91));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        btnAssignToMe.setText("Assign to Me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });
        add(btnAssignToMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 190, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblAllAdmittedPatients.getSelectedRow();
        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null,"Please select a row");
            return;
        }
        WorkRequest request = (WorkRequest)tblAllAdmittedPatients.getValueAt(selectedRow, 0);
        request.setReceiver(this.userAccount);
        request.setStatus(WorkRequestStatusType.Processing);
        this.userAccount.getWorkQueue().getWorkRequestList().add(request);
        Logger logger = Logger.getLogger(this.getClass().toString());
        logger.log(Level.INFO,String.format("Patient assigned to Doctor:%s ", this.userAccount.getPerson().getName()));
        populatePatientsTable();
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAllAdmittedPatients;
    // End of variables declaration//GEN-END:variables
}
