/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Department;

/**
 *
 * @author Muddassar
 */
public enum DepartmentType {
    //Departments for Hospitals
    Admin("Admin Department"), Doctor("Doctor Department"),
        Lab("Lab Department"),Nurse("Nurse Department"),Patient("Patient Department"),
        Pharmacy("Pharmacy Department"),
        //Social Network Departments
        SocailGroups("Social Member Group"),
        //Regulatory Departments
        PharmaceuticalDrugRegulatoryDepartment("Pharmaceutical Drug Regulatory Department");
        
        private String value;
        
        private DepartmentType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    
}
