/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Role;

import healthcare.Department.Department;
import healthcare.Department.DepartmentType;
import healthcare.Department.PharmaceuticalDrugRegulatoryDepartment;
import healthcare.Enterprise.Enterprise;
import healthcare.Ecosystem.EcoSystem;
import healthcare.Network.Network;
import healthcare.UserAccount.UserAccount;
import healthcare.UserInterface.PharmaceuticalDrugRegulatorWorkArea.PharmaceuticalDrugRegulatorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Muddassar
 */
public class FDADrugRegulator extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Department organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new PharmaceuticalDrugRegulatorWorkAreaJPanel(userProcessContainer, (PharmaceuticalDrugRegulatoryDepartment)enterprise.getDepartment(DepartmentType.PharmaceuticalDrugRegulatoryDepartment),account, enterprise);
    }
    
}
