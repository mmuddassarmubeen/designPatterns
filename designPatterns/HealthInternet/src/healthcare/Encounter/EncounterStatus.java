/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Encounter;

/**
 *
 * @author Muddassar
 */
public enum EncounterStatus {
    Sensitive("Sensitive"), Public("Public");
        
        private String value;
        
        private EncounterStatus(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    
}
