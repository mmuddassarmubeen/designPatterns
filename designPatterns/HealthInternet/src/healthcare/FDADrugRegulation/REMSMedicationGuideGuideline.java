/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.FDADrugRegulation;

import healthcare.WorkQueue.MedicationWorkRequest;

/**
 *
 * @author Muddassar
 */
public class REMSMedicationGuideGuideline extends REMSComplianceGuidelines{
    
    private int age;
    private int dosage;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int quantity) {
        this.dosage = quantity;
    }
    
    public boolean complianceStatus(MedicationWorkRequest wr)
    {
        if(wr.getMedicationOrder().getDosage() <= this.getDosage() 
                && wr.getPatient().getAge() >= this.age)
        {
            return true;
        }
        return false;
    }
    
}
