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
public class LabTest extends Medication {
    
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    public LabTest(String name)
    {
        this.setName(name);
    }
}
