/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Role;

import healthcare.Enterprise.Enterprise;
import healthcare.Department.Department;
import healthcare.Department.DepartmentType;
import healthcare.Department.DoctorDepartment;
import healthcare.Department.LabDepartment;
import healthcare.Department.PatientDepartment;
import healthcare.Department.PharmacyDepartment;
import healthcare.Ecosystem.EcoSystem;
import healthcare.Network.Network;
import healthcare.Network.PharmaceuticalCompaniesNetwork;
import healthcare.UserAccount.UserAccount;
import healthcare.UserInterface.DoctorWorkArea.DoctorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Muddassar
 */
public class DoctorRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Department organization, Enterprise enterprise, Network network, EcoSystem business) {
        return  new DoctorWorkAreaJPanel(userProcessContainer,account
                , (DoctorDepartment)enterprise.getDepartment(DepartmentType.Doctor)
                ,(LabDepartment)enterprise.getDepartment(DepartmentType.Lab)
                ,(PharmacyDepartment)enterprise.getDepartment(DepartmentType.Pharmacy)
                ,(PatientDepartment)enterprise.getDepartment(DepartmentType.Patient)
                ,business, enterprise);
    }
    
}
