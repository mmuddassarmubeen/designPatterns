/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Patient;

import healthcare.Encounter.Allergies;
import healthcare.Encounter.Encounter;
import healthcare.Encounter.SocialHabits;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class SearchPatientContract {
    
    private ArrayList<Encounter> encounterList;
    private ArrayList<Allergies> allergies;
    private ArrayList<SocialHabits> socialHabits;
    
    public SearchPatientContract()
    {
        this.encounterList = new ArrayList<>();
        this.allergies = new ArrayList<>();
        this.socialHabits = new ArrayList<>();
    }

    public ArrayList<Encounter> getEncounterList() {
        return encounterList;
    }

    public ArrayList<Allergies> getAllergies() {
        return allergies;
    }

    public ArrayList<SocialHabits> getSocialHabits() {
        return socialHabits;
    }
    
    public void addEncounter(Encounter encounter)
    {
        this.encounterList.add(encounter);
    }
    
    public void addAllergies(ArrayList<Allergies> allergy)
    {
        this.allergies.addAll(allergy);
    }
    
    public void addSocialHabits(ArrayList<SocialHabits> habit)
    {
        this.socialHabits.addAll(habit);
    }
    
}
