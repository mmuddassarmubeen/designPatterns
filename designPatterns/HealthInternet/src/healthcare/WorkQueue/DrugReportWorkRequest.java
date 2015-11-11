/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.WorkQueue;

import healthcare.Drug.Drug;
import healthcare.Enterprise.Enterprise;

/**
 *
 * @author Muddassar
 */
public class DrugReportWorkRequest extends WorkRequest {
    
    private Drug drug;
    private String drugReport;
    
    public DrugReportWorkRequest(Enterprise enterprise)
    {
        this.setRequestingEnterprise(enterprise);
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public String getDrugReport() {
        return drugReport;
    }

    public void setDrugReport(String drugReport) {
        this.drugReport = drugReport;
    }
}
