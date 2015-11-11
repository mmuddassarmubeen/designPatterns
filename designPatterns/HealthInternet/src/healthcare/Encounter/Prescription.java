/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Encounter;

import healthcare.Drug.Drug;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class Prescription {
    
    private ArrayList<MedicationOrder> medicationList;
    
    public Prescription()
    {
        this.medicationList = new ArrayList<>();
    }
    
    public void addMedication(MedicationOrder order)
    {       
        this.medicationList.add(order);
    }

    public ArrayList<MedicationOrder> getMedicationList() {
        return medicationList;
    }
}
