/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Enterprise;

import healthcare.Department.DepartmentType;
import healthcare.Person.Person;
import healthcare.Role.Role;
import healthcare.WorkQueue.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class PharmaceuticalEnterprise extends Enterprise {

    public PharmaceuticalEnterprise(String name) {
        super(name, EnterpriseType.PharmaceuticalCompany);
    }
    
    @Override
    public ArrayList<DepartmentType> supportedDepartments() {
        ArrayList<DepartmentType> departmentTypes = new ArrayList<>();
        departmentTypes.add(DepartmentType.PharmaceuticalDrugRegulatoryDepartment);
        return departmentTypes;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person createPerson(String name) {
        return this.getPersonDirectory().createPerson(name);
    }

    @Override
    public void processCommunicationRequests(WorkRequest wr) {
        
    }
    
}
