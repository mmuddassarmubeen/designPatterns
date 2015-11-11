/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Drug;

import healthcare.FDADrugRegulation.FDAREMSComplianceStatus;
import healthcare.FDADrugRegulation.REMSComplianceGuidelines;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Muddassar
 */
public class REMSDrugComplianceGuidelines {
    
    private ArrayList<REMSComplianceGuidelines> complianceGuidelines;
    
    public REMSDrugComplianceGuidelines()
    {
        this.complianceGuidelines = new ArrayList<>();
    }

    public ArrayList<REMSComplianceGuidelines> getComplianceGuidelines() {
        return complianceGuidelines;
    }
    
    
    
    public void addDrugComplianceGuideline(REMSComplianceGuidelines guideline)
    {
        this.complianceGuidelines.add(guideline);
    }
}
