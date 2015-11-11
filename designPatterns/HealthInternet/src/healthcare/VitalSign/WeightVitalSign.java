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
public class WeightVitalSign extends VitalSign {
    
    public WeightVitalSign(float value)
    {
        super("Weight");
        this.setValue(value);
    }
}
