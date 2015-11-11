/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Enterprise;

import healthcare.Department.Department;
import healthcare.Department.DepartmentDirectory;
import healthcare.Department.DepartmentType;
import healthcare.UserAccount.UserAccount;
import healthcare.WorkQueue.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public abstract class Enterprise extends Department{
    
    private EnterpriseType enterpriseType;
    private DepartmentDirectory departmentDirectory;
    
    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        departmentDirectory = new DepartmentDirectory();
    }
    
    public enum EnterpriseType{
        Hospital("Hospital"),
        Social("Socail Group"),
        PharmaceuticalCompany("Pharmaceutical Company");
        
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public DepartmentDirectory getDepartmentDirectory() {
        return departmentDirectory;
    }
    
    public Department getDepartment(DepartmentType type)
    {
        for(Department dept : this.departmentDirectory.getOrganizationList())
        {
            if(dept.getName().equals(type.getValue()))
            {
                return dept;
            }
        }
        return null;
    }
    
    public abstract ArrayList<DepartmentType> supportedDepartments();
    
    public boolean checkIfUsernameIsUnique(String username){
        boolean result = this.getUserAccountDirectory().checkIfUsernameIsUnique(username);
        for(Department dept : this.departmentDirectory.getOrganizationList())
        {
            result = result && dept.checkIfUsernameIsUnique(username);
        }
        return result;
    }
    
    public abstract void processCommunicationRequests(WorkRequest wr);
}
