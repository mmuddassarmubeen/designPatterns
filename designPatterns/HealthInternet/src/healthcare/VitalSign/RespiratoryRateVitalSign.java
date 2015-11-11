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
public class RespiratoryRateVitalSign extends VitalSign {
 
    public RespiratoryRateVitalSign(float value)
    {
        super("RespiratoryRate");
        this.setValue(value);
    }
}
