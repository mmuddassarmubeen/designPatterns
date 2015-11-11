/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Role;

import healthcare.Enterprise.Enterprise;
import healthcare.Department.Department;
import healthcare.Ecosystem.EcoSystem;
import healthcare.Network.Network;
import healthcare.UserInterface.SystemAdministratorWorkArea.SystemAdministratorWorkAreaJPanel;
import healthcare.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Muddassar
 */
public class SystemAdministratorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Department organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new SystemAdministratorWorkAreaJPanel(userProcessContainer, business);
    }
    
}
