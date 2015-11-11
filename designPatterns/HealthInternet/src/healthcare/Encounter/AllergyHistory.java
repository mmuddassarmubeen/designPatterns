/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Encounter;

import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class AllergyHistory {
    
    private ArrayList<Allergies> allergyList;

    public ArrayList<Allergies> getAllergyList() {
        return allergyList;
    }
    
    public AllergyHistory()
    {
        this.allergyList = new ArrayList<>();
    }
    
    public Allergies createAllergy()
    {
        Allergies allergy = new Allergies();
        this.allergyList.add(allergy);
        return allergy;
    }
        
}
