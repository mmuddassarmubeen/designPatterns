/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.WorkQueue;

import healthcare.Enterprise.Enterprise;
import healthcare.Patient.Patient;
import healthcare.Patient.SearchPatientContract;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class PatientProfileWorkRequest extends WorkRequest {
    
    private Patient patient;
    private SearchPatientContract searchPatientContract; 
    
    
    public PatientProfileWorkRequest(Enterprise enterprise)
    {
        this.setRequestingEnterprise(enterprise);
        this.searchPatientContract = new SearchPatientContract();
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public SearchPatientContract getSearchPatientContract() {
        return searchPatientContract;
    }
    
    
}
