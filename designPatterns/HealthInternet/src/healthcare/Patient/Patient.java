/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Patient;

import healthcare.Person.Person;
import healthcare.Encounter.AllergyHistory;
import healthcare.Encounter.Encounter;
import healthcare.Encounter.EncounterHistory;
import healthcare.Encounter.MedicationHistory;
import healthcare.Encounter.MedicationOrder;
import healthcare.Encounter.PastMedicalHistory;
import healthcare.Encounter.SocialHabitSummary;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class Patient extends Person {
    
    private EncounterHistory encounterHistory;
    private AllergyHistory allergyHistory;
    private SocialHabitSummary socialHabitSummary;
    private PastMedicalHistory medicalHistory;
    private PatientStatus status;
    private Encounter currentEncounter;

    public Patient()
    {
        this.encounterHistory = new EncounterHistory();
        this.allergyHistory = new AllergyHistory();
        this.socialHabitSummary = new SocialHabitSummary();
        this.medicalHistory = new PastMedicalHistory();
        this.status = PatientStatus.NEW;
    }
    
    public PatientStatus getStatus() {
        return status;
    }

    public void setStatus(PatientStatus status) {
        this.status = status;
    }

    public EncounterHistory getEncounterHistory() {
        return encounterHistory;
    }

    public ArrayList<MedicationOrder> getMedicationHistory() {
        ArrayList<MedicationOrder> medicationOrders = new ArrayList<>();
        for(Encounter encounter : this.encounterHistory.getEncounterList())
        {
            medicationOrders.addAll(encounter.getPrescription().getMedicationList());
        }
        return medicationOrders;
    }

    public AllergyHistory getAllergyHistory() {
        return allergyHistory;
    }

    public SocialHabitSummary getSocialHabitSummary() {
        return socialHabitSummary;
    }

    public PastMedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public Encounter getCurrentEncounter() {
        if(currentEncounter == null)
        {
            currentEncounter = addEncounter();
        }
        return currentEncounter;
    }
    
    public Encounter addEncounter()
    {
        this.currentEncounter = this.encounterHistory.addEncounter();
        return this.currentEncounter;
    }
    
    public void dischargePatient()
    {
        this.status = PatientStatus.DISCHARGED;
        this.currentEncounter = null;
    }
    
}
