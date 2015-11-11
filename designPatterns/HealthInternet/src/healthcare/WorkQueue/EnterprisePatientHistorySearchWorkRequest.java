/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.WorkQueue;

/**
 *
 * @author Muddassar
 */
public class EnterprisePatientHistorySearchWorkRequest extends WorkRequest {
    
    private PatientHistoryWorkRequest patientHistoryWorkRequest;

    public EnterprisePatientHistorySearchWorkRequest(PatientHistoryWorkRequest wr)
    {
        this.patientHistoryWorkRequest = wr;
    }
    
    public PatientHistoryWorkRequest getPatientHistoryWorkRequest() {
        return patientHistoryWorkRequest;
    }

    public void setPatientHistoryWorkRequest(PatientHistoryWorkRequest patientHistoryWorkRequest) {
        this.patientHistoryWorkRequest = patientHistoryWorkRequest;
    }
    
    
    
}
