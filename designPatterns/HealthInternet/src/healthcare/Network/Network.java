/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Network;

import healthcare.CommunicationBroadcast.ICommunicationVisitor;
import healthcare.Enterprise.Enterprise;
import healthcare.Enterprise.Enterprise.EnterpriseType;
import healthcare.Enterprise.EnterpriseDirectory;
import healthcare.UserAccount.UserAccount;
import healthcare.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Muddassar
 */
public abstract class Network {

    private String name;
    private EnterpriseDirectory enterpriseDirectory;

    public Network() {
        this.enterpriseDirectory = new EnterpriseDirectory();
    }

    public enum NetworkType {

        Hospital("Hospital Network"), SocialNetwork("Social Network"), PharmaceuticalCompanyNetwork("Pharmaceutical Company Network");
        private String value;

        private NetworkType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract ArrayList<EnterpriseType> supportedEnterpriseTypes();

    public abstract void Add(Network network);

    public abstract void Remove(Network network);
    
    public abstract ArrayList<Network> getChildNetworks();
    
    public abstract void Accept(ICommunicationVisitor visitor);
    
    public abstract boolean checkIfUsernameIsUnique(String username);

    @Override
    public String toString() {
        return name;
    }

}
