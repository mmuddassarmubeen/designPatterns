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
public class PastMedicalHistory {
    
    private ArrayList<MedicalCondition> medicalConditionList;
    
    public PastMedicalHistory()
    {
        this.medicalConditionList = new ArrayList<>();
    }
    
    public MedicalCondition addMedicalCondition()
    {
        MedicalCondition condition = new MedicalCondition();
        this.medicalConditionList.add(condition);
        return condition;
    }
}
