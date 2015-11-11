/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Encounter;

import healthcare.VitalSign.VitalSignSummary;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Muddassar
 */
public class Encounter {
    
    private Date timeStamp;
    private Diagnosis diagnosis;
    private VitalSignSummary vitalSignSummary;
    private AssessmentSummary assessmentSummary;
    private Treatment treatment;
    private Prescription prescription;
    private String ChiefComplaint;
    private EncounterStatus status;
    

    public Encounter()
    {
        this.diagnosis = new Diagnosis();
        this.vitalSignSummary = new VitalSignSummary();
        this.assessmentSummary = new AssessmentSummary();
        this.prescription = new Prescription();
        this.treatment = new Treatment();
        this.timeStamp = new Date();
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public VitalSignSummary getVitalSignSummary() {
        return vitalSignSummary;
    }

    public void setVitalSignSummary(VitalSignSummary vitalSigns) {
        this.vitalSignSummary = vitalSigns;
    }

    public AssessmentSummary getAssessment() {
        return assessmentSummary;
    }

    public void setAssessment(AssessmentSummary assessment) {
        this.assessmentSummary = assessment;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public Prescription getPrescription() {
        return prescription;
    }
    
    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public String getChiefComplaint() {
        return ChiefComplaint;
    }

    public void setChiefComplaint(String ChiefComplaint) {
        this.ChiefComplaint = ChiefComplaint;
    }

    public EncounterStatus getStatus() {
        return status;
    }

    public void setStatus(EncounterStatus status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return this.timeStamp.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
