/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.WorkQueue;

import healthcare.Drug.Drug;
import healthcare.Encounter.Medication;
import healthcare.Encounter.MedicationOrder;
import healthcare.Patient.Patient;

/**
 *
 * @author Muddassar
 */
public class MedicationWorkRequest extends WorkRequest {
    private Patient patient;
    private MedicationOrder medicationOrder;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public MedicationOrder getMedicationOrder() {
        return medicationOrder;
    }

    public void setMedicationOrder(MedicationOrder medication) {
        this.medicationOrder = medication;
    }
    
    
}
