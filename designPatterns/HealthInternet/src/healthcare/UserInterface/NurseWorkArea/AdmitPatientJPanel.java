/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserInterface.NurseWorkArea;

import healthcare.Department.DepartmentType;
import healthcare.Department.DoctorDepartment;
import healthcare.Department.PatientDepartment;
import healthcare.Department.SocialGroup;
import healthcare.Person.Person;
import healthcare.Encounter.Encounter;
import healthcare.Enterprise.Enterprise;
import static healthcare.Network.Network.NetworkType.SocialNetwork;
import healthcare.Network.SocialNetwork;
import healthcare.Patient.Patient;
import healthcare.Patient.PatientStatus;
import healthcare.UserAccount.UserAccount;
import healthcare.VitalSign.VitalSignStatus;
import healthcare.WorkQueue.AdmitPatientWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muddassar
 */
public class AdmitPatientJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private PatientDepartment patientDepartment;
    private DoctorDepartment doctorDepartment;
    
    /**
     * Creates new form RegisterPatientJPanel
     */
    public AdmitPatientJPanel(JPanel upc,UserAccount account, PatientDepartment patDept,DoctorDepartment docDept) {
        initComponents();
        this.patientDepartment = patDept;
        this.doctorDepartment = docDept;
        this.userProcessContainer = upc;
        this.userAccount = account;
        
        setTableColor();
        populateTable();
        
    }
    
    private void populateTable()
    {
        DefaultTableModel model = (DefaultTableModel) tblPatients.getModel();
        model.setRowCount(0);
        for (Person person : patientDepartment.getPersonDirectory().getPersonList()){
            Patient p = (Patient)person;
            if(p.getStatus().equals(PatientStatus.NEW))
            {
                Object[] row = new Object[5];
                row[0] = p;
                row[1] = p.getAge();
                row[2] = p.getGender();
                row[3] = p.getStatus().getValue();
                VitalSignStatus status = p.getCurrentEncounter().getVitalSignSummary().getVitalSignStatus();
                row[4] =  status != null ? status: null; 
                
                model.addRow(row);
            }
        }
    }

    private void setTableColor()
    {
         tblPatients.getColumn("VitalSigns").setCellRenderer(
            new DefaultTableCellRenderer() {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            if (value == null) {
                renderer.setText("");
            } else {
                renderer.setText(value.toString());
            }

            if (value!=null && ((VitalSignStatus)value).equals(VitalSignStatus.Abnormal)) {
                renderer.setForeground(Color.RED);
            } else {
                renderer.setForeground(Color.GREEN); // Retore original color
            }
            return renderer;
        }
    });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtChiefComplaint = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnAssignDoctor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        btnAddVitalSigns = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAdmit = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnAddDemographicInformation = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPatientSearch = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jLabel1.setText("Admit Patient");

        jLabel5.setText("Chief Complaint");

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAssignDoctor.setText("Assign Doctor");
        btnAssignDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignDoctorActionPerformed(evt);
            }
        });

        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient", "Age", "Gender", "Status", "VitalSigns"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPatients);
        if (tblPatients.getColumnModel().getColumnCount() > 0) {
            tblPatients.getColumnModel().getColumn(0).setResizable(false);
            tblPatients.getColumnModel().getColumn(1).setResizable(false);
            tblPatients.getColumnModel().getColumn(2).setResizable(false);
            tblPatients.getColumnModel().getColumn(3).setResizable(false);
            tblPatients.getColumnModel().getColumn(4).setResizable(false);
        }

        btnAddVitalSigns.setText("Add VitalSigns");
        btnAddVitalSigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVitalSignsActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jLabel3.setText("Search:");

        btnAdmit.setText("Admit");
        btnAdmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmitActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnAddDemographicInformation.setText("Add Demographic Info");
        btnAddDemographicInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDemographicInformationActionPerformed(evt);
            }
        });

        tblPatientSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblPatientSearch);
        if (tblPatientSearch.getColumnModel().getColumnCount() > 0) {
            tblPatientSearch.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(btnAddDemographicInformation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddVitalSigns))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnAdmit)
                                    .addContainerGap(126, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(35, 35, 35)
                                .addComponent(txtChiefComplaint, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAssignDoctor))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnRefresh)
                .addContainerGap(710, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdmit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnAddDemographicInformation)
                    .addComponent(btnAddVitalSigns))
                .addGap(96, 96, 96)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtChiefComplaint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnAssignDoctor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addContainerGap(118, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignDoctorActionPerformed
        // TODO add your handling code here:
        if(txtChiefComplaint.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Chief complaint cannot be blank");
            return;
        }
        int selectedRow = tblPatients.getSelectedRow();
        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null, "Select a row!");
            return;
        }
        
        Patient patient = (Patient)tblPatients.getValueAt(selectedRow, 0);
        
        if(patient.getAge()<1 || patient.getGender().isEmpty() || (patient.getCurrentEncounter().getVitalSignSummary().getVitalSignStatus() == null))
        {
            JOptionPane.showMessageDialog(null, "Please enter demographic and vital sign details to proceed!");
            return;
        }
        
        
        AdmitPatientWorkRequest wr = new AdmitPatientWorkRequest();
        patient.setStatus(PatientStatus.ADMITTED);
        
        Encounter encounter = patient.getCurrentEncounter();
        encounter.setChiefComplaint(txtChiefComplaint.getText());
        
        wr.setPatient(patient);
        wr.setSender(this.userAccount);
        wr.setMessage("Admitted");
        
        this.doctorDepartment.getWorkQueue().getWorkRequestList().add(wr);
        Logger logger = Logger.getLogger(this.getClass().toString());
        logger.log(Level.INFO,String.format("Patient: admitted:%s ", patient.getName()));
        
        this.populateTable();
        
    }//GEN-LAST:event_btnAssignDoctorActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddVitalSignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVitalSignsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPatients.getSelectedRow();
        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null, "Select a row!");
            return;
        }
        
        Patient patient = (Patient)tblPatients.getValueAt(selectedRow, 0);
        if(patient.getAge()<1)
        {
            JOptionPane.showMessageDialog(null, "Please enter Demographic details before entering vital signs");
            return;
        }
        AddVitalSignsJPanel mejp = new AddVitalSignsJPanel(userProcessContainer, patient);
        userProcessContainer.add("ManageEncounterJPanel", mejp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddVitalSignsActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
        String search = txtSearch.getText();
        if(search.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Search string can't be blank \n enter ALL for viewing all non-admitted patients");
            return;
        }
        DefaultTableModel dtm = (DefaultTableModel)tblPatientSearch.getModel();
        dtm.setRowCount(0);
        
        for(Person patient : this.patientDepartment.getPersonDirectory().getPersonList())
        {
            if(patient.getName().startsWith(search) || search.equals("ALL"))
            {
                Object[] row = new Object[1];
                row[0] = patient;
                dtm.addRow(row);
            }
        }
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        this.populateTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAdmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmitActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tblPatientSearch.getSelectedRow();
        if(selectedIndex < 0)
        {
            JOptionPane.showMessageDialog(null, "Please select a value");
            return;
        }
        Patient patient = (Patient)tblPatientSearch.getValueAt(selectedIndex, 0);
        if(!patient.getStatus().equals(PatientStatus.DISCHARGED))
        {
            JOptionPane.showMessageDialog(null, "This patient is currently admitted in the hospital");
            return;
        }
        patient.setStatus(PatientStatus.NEW);
        this.populateTable();
    }//GEN-LAST:event_btnAdmitActionPerformed

    private void btnAddDemographicInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDemographicInformationActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblPatients.getSelectedRow();
        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null, "Select a row!");
            return;
        }
        
        
        Patient patient  = (Patient)tblPatients.getValueAt(selectedRow, 0);
        DemographicInformationJPanel muajp = new DemographicInformationJPanel(userProcessContainer, patient);
        userProcessContainer.add("DemographicInformationJPanel", muajp);
        
        btnAddVitalSigns.setEnabled(true);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnAddDemographicInformationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDemographicInformation;
    private javax.swing.JButton btnAddVitalSigns;
    private javax.swing.JButton btnAdmit;
    private javax.swing.JButton btnAssignDoctor;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblPatientSearch;
    private javax.swing.JTable tblPatients;
    private javax.swing.JTextField txtChiefComplaint;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
