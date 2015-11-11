/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Department;

import healthcare.Department.PatientSocial.SocialUserDepartment;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class DepartmentDirectory {
    
    private ArrayList<Department> departmentList;

    public DepartmentDirectory() {
        departmentList = new ArrayList<>();
    }

    public ArrayList<Department> getOrganizationList() {
        return departmentList;
    }
    
    public Department createOrganization(DepartmentType type){
        Department department = null;
        if (type.getValue().equals(DepartmentType.Doctor.getValue())){
            department = new DoctorDepartment();
            departmentList.add(department);
        }
        else if (type.getValue().equals(DepartmentType.Lab.getValue())){
            department = new LabDepartment();
            departmentList.add(department);
        }
        else if (type.getValue().equals(DepartmentType.Nurse.getValue())){
            department = new NurseDepartment();
            departmentList.add(department);
        }
        else if (type.getValue().equals(DepartmentType.Patient.getValue())){
            department = new PatientDepartment();
            departmentList.add(department);
        }
        else if (type.getValue().equals(DepartmentType.Pharmacy.getValue())){
            department = new PharmacyDepartment();
            departmentList.add(department);
        }
        else if (type.getValue().equals(DepartmentType.SocailGroups.getValue())){
            department = new SocialUserDepartment();
            departmentList.add(department);
        }
        else if (type.getValue().equals(DepartmentType.PharmaceuticalDrugRegulatoryDepartment.getValue())){
            department = new PharmaceuticalDrugRegulatoryDepartment();
            departmentList.add(department);
        }
        
        return department;
    }
    
    
}
