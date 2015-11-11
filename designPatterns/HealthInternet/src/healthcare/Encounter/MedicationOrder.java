/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Encounter;

import healthcare.UserAccount.UserAccount;

/**
 *
 * @author Muddassar
 */
public class MedicationOrder {
    
    private Medication medication;
    private String instruction;
    private int dosage;
    private UserAccount orderedBy;
    private UserAccount performedBy;

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public UserAccount getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(UserAccount orderedBy) {
        this.orderedBy = orderedBy;
    }

    public UserAccount getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(UserAccount performedBy) {
        this.performedBy = performedBy;
    }

    @Override
    public String toString() {
        return "MedicationOrder{" + "medication=" + medication + ", dosage=" + dosage + '}';
    }
    
    
    
}
