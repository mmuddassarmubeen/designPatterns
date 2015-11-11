/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Patient;

/**
 *
 * @author Muddassar
 */
public enum PatientStatus {
    ADMITTED("Undergoing Treatment"), NEW("Newly Admitted"),
        DISCHARGED("Discharged");
        
        private String value;
        
        private PatientStatus(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    
}
