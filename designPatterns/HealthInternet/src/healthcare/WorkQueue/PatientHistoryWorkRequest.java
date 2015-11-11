/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.WorkQueue;

import healthcare.Enterprise.Enterprise;
import healthcare.Patient.PatientHistoryContract;
import healthcare.Patient.SearchPatientContract;

/**
 *
 * @author Muddassar
 */
public class PatientHistoryWorkRequest extends WorkRequest {
    private PatientHistoryContract patientHistoryContract; 
    
    public PatientHistoryWorkRequest(Enterprise enterprise)
    {
        this.setRequestingEnterprise(enterprise);
        this.patientHistoryContract = new PatientHistoryContract();
    }
    
    public PatientHistoryContract getPatientHistoryContract() {
        return patientHistoryContract;
    }

    public void setPatientHistoryContract(PatientHistoryContract searchPatientContract) {
        this.patientHistoryContract = searchPatientContract;
    }
    
}
