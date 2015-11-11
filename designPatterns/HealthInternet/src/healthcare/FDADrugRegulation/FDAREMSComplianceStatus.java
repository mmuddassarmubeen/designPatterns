/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.FDADrugRegulation;

/**
 *
 * @author Muddassar
 */
public enum FDAREMSComplianceStatus {
    
    Compliant("Compliant"), NonCompliant("NonCompliant");
        
        private String value;
        
        private FDAREMSComplianceStatus(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
}
