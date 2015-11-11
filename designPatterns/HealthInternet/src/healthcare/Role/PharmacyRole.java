/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Role;

import healthcare.Department.Department;
import healthcare.Department.DepartmentType;
import healthcare.Department.PharmacyDepartment;
import healthcare.Enterprise.Enterprise;
import healthcare.Ecosystem.EcoSystem;
import healthcare.Network.Network;
import healthcare.Network.PharmaceuticalCompaniesNetwork;
import healthcare.UserAccount.UserAccount;
import healthcare.UserInterface.PharmacyWorkArea.PharmacyWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author Muddassar
 */
public class PharmacyRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Department organization, Enterprise enterprise, Network network, EcoSystem business) {
        PharmaceuticalCompaniesNetwork pharmaCompaniesNetwork = null;
        for(Network net : business.getNetworkList())
        {
            if(net instanceof PharmaceuticalCompaniesNetwork)
            {
                pharmaCompaniesNetwork = (PharmaceuticalCompaniesNetwork)net;
            }
        }
        return new PharmacyWorkArea(userProcessContainer,account, (PharmacyDepartment)enterprise.getDepartment(DepartmentType.Pharmacy),pharmaCompaniesNetwork);
    }
    
}
