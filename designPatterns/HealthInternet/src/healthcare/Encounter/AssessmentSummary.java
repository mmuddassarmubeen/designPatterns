/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Encounter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Muddassar
 */
public class AssessmentSummary {
    
    private ArrayList<Assessment> assessmentList;
    
    public AssessmentSummary()
    {
        this.assessmentList = new ArrayList<>();
    }
    
    public Assessment addAssessment()
    {
        Assessment assessment = new Assessment();
        this.assessmentList.add(assessment);
        return assessment;
    }

    public ArrayList<Assessment> getAssessmentList() {
        return assessmentList;
    }
    
}
