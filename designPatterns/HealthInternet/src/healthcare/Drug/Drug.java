/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Drug;

import healthcare.Commons.DrugStatusType;
import healthcare.Encounter.Medication;
import healthcare.FDADrugRegulation.FDAREMSComplianceStatus;
import healthcare.Role.FDADrugRegulator;
import java.util.Date;

/**
 *
 * @author Muddassar
 */
public class Drug extends Medication {

    
    private String manufacturer;
    private REMSDrugComplianceGuidelines medicationGuidelines;
    private String drugStatus;
    

    public Drug(String name)
    {
        this.setName(name);
        this.medicationGuidelines = new REMSDrugComplianceGuidelines();
        drugStatus = DrugStatusType.Normal.getValue();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
   
    public REMSDrugComplianceGuidelines getMedicationGuidelines() {
        return medicationGuidelines;
    }

    public String getDrugStatus() {
        return drugStatus;
    }

    public void setDrugStatus(String drugStatus) {
        this.drugStatus = drugStatus;
    }
    
    

}
