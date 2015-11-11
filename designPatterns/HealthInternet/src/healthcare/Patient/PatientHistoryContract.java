/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Patient;

import healthcare.Encounter.Allergies;
import healthcare.Encounter.AllergyHistory;
import healthcare.Encounter.Medication;
import healthcare.Encounter.MedicationHistory;
import healthcare.Encounter.SocialHabitSummary;
import healthcare.Encounter.SocialHabits;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class PatientHistoryContract {
    private AllergyHistory allergies;
    private SocialHabitSummary socialHabits;
    private MedicationHistory medicationHistory;
    
    public PatientHistoryContract()
    {
        this.allergies = new AllergyHistory();
        this.socialHabits = new SocialHabitSummary();
        this.medicationHistory = new MedicationHistory();
    }

    public AllergyHistory getAllergies() {
        return allergies;
    }

    public SocialHabitSummary getSocialHabits() {
        return socialHabits;
    }

    public MedicationHistory getMedicationHistory() {
        return medicationHistory;
    }
    
    
}
