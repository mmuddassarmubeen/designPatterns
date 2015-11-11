/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.WorkQueue;

import healthcare.Encounter.MedicationOrder;
import healthcare.Patient.Patient;

/**
 *
 * @author Muddassar
 */
public class LabTestWorkRequest extends WorkRequest {
    
    private MedicationOrder order;

    public MedicationOrder getOrder() {
        return order;
    }

    public void setOrder(MedicationOrder order) {
        this.order = order;
    }

}
