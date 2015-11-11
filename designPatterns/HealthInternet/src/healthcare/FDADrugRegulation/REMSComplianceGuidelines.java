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
public abstract class REMSComplianceGuidelines {
    
   public abstract boolean complianceStatus(MedicationWorkRequest wr);
    
}
