/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.VitalSign;

/**
 *
 * @author Muddassar
 */
public enum VitalSignStatus {
    Normal("Normal"), Abnormal("Abnormal");
        
        private String value;
        
        private VitalSignStatus(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    
}
