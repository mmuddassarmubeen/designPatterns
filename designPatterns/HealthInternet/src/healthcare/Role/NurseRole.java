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
import healthcare.Department.PatientDepartment;
import healthcare.Department.SocialGroup;
import healthcare.Ecosystem.EcoSystem;
import healthcare.Network.Network;
import healthcare.Network.SocialNetwork;
import healthcare.UserAccount.UserAccount;
import healthcare.UserInterface.NurseWorkArea.NurseWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Muddassar
 */
public class NurseRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Department organization, Enterprise enterprise, Network network, EcoSystem business) {
        return  new NurseWorkAreaJPanel(userProcessContainer,account, (PatientDepartment)enterprise.getDepartment(DepartmentType.Patient),(DoctorDepartment)enterprise.getDepartment(DepartmentType.Doctor),enterprise);
    }
    
}
