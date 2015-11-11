/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserInterface.DoctorWorkArea;

import healthcare.Commons.DoctorSpecialtyType;
import healthcare.Commons.WorkRequestStatusType;
import healthcare.CommunicationBroadcast.CommunicationVisitor;
import healthcare.Department.LabDepartment;
import healthcare.Department.PharmacyDepartment;
import healthcare.Drug.Drug;
import healthcare.Drug.REMSDrugComplianceGuidelines;
import healthcare.Ecosystem.EcoSystem;
import healthcare.Encounter.Allergies;
import healthcare.Encounter.Assessment;
import healthcare.Encounter.AssessmentSummary;
import healthcare.Encounter.Encounter;
import healthcare.Encounter.LabTest;
import healthcare.Encounter.MedicationOrder;
import healthcare.Encounter.SocialHabits;
import healthcare.Enterprise.Enterprise;
import healthcare.FDADrugRegulation.REMSComplianceGuidelines;
import healthcare.FDADrugRegulation.REMSElementsToAssureSafeUseGuideline;
import healthcare.FDADrugRegulation.REMSMedicationGuideGuideline;
import healthcare.Patient.Patient;
import healthcare.UserAccount.UserAccount;
import healthcare.VitalSign.VitalSign;
import healthcare.VitalSign.VitalSignStatus;
import healthcare.VitalSign.VitalSignSummary;
import healthcare.WorkQueue.LabTestWorkRequest;
import healthcare.WorkQueue.MedicationWorkRequest;
import healthcare.WorkQueue.PatientProfileWorkRequest;
import healthcare.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.Iterator;
import java.util.Map;
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
public class PatientEncounterHistoryJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Patient patient;
    private EcoSystem system;
    private UserAccount userAccount;
    private LabDepartment labDepartment;
    private PharmacyDepartment pharmacyDepartment;
    private WorkRequest workRequest;
    private Enterprise enterprise;
    
    /**
     * Creates new form PatientEncounterHistoryJPanel
     */
    public PatientEncounterHistoryJPanel(JPanel upc, Patient patient, UserAccount account,LabDepartment labDepartment, PharmacyDepartment pharmacyDept,  EcoSystem system, WorkRequest request, Enterprise ent) {
        initComponents();
        this.userProcessContainer = upc;
        this.patient = patient;
        this.system = system;
        this.userAccount = account;
        this.labDepartment = labDepartment;
        this.pharmacyDepartment = pharmacyDept;
        this.workRequest = request;
        this.enterprise = ent;
        
        this.populateLocalEncounterTable();
        this.populateInfo();
        this.setTableColor();
        this.populateConditions();
        this.populateDrugs();
        
    }

    private void populateLocalEncounterTable()
    {
        DefaultTableModel model = (DefaultTableModel) tblEncounterHistory.getModel();
        
        model.setRowCount(0);
        
        Iterator<Encounter> iter = patient.getEncounterHistory().getEncounterList().iterator();

        while (iter.hasNext()){
            Object[] row = new Object[2];
            Encounter e = iter.next();
            row[0] = e;
            row[1] = e.getChiefComplaint();
            model.addRow(row);
        }
    }
    
    private void populteGlobalEncounterTable()
    {
        this.populateLocalEncounterTable();
        for(WorkRequest wr : this.userAccount.getWorkQueue().getWorkRequestList())
        {
            if(wr instanceof PatientProfileWorkRequest)
            {
                PatientProfileWorkRequest req = (PatientProfileWorkRequest)wr;
                if(req.getPatient().getSsn().equals(patient.getSsn()))
                {
                    DefaultTableModel model = (DefaultTableModel) tblEncounterHistory.getModel();
                    for (Encounter encounter : req.getSearchPatientContract().getEncounterList()){
                        Object[] row = new Object[2];
                        row[0] = encounter;
                        row[1] = encounter.getChiefComplaint();
                        model.addRow(row);
                    }
                }
            }
        }
        
    }
    
    private void populateInfo()
    {
        txtName.setText(patient.getName());
        txtGender.setText(patient.getGender());
        txtAge.setText(String.valueOf(patient.getAge()));
    }
    
    private void populateConditions()
    {
        DefaultListModel dlmAllergy = new DefaultListModel();
        for(Allergies allergy : this.patient.getAllergyHistory().getAllergyList())
        {
            dlmAllergy.addElement(allergy.getAllergy() + " - " + allergy.getDescription());
        }
        
        DefaultListModel dlmSocialHabits = new DefaultListModel();
        for(SocialHabits habits : this.patient.getSocialHabitSummary().getSocialHabitsList())
        {
            dlmSocialHabits.addElement(habits.getHabit()+ " - " + habits.getStatus());
        }
        for(WorkRequest wr : this.userAccount.getWorkQueue().getWorkRequestList())
        {
            if(wr instanceof PatientProfileWorkRequest)
            {
                PatientProfileWorkRequest req = (PatientProfileWorkRequest)wr;
                if(req.getPatient().getSsn().equals(patient.getSsn()))
                {
                    for(Allergies globalAllergy : req.getSearchPatientContract().getAllergies())
                    dlmAllergy.addElement(globalAllergy.getAllergy() + " - " + globalAllergy.getDescription());
                }
                if(req.getPatient().getSsn().equals(patient.getSsn()))
                {
                    for(SocialHabits globalHabits : req.getSearchPatientContract().getSocialHabits())
                    dlmSocialHabits.addElement(globalHabits.getHabit()+ " - " + globalHabits.getStatus());
                }
            }
        }
        listAllergies.setModel(dlmAllergy);
        listAllergies.validate();
        listHabits.setModel(dlmSocialHabits);
        listHabits.validate();
    }
    
    private void populateDrugs()
    {
        cmbDrugs.removeAllItems();
        if(pharmacyDepartment !=null)
        {
            for(Drug drug : this.pharmacyDepartment.getDrugCatalog().getDrugList())
            {
                cmbDrugs.addItem(drug);
            }
        }
    }
    
    private void populateAssessments(AssessmentSummary summary)
    {
        DefaultTableModel dtm = (DefaultTableModel)tblAssessment.getModel();
        dtm.setRowCount(0);
        for(Assessment assessment : summary.getAssessmentList())
        {
            Object[] row = new Object[2];
            row[0] = assessment.getCondition();
            row[1] = assessment.getConditionStatus();
            dtm.addRow(row);

        }
    }
    
    
    private void setTableColor()
    {
         tblVitalSigns.getColumn("Status").setCellRenderer(
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
    
    private void populateVitalSigns(VitalSignSummary summary)
    {
        DefaultTableModel model = (DefaultTableModel) tblVitalSigns.getModel();
        model.setRowCount(0);
        
        for(Map.Entry<VitalSign,VitalSignStatus> map : summary.getVitalSigns().entrySet())
        {
            Object[] row = new Object[3];
            row[0] = map.getKey().getName();
            row[1] = map.getKey().getValue();
            row[2] = map.getValue();
            model.addRow(row);
        }
    }
    
    private boolean validateDrugREMS(MedicationWorkRequest wr)
    {
        boolean result = true;
        for(REMSComplianceGuidelines guideline : ((Drug)wr.getMedicationOrder().getMedication()).getMedicationGuidelines().getComplianceGuidelines())
        {
            result = result && guideline.complianceStatus(wr);
        }
        
        return result;
        
    }
    
    
    
    private void setEncounterInformationMode(boolean value)
    {
        for(int i=0;i<6;i++)
        {
            JPanel pnl = (JPanel)this.paneEncounterDetails.getComponentAt(i);
            if(pnl != null)
            {
                for(Component comp :pnl.getComponents())
                {
                    if(comp!=null)
                    {
                        if(i == 3)
                        {
                            for(Component c : pnlLab.getComponents())
                            {
                                c.setEnabled(value);
                            }
                            for(Component c : pnlDrugs.getComponents())
                            {
                                c.setEnabled(value);
                            }
                            
                        }
                        else
                        {
                            comp.setEnabled(value);
                        }
                        
                    }
                }
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
        tblEncounterHistory = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnViewEncounterDetails = new javax.swing.JButton();
        paneEncounterDetails = new javax.swing.JTabbedPane();
        pnlInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtGender = new javax.swing.JTextField();
        pnlVitalSigns = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVitalSigns = new javax.swing.JTable();
        pnlAssessment = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtDiagnosis = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDiagnosisStatus = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblAssessment = new javax.swing.JTable();
        pnlMedication = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pnlLab = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLabTests = new javax.swing.JTable();
        btnRequestTest = new javax.swing.JButton();
        txtLabTest = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pnlDrugs = new javax.swing.JPanel();
        btnOrderDrug = new javax.swing.JButton();
        txtDosage = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDrugOrder = new javax.swing.JTable();
        cmbDrugs = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnlDischargeStatus = new javax.swing.JPanel();
        btnDischarge = new javax.swing.JButton();
        pnlConditions = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listAllergies = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listHabits = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        btnCompleteProfile = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEncounterHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Encounter Date", "Chief Complaint"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEncounterHistory);
        if (tblEncounterHistory.getColumnModel().getColumnCount() > 0) {
            tblEncounterHistory.getColumnModel().getColumn(0).setResizable(false);
            tblEncounterHistory.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 644, 83));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 409, -1, -1));

        btnViewEncounterDetails.setText("View Details");
        btnViewEncounterDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEncounterDetailsActionPerformed(evt);
            }
        });
        add(btnViewEncounterDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel1.setText("Name");

        jLabel2.setText("Age");

        jLabel3.setText("Gender");

        txtAge.setText("jTextField1");

        txtGender.setText("jTextField1");

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(50, 50, 50)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(392, Short.MAX_VALUE))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        paneEncounterDetails.addTab("Info", pnlInfo);

        tblVitalSigns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "VitalSign", "Value", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVitalSigns);

        javax.swing.GroupLayout pnlVitalSignsLayout = new javax.swing.GroupLayout(pnlVitalSigns);
        pnlVitalSigns.setLayout(pnlVitalSignsLayout);
        pnlVitalSignsLayout.setHorizontalGroup(
            pnlVitalSignsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVitalSignsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );
        pnlVitalSignsLayout.setVerticalGroup(
            pnlVitalSignsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVitalSignsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        paneEncounterDetails.addTab("VitalSigns", pnlVitalSigns);

        pnlAssessment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Diagnosis");
        pnlAssessment.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));
        pnlAssessment.add(txtDiagnosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 85, -1));

        jLabel10.setText("Status");
        pnlAssessment.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        txtDiagnosisStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiagnosisStatusActionPerformed(evt);
            }
        });
        pnlAssessment.add(txtDiagnosisStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 85, -1));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlAssessment.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        tblAssessment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Diagnosis", "Status"
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
        jScrollPane7.setViewportView(tblAssessment);
        if (tblAssessment.getColumnModel().getColumnCount() > 0) {
            tblAssessment.getColumnModel().getColumn(0).setResizable(false);
        }

        pnlAssessment.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 390, 120));

        paneEncounterDetails.addTab("Assessment", pnlAssessment);

        tblLabTests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test", "Ordered By", "Tested By", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblLabTests);
        if (tblLabTests.getColumnModel().getColumnCount() > 0) {
            tblLabTests.getColumnModel().getColumn(0).setResizable(false);
            tblLabTests.getColumnModel().getColumn(1).setResizable(false);
            tblLabTests.getColumnModel().getColumn(2).setResizable(false);
            tblLabTests.getColumnModel().getColumn(3).setResizable(false);
        }

        btnRequestTest.setText("Request Test");
        btnRequestTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestTestActionPerformed(evt);
            }
        });

        jLabel4.setText("Lab Test");

        javax.swing.GroupLayout pnlLabLayout = new javax.swing.GroupLayout(pnlLab);
        pnlLab.setLayout(pnlLabLayout);
        pnlLabLayout.setHorizontalGroup(
            pnlLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLabLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnlLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlLabLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(txtLabTest, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnRequestTest))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        pnlLabLayout.setVerticalGroup(
            pnlLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRequestTest)
                    .addGroup(pnlLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLabTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("LabTest", pnlLab);

        btnOrderDrug.setText("Order Drug");
        btnOrderDrug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderDrugActionPerformed(evt);
            }
        });

        tblDrugOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug", "Dosage", "Ordered By"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblDrugOrder);
        if (tblDrugOrder.getColumnModel().getColumnCount() > 0) {
            tblDrugOrder.getColumnModel().getColumn(0).setResizable(false);
            tblDrugOrder.getColumnModel().getColumn(1).setResizable(false);
            tblDrugOrder.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel7.setText("Drug");

        jLabel8.setText("Dosage");

        javax.swing.GroupLayout pnlDrugsLayout = new javax.swing.GroupLayout(pnlDrugs);
        pnlDrugs.setLayout(pnlDrugsLayout);
        pnlDrugsLayout.setHorizontalGroup(
            pnlDrugsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDrugsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbDrugs, 0, 115, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtDosage, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOrderDrug)
                .addGap(116, 116, 116))
            .addGroup(pnlDrugsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDrugsLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(116, Short.MAX_VALUE)))
        );
        pnlDrugsLayout.setVerticalGroup(
            pnlDrugsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDrugsLayout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(pnlDrugsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDrugs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnOrderDrug)
                    .addComponent(txtDosage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap())
            .addGroup(pnlDrugsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDrugsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Drugs", pnlDrugs);

        javax.swing.GroupLayout pnlMedicationLayout = new javax.swing.GroupLayout(pnlMedication);
        pnlMedication.setLayout(pnlMedicationLayout);
        pnlMedicationLayout.setHorizontalGroup(
            pnlMedicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlMedicationLayout.setVerticalGroup(
            pnlMedicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMedicationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        paneEncounterDetails.addTab("Medication", pnlMedication);

        btnDischarge.setText("Discharge");
        btnDischarge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDischargeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDischargeStatusLayout = new javax.swing.GroupLayout(pnlDischargeStatus);
        pnlDischargeStatus.setLayout(pnlDischargeStatusLayout);
        pnlDischargeStatusLayout.setHorizontalGroup(
            pnlDischargeStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDischargeStatusLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(btnDischarge, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        pnlDischargeStatusLayout.setVerticalGroup(
            pnlDischargeStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDischargeStatusLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btnDischarge)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        paneEncounterDetails.addTab("DischargeStatus", pnlDischargeStatus);

        jScrollPane4.setViewportView(listAllergies);

        jLabel5.setText("Allergies");

        jScrollPane5.setViewportView(listHabits);

        jLabel6.setText("Habits");

        javax.swing.GroupLayout pnlConditionsLayout = new javax.swing.GroupLayout(pnlConditions);
        pnlConditions.setLayout(pnlConditionsLayout);
        pnlConditionsLayout.setHorizontalGroup(
            pnlConditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConditionsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlConditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(95, 95, 95)
                .addGroup(pnlConditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(306, Short.MAX_VALUE))
        );
        pnlConditionsLayout.setVerticalGroup(
            pnlConditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConditionsLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(pnlConditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlConditionsLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlConditionsLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        paneEncounterDetails.addTab("Conditions", pnlConditions);

        add(paneEncounterDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 630, 240));

        btnCompleteProfile.setText("Request Complete Profile");
        btnCompleteProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteProfileActionPerformed(evt);
            }
        });
        add(btnCompleteProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewEncounterDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewEncounterDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblEncounterHistory.getSelectedRow();
        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        Encounter encounter = (Encounter)tblEncounterHistory.getValueAt(selectedRow,0);
        
        if(encounter.getTimeStamp().before(this.patient.getCurrentEncounter().getTimeStamp()) ||
                encounter.getTimeStamp().after(this.patient.getCurrentEncounter().getTimeStamp()))
        {
            this.setEncounterInformationMode(false);
        }
        else
        {
            this.setEncounterInformationMode(true);
        }
        this.populateVitalSigns(encounter.getVitalSignSummary());
        this.populateAssessments(encounter.getAssessment());
        populateOrderedLabTests();
        populateOrderedDrugs();
        populateConditions();
        populateAssessments(encounter.getAssessment());
        
    }//GEN-LAST:event_btnViewEncounterDetailsActionPerformed

    private void btnDischargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDischargeActionPerformed
        // TODO add your handling code here:
        this.workRequest.setStatus(WorkRequestStatusType.Completed);
        this.patient.dischargePatient();
        Logger logger = Logger.getLogger(this.getClass().toString());
        logger.log(Level.INFO,String.format("Patient:%s has been discharged by Doctor:%s ", patient.getName(),this.userAccount.getPerson().getName()));
        JOptionPane.showMessageDialog(null, "Patient has been successfully discharged");
    }//GEN-LAST:event_btnDischargeActionPerformed

    private void btnCompleteProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteProfileActionPerformed
        // TODO add your handling code here:
        CommunicationVisitor visitor = new CommunicationVisitor();
        PatientProfileWorkRequest workRequest = new PatientProfileWorkRequest(this.enterprise);
        workRequest.setMessage("Request details of patient");
        workRequest.setPatient(patient);
        workRequest.setSender(this.userAccount);
        workRequest.setRequestingEnterprise(enterprise);
        this.userAccount.getWorkQueue().getWorkRequestList().add(workRequest);
        visitor.setWorkRequest(workRequest);
        this.system.broadcastToHospitalEnterprisesWorkRequest(visitor);
        Logger logger = Logger.getLogger(this.getClass().toString());
        logger.log(Level.INFO,String.format("Patient info requested for %s by Doctor:%s ", patient.getName(),this.userAccount.getPerson().getName()));
        JOptionPane.showMessageDialog(null,"Your request for clinical data has been queued \n "
                + "Please wait for the request to be completed and then click Refresh");
    }//GEN-LAST:event_btnCompleteProfileActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populteGlobalEncounterTable();
        populateConditions();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnRequestTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestTestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblEncounterHistory.getSelectedRow();
        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        //Create labtest Medication order
        MedicationOrder mo = new MedicationOrder();
        LabTest test = new LabTest(txtLabTest.getText());
        test.setResult("Pending");
        mo.setMedication(test);
        mo.setOrderedBy(this.userAccount);
        //Add it to patients prescription history so that it can be tracked
        this.patient.getCurrentEncounter().getPrescription().addMedication(mo);
        
        //Add medication order to MedicationWorkRequest
        MedicationWorkRequest workRequest = new MedicationWorkRequest();
        workRequest.setMessage(txtLabTest.getText());
        workRequest.setSender(this.userAccount);
        workRequest.setPatient(this.patient);
        workRequest.setMedicationOrder(mo);
        
        //Add work request to workqueues
        this.userAccount.getWorkQueue().getWorkRequestList().add(workRequest);
        this.labDepartment.getWorkQueue().getWorkRequestList().add(workRequest);
        Logger logger = Logger.getLogger(this.getClass().toString());
        logger.log(Level.INFO,String.format("Lab test ordered for Patient:%s by Doctor:%s ", patient.getName(),this.userAccount.getPerson().getName()));
        populateOrderedLabTests();
        
    }//GEN-LAST:event_btnRequestTestActionPerformed

    private void btnOrderDrugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderDrugActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblEncounterHistory.getSelectedRow();
        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        //Create drug Medication Order
        int dosage = 0;
        try
        {
            dosage = Integer.parseInt(txtDosage.getText());
        }
        catch(NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(null,"Please enter valid dosage value");
            return;
        }
        Drug drug = (Drug)cmbDrugs.getSelectedItem();
        MedicationOrder medicationOrder = new MedicationOrder();
        medicationOrder.setMedication(drug);
        medicationOrder.setDosage(dosage);
        medicationOrder.setOrderedBy(this.userAccount);
        
        this.patient.getCurrentEncounter().getPrescription().addMedication(medicationOrder);
        //Add medication order to work request
        MedicationWorkRequest workRequest = new MedicationWorkRequest();
        workRequest.setMessage("Prescription");
        workRequest.setSender(this.userAccount);
        workRequest.setPatient(this.patient);
        workRequest.setMedicationOrder(medicationOrder);
        
        //validate if the work request is valid according to REMS rules
        if(validateDrugREMS(workRequest))
        {
            this.userAccount.getWorkQueue().getWorkRequestList().add(workRequest);
            this.pharmacyDepartment.getWorkQueue().getWorkRequestList().add(workRequest);
            populateOrderedLabTests();
        }
        else
        {
            String medicationGuideError = "";
            String etasError = "";
            for(REMSComplianceGuidelines guideline : drug.getMedicationGuidelines().getComplianceGuidelines())
            {
                if(guideline instanceof REMSMedicationGuideGuideline)
                {
                    medicationGuideError = "Age should be greater than" + ((REMSMedicationGuideGuideline)guideline).getAge() + "\n";
                    medicationGuideError += "Dosage should be less than" + ((REMSMedicationGuideGuideline)guideline).getAge() + "\n"; 
                }
                if(guideline instanceof REMSElementsToAssureSafeUseGuideline)
                {
                    etasError = "Specialty of the doctor should be \n";
                    for(DoctorSpecialtyType spec : ((REMSElementsToAssureSafeUseGuideline)guideline).getApprovedDoctorSpecialties())
                    etasError += spec +"\n"; 
                }
            }
            JOptionPane.showMessageDialog(null,"This drug can't be prescribed to this patient \n"
                    + " due to FDA regulation \n" + "The prescribed REMS conditions are: \n "
            + medicationGuideError + etasError);
            return;
        }
        Logger logger = Logger.getLogger(this.getClass().toString());
        logger.log(Level.INFO,String.format("Medication ordered for Patient:%s by Doctor:%s ", patient.getName(),this.userAccount.getPerson().getName()));
        populateOrderedDrugs();
        
    }//GEN-LAST:event_btnOrderDrugActionPerformed

    private void txtDiagnosisStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiagnosisStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiagnosisStatusActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(txtDiagnosis.getText().isEmpty() || txtDiagnosisStatus.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Fields can't be blank");
            return;
        }
        Assessment assessment = this.patient.getCurrentEncounter().getAssessment().addAssessment();
        assessment.setCondition(txtDiagnosis.getText());
        assessment.setConditionStatus(txtDiagnosisStatus.getText());
        Logger logger = Logger.getLogger(this.getClass().toString());
        logger.log(Level.INFO,String.format("Assessment updated for Patient:%s by Doctor:%s ", patient.getName(),this.userAccount.getPerson().getName()));
        this.populateAssessments(this.patient.getCurrentEncounter().getAssessment());
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void populateOrderedLabTests()
    {
        int selectedRow = tblEncounterHistory.getSelectedRow();
        if(selectedRow < 0)
        {
	    JOptionPane.showMessageDialog(null,"Please select a row");
            return;
        }
        Encounter encounter = (Encounter)tblEncounterHistory.getValueAt(selectedRow, 0);
        DefaultTableModel model = (DefaultTableModel) tblLabTests.getModel();
        model.setRowCount(0);
        
        for(MedicationOrder mo : encounter.getPrescription().getMedicationList())
        {
            if(mo.getMedication() instanceof LabTest)
            {
                Object[] row = new Object[4];
                row[0] = mo.getMedication();
                row[1] = mo.getOrderedBy();
                row[2] = mo.getPerformedBy();
                row[3] = ((LabTest)mo.getMedication()).getResult();
                model.addRow(row);
            }
        }
    }
    
    private void populateOrderedDrugs()
    {
        int selectedRow = tblEncounterHistory.getSelectedRow();
        if(selectedRow < 0)
        {
	    JOptionPane.showMessageDialog(null,"Please select a row");
            return;
        }
        Encounter encounter = (Encounter)tblEncounterHistory.getValueAt(selectedRow, 0);
        DefaultTableModel model = (DefaultTableModel) tblDrugOrder.getModel();
        model.setRowCount(0);
        
        for(MedicationOrder mo : encounter.getPrescription().getMedicationList())
        {
            if(mo.getMedication() instanceof Drug)
            {
                Object[] row = new Object[4];
                row[0] = mo.getMedication();
                row[1] = mo.getDosage();
                row[2] = mo.getOrderedBy();
                row[3] = ((Drug)mo.getMedication()).getDrugStatus();
                model.addRow(row);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCompleteProfile;
    private javax.swing.JButton btnDischarge;
    private javax.swing.JButton btnOrderDrug;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRequestTest;
    private javax.swing.JButton btnViewEncounterDetails;
    private javax.swing.JComboBox cmbDrugs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JList listAllergies;
    private javax.swing.JList listHabits;
    private javax.swing.JTabbedPane paneEncounterDetails;
    private javax.swing.JPanel pnlAssessment;
    private javax.swing.JPanel pnlConditions;
    private javax.swing.JPanel pnlDischargeStatus;
    private javax.swing.JPanel pnlDrugs;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlLab;
    private javax.swing.JPanel pnlMedication;
    private javax.swing.JPanel pnlVitalSigns;
    private javax.swing.JTable tblAssessment;
    private javax.swing.JTable tblDrugOrder;
    private javax.swing.JTable tblEncounterHistory;
    private javax.swing.JTable tblLabTests;
    private javax.swing.JTable tblVitalSigns;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtDiagnosis;
    private javax.swing.JTextField txtDiagnosisStatus;
    private javax.swing.JTextField txtDosage;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtLabTest;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
