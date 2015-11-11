/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.FDADrugRegulation;

import healthcare.Commons.DoctorSpecialtyType;
import static healthcare.Department.DepartmentType.Doctor;
import healthcare.Person.Doctor;
import healthcare.UserAccount.UserAccount;
import healthcare.WorkQueue.MedicationWorkRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Muddassar
 */
public class REMSElementsToAssureSafeUseGuideline extends REMSComplianceGuidelines {
    
    private List<DoctorSpecialtyType> approvedDoctorSpecialties;
    
    public REMSElementsToAssureSafeUseGuideline(List<DoctorSpecialtyType> specialties)
    {
        this.approvedDoctorSpecialties = specialties;
    }
    
    public boolean complianceStatus(MedicationWorkRequest wr)
    {
        UserAccount docAccount = wr.getSender();
        if(docAccount.getPerson() instanceof Doctor)
        {
            DoctorSpecialtyType type = ((Doctor)docAccount.getPerson()).getSpeciality();
            if(type == null)
            {
                return false;
            }
            else if (this.approvedDoctorSpecialties.contains(type))
            {
                return true;
            }
            
        }
        return false;
        
    }

    public List<DoctorSpecialtyType> getApprovedDoctorSpecialties() {
        return approvedDoctorSpecialties;
    }
    
    
    
}
