/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.VitalSign;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Muddassar
 */
public class VitalSignSummary {
    
    private HashMap<VitalSign,VitalSignStatus> vitalSigns;
    private VitalSignStatus vitalSignStatus;
    
    public VitalSignSummary()
    {
        this.vitalSigns = new HashMap<>();
    }
    
    public void addVitalSignSummary(float heartrate, float respirationrate
            , float systolicbloodpressure, float weight, float age)
    {
        if(age>=1 && age<=3)
        {
            this.vitalSigns = toddlerVitalSign(heartrate, respirationrate, systolicbloodpressure, weight);
        }
        else if(age>=4 && age<=5)
        {
            this.vitalSigns = preSchoolerVitalSign(heartrate, respirationrate, systolicbloodpressure, weight);
        }
        else if(age>=6 && age<=12)
        {
            this.vitalSigns = schoolAgeVitalSign(heartrate, respirationrate, systolicbloodpressure, weight);
        }
        else if(age>=13)
        {
            this.vitalSigns = adolescentVitalSign(heartrate, respirationrate, systolicbloodpressure, weight);
        }
        for(Map.Entry<VitalSign,VitalSignStatus> map : this.vitalSigns.entrySet())
        {
            if(map.getValue().equals(VitalSignStatus.Abnormal))
            {
                this.vitalSignStatus = VitalSignStatus.Abnormal;
                break;
            }
        }
    }
    
    private HashMap<VitalSign,VitalSignStatus> toddlerVitalSign(float heartrate, float respirationrate
            , float systolicbloodpressure, float weight)
    {
        VitalSign vitalSign = null;
        HashMap<VitalSign,VitalSignStatus> result = new HashMap<>();
        vitalSign = new HeartRateVitalSign(heartrate);
        if(heartrate>=80 && heartrate<=130)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        vitalSign = new RespiratoryRateVitalSign(respirationrate);
        if(respirationrate>=20 && respirationrate<=30)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        vitalSign = new SystolicBloodPressure(systolicbloodpressure);
        if(systolicbloodpressure>=80 && systolicbloodpressure<=110)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        vitalSign = new WeightVitalSign(weight);
        if(weight>=22 && weight<=31)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        return result;
    }
    
    private HashMap<VitalSign,VitalSignStatus> preSchoolerVitalSign(float heartrate, float respirationrate
            , float systolicbloodpressure, float weight)
    {
        VitalSign vitalSign = null;
        HashMap<VitalSign,VitalSignStatus> result = new HashMap<>();
        vitalSign = new HeartRateVitalSign(heartrate);
        if(heartrate>=80 && heartrate<=120)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        vitalSign = new RespiratoryRateVitalSign(respirationrate);
        if(respirationrate>=20 && respirationrate<=30)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        vitalSign = new SystolicBloodPressure(systolicbloodpressure);
        if(systolicbloodpressure>=80 && systolicbloodpressure<=110)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        vitalSign = new WeightVitalSign(weight);
        if(weight>=31 && weight<=40)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        return result;
    }

    private HashMap<VitalSign,VitalSignStatus> schoolAgeVitalSign(float heartrate, float respirationrate
            , float systolicbloodpressure, float weight)
    {
        VitalSign vitalSign = null;
        HashMap<VitalSign,VitalSignStatus> result = new HashMap<>();
        vitalSign = new HeartRateVitalSign(heartrate);
        if(heartrate>=70 && heartrate<=110)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        vitalSign = new RespiratoryRateVitalSign(respirationrate);
        if(respirationrate>=20 && respirationrate<=30)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        vitalSign = new SystolicBloodPressure(systolicbloodpressure);
        if(systolicbloodpressure>=80 && systolicbloodpressure<=120)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        vitalSign = new WeightVitalSign(weight);
        if(weight>=41 && weight<=92)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        return result;
    }
    
    
    private HashMap<VitalSign,VitalSignStatus> adolescentVitalSign(float heartrate, float respirationrate
            , float systolicbloodpressure, float weight)
    {
        VitalSign vitalSign = null;
        HashMap<VitalSign,VitalSignStatus> result = new HashMap<>();
        vitalSign = new HeartRateVitalSign(heartrate);
        if(heartrate>=55 && heartrate<=105)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        vitalSign = new RespiratoryRateVitalSign(respirationrate);
        if(respirationrate>=12 && respirationrate<=20)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        vitalSign = new SystolicBloodPressure(systolicbloodpressure);
        if(systolicbloodpressure>=110 && systolicbloodpressure<=120)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        vitalSign = new WeightVitalSign(weight);
        if(weight>110)
        {
            result.put(vitalSign, vitalSignStatus.Normal);
        }
        else{
            result.put(vitalSign, vitalSignStatus.Abnormal);
        }
        return result;
    }

    public HashMap<VitalSign, VitalSignStatus> getVitalSigns() {
        return vitalSigns;
    }

    public VitalSignStatus getVitalSignStatus() {
        return vitalSignStatus;
    }
}
