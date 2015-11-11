/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Ecosystem;

import healthcare.CommunicationBroadcast.ICommunicationVisitor;
import healthcare.Department.Department;
import healthcare.Person.Person;
import healthcare.Role.Role;
import healthcare.Role.SystemAdministratorRole;
import healthcare.Network.CompositeNetwork;
import healthcare.Network.HospitalNetwork;
import healthcare.Network.Network;
import healthcare.Network.Network.NetworkType;
import healthcare.Network.SocialNetwork;
import healthcare.UserAccount.UserAccount;
import healthcare.WorkQueue.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class EcoSystem extends Department {
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super("US");
        networkList = new ArrayList<>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork(String name) {
        Network network = new CompositeNetwork();
        networkList.add(network);
        return network;
    }
    
    public void removeNetwork(Network network)
    {
        this.networkList.remove(network);
    }

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdministratorRole());
        return roleList;
    }

    
    
    public void broadcastToHospitalEnterprisesWorkRequest(ICommunicationVisitor visitor)
    {
        for(Network network : this.networkList)
        {
            network.Accept(visitor);
        }
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        boolean result = this.getUserAccountDirectory().checkIfUsernameIsUnique(username);
        for(Network net : this.getNetworkList())
        {
            result = result && net.checkIfUsernameIsUnique(username);
        }
            
        return result;
    }

    @Override
    public Person createPerson(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
