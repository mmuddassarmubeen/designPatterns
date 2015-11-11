/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Enterprise;

import healthcare.Department.Department;
import healthcare.Department.DepartmentType;
import healthcare.Department.SocialGroup;
import healthcare.Person.Person;
import healthcare.Role.Role;
import healthcare.Patient.Patient;
import healthcare.WorkQueue.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class PatientSocialEnterprise extends Enterprise {

    public PatientSocialEnterprise(String name) {
        super(name, EnterpriseType.Social);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<DepartmentType> supportedDepartments() {
        ArrayList<DepartmentType> departmentTypes = new ArrayList<>();
        departmentTypes.add(DepartmentType.Admin);
        departmentTypes.add(DepartmentType.SocailGroups);
        return departmentTypes;
    }

    @Override
    public Person createPerson(String name) {
        return this.getPersonDirectory().createPerson(name);
    }
    
    public void createSocailGroup(String name)
    {
        SocialGroup group = new SocialGroup();
        group.setName(name);
        this.getDepartmentDirectory().getOrganizationList().add(group);
    }

    @Override
    public void processCommunicationRequests(WorkRequest wr) {
        
    }
    
}
