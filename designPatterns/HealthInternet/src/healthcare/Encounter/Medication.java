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
public abstract class Medication {
    private String name;

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }
    
    public enum MedicationType{
    
        LabTest("Lab Test"),Drug("Drug");
        
        private String value;
        
        private MedicationType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    @Override
    public String toString() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
