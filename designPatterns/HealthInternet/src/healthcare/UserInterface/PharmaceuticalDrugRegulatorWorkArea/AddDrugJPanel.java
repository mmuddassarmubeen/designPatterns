/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserInterface.PharmaceuticalDrugRegulatorWorkArea;

import healthcare.Commons.DoctorSpecialtyType;
import healthcare.Commons.DrugStatusType;
import healthcare.Drug.Drug;
import healthcare.Drug.DrugCatalog;
import healthcare.FDADrugRegulation.REMSElementsToAssureSafeUseGuideline;
import healthcare.FDADrugRegulation.REMSMedicationGuideGuideline;
import java.awt.CardLayout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Muddassar
 */
public class AddDrugJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private DrugCatalog drugCatalog;
    private String manufacturer;
    
    /**
     * Creates new form AddDrugJPanel
     */
    public AddDrugJPanel(JPanel upc, DrugCatalog catalog, String manufacturer) {
        initComponents();
        this.userProcessContainer = upc;
        this.drugCatalog = catalog;
        this.manufacturer = manufacturer;
        this.populateDrugStatus();
    }
    
    
    private void populateDrugStatus()
    {
        cmbDrugStatus.removeAllItems();
        for(DrugStatusType type : DrugStatusType.values())
        {
            cmbDrugStatus.addItem(type);
        }
    }
    private boolean validateEmptyFields()
    {
        if(txtDrugName.getText().isEmpty()
                || cmbDrugStatus.getSelectedIndex()<0
                || (chkMedicationGuide.isSelected() && (txtREMSAge.getText().isEmpty() || txtREMSDosage.getText().isEmpty()))
                ||(chkEASUDoctorSpecialty.isSelected() && listDoctorSpecialty.getSelectedIndex() < 0) )
        {
            return false;
        }
        return true;
        
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
        jLabel2 = new javax.swing.JLabel();
        txtDrugName = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        chkMedicationGuide = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        chkEASUDoctorSpecialty = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        listDoctorSpecialty = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        txtREMSAge = new javax.swing.JTextField();
        txtREMSDosage = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbDrugStatus = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Add Drug");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 6, -1, -1));

        jLabel2.setText("Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        txtDrugName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDrugNameActionPerformed(evt);
            }
        });
        add(txtDrugName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 140, -1));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 313, -1, -1));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 313, -1, -1));

        chkMedicationGuide.setText("Medication Guide");
        chkMedicationGuide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMedicationGuideActionPerformed(evt);
            }
        });
        add(chkMedicationGuide, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 155, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 111, 523, 10));

        jLabel6.setText("FDA Regulation");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 127, -1, -1));

        chkEASUDoctorSpecialty.setText("EASU(Mandatory Presribing Doctor Specialties)");
        chkEASUDoctorSpecialty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEASUDoctorSpecialtyActionPerformed(evt);
            }
        });
        add(chkEASUDoctorSpecialty, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        jScrollPane2.setViewportView(listDoctorSpecialty);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 170, 101));

        jLabel7.setText("Age(Min)");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        txtREMSAge.setEnabled(false);
        add(txtREMSAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 90, -1));

        txtREMSDosage.setEnabled(false);
        txtREMSDosage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtREMSDosageActionPerformed(evt);
            }
        });
        add(txtREMSDosage, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 90, -1));

        jLabel8.setText("Dosage(Max)");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel3.setText("DrugStatus");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        cmbDrugStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbDrugStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtDrugNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDrugNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDrugNameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(!validateEmptyFields())
        {
             JOptionPane.showMessageDialog(null,"All fields are mandatory");
            return;
        }
        Drug drug = new Drug(txtDrugName.getText());
        drug.setManufacturer(this.manufacturer);
        drug.setDrugStatus(cmbDrugStatus.getSelectedItem().toString());
        if(chkMedicationGuide.isSelected())
        {
            REMSMedicationGuideGuideline medicationGuide = new REMSMedicationGuideGuideline();
            int age = 0;
            int dosage = 0;
            try
            {
                age = Integer.parseInt(txtREMSAge.getText());
                dosage = Integer.parseInt(txtREMSDosage.getText());
            }
            catch(NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(null,"Please enter fields in correct format");
                return;
            }
            
            
            medicationGuide.setAge(age);
            medicationGuide.setDosage(dosage);
            drug.getMedicationGuidelines().addDrugComplianceGuideline(medicationGuide);
        }
        if(chkEASUDoctorSpecialty.isSelected())
        {
            List<DoctorSpecialtyType> doctorTypes = listDoctorSpecialty.getSelectedValuesList();
            REMSElementsToAssureSafeUseGuideline guideline = new REMSElementsToAssureSafeUseGuideline(doctorTypes);
            drug.getMedicationGuidelines().addDrugComplianceGuideline(guideline);
        }
        
        this.drugCatalog.getDrugList().add(drug);
        Logger logger = Logger.getLogger(this.getClass().toString());
        logger.log(Level.INFO,String.format("New drug added:%s with status:%s ", drug.getName(),drug.getDrugStatus()));
        JOptionPane.showMessageDialog(null,"Drug added");
    }//GEN-LAST:event_btnAddActionPerformed

    private void chkMedicationGuideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMedicationGuideActionPerformed
        // TODO add your handling code here:
        if(chkMedicationGuide.isSelected())
        {
            txtREMSAge.setEnabled(true);
            txtREMSDosage.setEnabled(true);
        }
        else
        {
            txtREMSAge.setEnabled(false);
            txtREMSDosage.setEnabled(false);
        }
    }//GEN-LAST:event_chkMedicationGuideActionPerformed

    private void chkEASUDoctorSpecialtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEASUDoctorSpecialtyActionPerformed
        // TODO add your handling code here:
        if(chkEASUDoctorSpecialty.isSelected())
        {
            DefaultListModel dlm = new DefaultListModel();
            for(DoctorSpecialtyType speciality : DoctorSpecialtyType.values())
            {
                dlm.addElement(speciality);
            }
            listDoctorSpecialty.setModel(dlm);
            listDoctorSpecialty.setEnabled(true);
            listDoctorSpecialty.validate();
        }
        else
        {
            listDoctorSpecialty.setEnabled(false);
        }
    }//GEN-LAST:event_chkEASUDoctorSpecialtyActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtREMSDosageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtREMSDosageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtREMSDosageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JCheckBox chkEASUDoctorSpecialty;
    private javax.swing.JCheckBox chkMedicationGuide;
    private javax.swing.JComboBox cmbDrugStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList listDoctorSpecialty;
    private javax.swing.JTextField txtDrugName;
    private javax.swing.JTextField txtREMSAge;
    private javax.swing.JTextField txtREMSDosage;
    // End of variables declaration//GEN-END:variables
}