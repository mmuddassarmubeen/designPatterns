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
public class EnterprisePatientProfileSearchWorkRequest extends WorkRequest {
    
    private PatientProfileWorkRequest patientProfileWorkRequest;

    public EnterprisePatientProfileSearchWorkRequest(PatientProfileWorkRequest wr)
    {
        this.patientProfileWorkRequest = wr;
    }
    
    public PatientProfileWorkRequest getPatientProfileWorkRequest() {
        return patientProfileWorkRequest;
    }

    public void setPatientProfileWorkRequest(PatientProfileWorkRequest patientProfileWorkRequest) {
        this.patientProfileWorkRequest = patientProfileWorkRequest;
    }
    
}
