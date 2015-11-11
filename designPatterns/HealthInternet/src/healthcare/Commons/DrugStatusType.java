/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Commons;

/**
 *
 * @author Muddassar
 */
public enum DrugStatusType {
    
    Normal("Normal"), Alert("Alert"),
        AtRisk("AtRisk"),Banned("Banned");
        
        private String value;
        
        private DrugStatusType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    
}
