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
public class SystolicBloodPressure extends VitalSign {
    
    public SystolicBloodPressure(float value)
    {
        super("SystolicBloodPressure");
        this.setValue(value);
    }
    
}
