/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Enterprise;

import healthcare.Commons.WorkRequestStatusType;
import healthcare.Department.DepartmentType;
import healthcare.Enterprise.Enterprise.EnterpriseType;
import healthcare.Person.Person;
import healthcare.Role.AdminRole;
import healthcare.Role.Role;
import healthcare.WorkQueue.EnterprisePatientHistorySearchWorkRequest;
import healthcare.WorkQueue.EnterprisePatientProfileSearchWorkRequest;
import healthcare.WorkQueue.PatientHistoryWorkRequest;
import healthcare.WorkQueue.PatientProfileWorkRequest;
import healthcare.WorkQueue.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class HospitalEnterprise extends Enterprise {
    
    public HospitalEnterprise(String name) {
        super(name, EnterpriseType.Hospital);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    @Override
    public ArrayList<DepartmentType> supportedDepartments() {
        ArrayList<DepartmentType> departmentTypes = new ArrayList<>();
        departmentTypes.add(DepartmentType.Admin);
        departmentTypes.add(DepartmentType.Doctor);
        departmentTypes.add(DepartmentType.Patient);
        departmentTypes.add(DepartmentType.Lab);
        departmentTypes.add(DepartmentType.Nurse);
        departmentTypes.add(DepartmentType.Pharmacy);
        return departmentTypes;
    }

    @Override
    public Person createPerson(String name) {
        return this.getPersonDirectory().createPerson(name);   
    }

    @Override
    public void processCommunicationRequests(WorkRequest request) {
        if(request instanceof PatientHistoryWorkRequest)
            {
                PatientHistoryWorkRequest workRequest = (PatientHistoryWorkRequest)request;
                EnterprisePatientHistorySearchWorkRequest historyWorkRequest = 
                        new EnterprisePatientHistorySearchWorkRequest(workRequest);
                historyWorkRequest.setMessage("Enterprise level search");
                this.getWorkQueue().getWorkRequestList().add(historyWorkRequest);
                
            }
        
        else if(request instanceof PatientProfileWorkRequest)
            {
                PatientProfileWorkRequest workRequest = (PatientProfileWorkRequest)request;
                EnterprisePatientProfileSearchWorkRequest historyWorkRequest = 
                        new EnterprisePatientProfileSearchWorkRequest(workRequest);
                historyWorkRequest.setMessage("Enterprise level search");
                this.getWorkQueue().getWorkRequestList().add(historyWorkRequest);
            }
    }
    
}
