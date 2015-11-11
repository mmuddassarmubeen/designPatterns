/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserInterface.PatientWorkArea;

import healthcare.CommunicationBroadcast.CommunicationVisitor;
import healthcare.Drug.Drug;
import healthcare.Ecosystem.EcoSystem;
import healthcare.Encounter.Allergies;
import healthcare.Encounter.LabTest;
import healthcare.Encounter.Medication;
import healthcare.Encounter.Medication.MedicationType;
import healthcare.Encounter.MedicationOrder;
import healthcare.Encounter.SocialHabits;
import healthcare.Enterprise.Enterprise;
import healthcare.Patient.Patient;
import healthcare.UserAccount.UserAccount;
import healthcare.WorkQueue.PatientHistoryWorkRequest;
import healthcare.WorkQueue.PostMessageWorkRequest;
import healthcare.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muddassar
 */
public class PatientWorkArea extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private EcoSystem system;
    /**
     * Creates new form PatientWorkArea
     */
    public PatientWorkArea(JPanel upc, UserAccount account, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = upc;
        this.userAccount = account;
        this.enterprise = enterprise;
        this.system = system;
        this.populateProfile();
        this.populateMessages();
        this.populateMedicalHistory();
    }
    
    private void populateProfile()
    {
        Patient patient = (Patient)this.userAccount.getPerson();
        
        this.txtName.setText(patient.getName());
        this.txtAge.setText(String.valueOf(patient.getAge()));
        this.txtGender.setText(patient.getGender());
    }
    
    private void populateMedicalHistory()
    {
        ArrayList<Allergies> allergyList = new ArrayList<>();
        ArrayList<SocialHabits> socialHabits = new ArrayList<>();
        ArrayList<MedicationOrder> medication = new ArrayList<>();
        for(WorkRequest wr : this.userAccount.getWorkQueue().getWorkRequestList())
        {
            if(wr instanceof PatientHistoryWorkRequest)
            {
                PatientHistoryWorkRequest req = (PatientHistoryWorkRequest)wr;
                if(req.getPatientHistoryContract() != null)
                {
                    allergyList.addAll(req.getPatientHistoryContract().getAllergies().getAllergyList());
                    socialHabits.addAll(req.getPatientHistoryContract().getSocialHabits().getSocialHabitsList());
                    medication.addAll(req.getPatientHistoryContract().getMedicationHistory().getMedicationList());
                    }
            }
        }
        this.populateAllergies(allergyList);
        this.populateSocialHabits(socialHabits);
        this.populateMedications(medication);
    }
    
    private void populateAllergies(ArrayList<Allergies> allergies)
    {
        DefaultTableModel model = (DefaultTableModel)tblAllergies.getModel();
        model.setRowCount(0);
        for (Allergies allergy : allergies){
            Object[] row = new Object[2];
            row[0] = allergy.getAllergy();
            row[1] = allergy.getDescription();
            model.addRow(row);
        }    
    }
    
    private void populateSocialHabits(ArrayList<SocialHabits> socialHabits)
    {
        DefaultTableModel model = (DefaultTableModel)tblConditions.getModel();
        model.setRowCount(0);
        for (SocialHabits socialhabit : socialHabits){
            Object[] row = new Object[2];
            row[0] = socialhabit.getHabit();
            row[1] = socialhabit.getStatus();
            model.addRow(row);
        }    
    }
    
    private void populateMedications(ArrayList<MedicationOrder> medications)
    {
        DefaultTableModel model = (DefaultTableModel)tblMedecations.getModel();
        model.setRowCount(0);
        for (MedicationOrder order : medications){
            Object[] row = new Object[4];
            row[0] = order.getMedication().getName();
            String medType = "";
            String result = "";
            if(order.getMedication() instanceof Drug)
            {
                medType = MedicationType.Drug.getValue();
                result = String.valueOf(order.getDosage());
            }
            else
            {
                medType = MedicationType.LabTest.getValue();
                result = ((LabTest)order.getMedication()).getResult();
            }
            row[1] = medType;
            row[2] = result;
            row[3] = order.getOrderedBy();
            model.addRow(row);
        }    
    }
    
    private void populateMessages()
    {
        DefaultTableModel dtm = (DefaultTableModel)tblGroupMessages.getModel();
        dtm.setRowCount(0);
        for(WorkRequest wr : this.enterprise.getWorkQueue().getWorkRequestList())
        {
            PostMessageWorkRequest req = (PostMessageWorkRequest)wr;
            Object[] row = new Object[4];
            row[0] = wr;
            row[1] = req.getTitle();
            row[2] = req.getMessages().get(req.getMessages().size()-1).getPostedBy();
            dtm.addRow(row);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtGender = new javax.swing.JTextField();
        btnUpdateProfile = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAllergies = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblConditions = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedecations = new javax.swing.JTable();
        btnRequestHistory = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGroupMessages = new javax.swing.JTable();
        btnViewDetail = new javax.swing.JButton();
        btnNewTopic = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Name");

        jLabel2.setText("Age");

        jLabel3.setText("Gender");

        btnUpdateProfile.setText("Update Profile");
        btnUpdateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(txtAge, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGender, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnUpdateProfile)))
                .addContainerGap(270, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnUpdateProfile)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Profile", jPanel1);

        tblAllergies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Allergy", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblAllergies);
        if (tblAllergies.getColumnModel().getColumnCount() > 0) {
            tblAllergies.getColumnModel().getColumn(0).setResizable(false);
            tblAllergies.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265))
        );

        jTabbedPane2.addTab("Allergies", jPanel3);

        tblConditions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SocialHabit", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblConditions);
        if (tblConditions.getColumnModel().getColumnCount() > 0) {
            tblConditions.getColumnModel().getColumn(0).setResizable(false);
            tblConditions.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265))
        );

        jTabbedPane2.addTab("Social Habits", jPanel4);

        tblMedecations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medication", "Type", "Result", "OrderedBy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMedecations);
        if (tblMedecations.getColumnModel().getColumnCount() > 0) {
            tblMedecations.getColumnModel().getColumn(0).setResizable(false);
            tblMedecations.getColumnModel().getColumn(1).setResizable(false);
            tblMedecations.getColumnModel().getColumn(2).setResizable(false);
            tblMedecations.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );

        jTabbedPane2.addTab("Medication", jPanel5);

        btnRequestHistory.setText("Request History");
        btnRequestHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnRequestHistory)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnRequestHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("History", jPanel2);

        tblGroupMessages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Message", "Topic", "Last Reply By"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblGroupMessages);
        if (tblGroupMessages.getColumnModel().getColumnCount() > 0) {
            tblGroupMessages.getColumnModel().getColumn(0).setResizable(false);
            tblGroupMessages.getColumnModel().getColumn(1).setResizable(false);
            tblGroupMessages.getColumnModel().getColumn(2).setResizable(false);
        }

        btnViewDetail.setText("View Detail");
        btnViewDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailActionPerformed(evt);
            }
        });

        btnNewTopic.setText("New Topic");
        btnNewTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTopicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(btnViewDetail)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNewTopic)
                .addGap(24, 24, 24))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(btnNewTopic)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnViewDetail)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Forums", jPanel6);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 41, -1, -1));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 6, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblGroupMessages.getSelectedRow();
        
        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null, "Please select a topic for viewing detail");
            return;
            
        }
        PostMessageWorkRequest pr = (PostMessageWorkRequest)tblGroupMessages.getValueAt(selectedRow, 0);
        
        TopicDetailJPanel tdjp = new TopicDetailJPanel(userProcessContainer, pr, this.userAccount);
        userProcessContainer.add("TopicDetailJPanel", tdjp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnViewDetailActionPerformed

    private void btnNewTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTopicActionPerformed
        // TODO add your handling code here:
        CreateTopicJPanel ctjp = new CreateTopicJPanel(this.userProcessContainer, this.enterprise, this.userAccount);
        userProcessContainer.add("TopicDetailJPanel", ctjp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnNewTopicActionPerformed

    private void btnUpdateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProfileActionPerformed
        // TODO add your handling code here:
        if(this.userAccount.getPerson() instanceof Patient)
        {
            UpdateProfileJPanel muajp = new UpdateProfileJPanel(userProcessContainer,(Patient)this.userAccount.getPerson() );
            userProcessContainer.add("UpdateProfileJPanel", muajp);

            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnUpdateProfileActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        this.populateProfile();
        this.populateMessages();
        this.populateMedicalHistory();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnRequestHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestHistoryActionPerformed
        // TODO add your handling code here:
        CommunicationVisitor visitor = new CommunicationVisitor();
        PatientHistoryWorkRequest wr = new PatientHistoryWorkRequest(this.enterprise);
        wr.setMessage("Get My History");
        wr.setSender(this.userAccount);
        visitor.setWorkRequest(wr);
        this.userAccount.getWorkQueue().getWorkRequestList().add(wr);
        
        this.system.broadcastToHospitalEnterprisesWorkRequest(visitor);
        
        JOptionPane.showMessageDialog(null,"Your request for clinical data has been queued \n "
                + "Please wait for the request to be completed and then click Refresh");
        
    }//GEN-LAST:event_btnRequestHistoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewTopic;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRequestHistory;
    private javax.swing.JButton btnUpdateProfile;
    private javax.swing.JButton btnViewDetail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblAllergies;
    private javax.swing.JTable tblConditions;
    private javax.swing.JTable tblGroupMessages;
    private javax.swing.JTable tblMedecations;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
