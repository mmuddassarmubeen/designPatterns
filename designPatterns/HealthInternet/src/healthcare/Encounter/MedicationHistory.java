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
public class MedicationHistory {
    
    private ArrayList<MedicationOrder> medicationList;
    
    public MedicationHistory()
    {
        medicationList = new ArrayList<>();
    }

    public ArrayList<MedicationOrder> getMedicationList() {
        return medicationList;
    }
    
    
}
