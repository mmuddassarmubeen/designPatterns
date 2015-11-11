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
import healthcare.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Muddassar
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("Admin"),
        Doctor("Doctor"),
        LabAssistant("Lab Assistant");
        
        private String value;
        private RoleType(String value){
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
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Department organization, Enterprise enterprise, Network network, EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
}
