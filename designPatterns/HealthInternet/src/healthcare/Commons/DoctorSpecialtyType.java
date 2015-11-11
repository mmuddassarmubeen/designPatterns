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
public enum DoctorSpecialtyType {
    
    Cardiologist("Cardiology"), Dentists("Dentists"),
        Immunologists("Immunologists"),Psychiatrists("Psychiatrists");
        
        private String value;
        
        private DoctorSpecialtyType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    
}
