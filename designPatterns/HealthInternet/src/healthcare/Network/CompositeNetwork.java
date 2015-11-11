/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Network;

import healthcare.CommunicationBroadcast.ICommunicationVisitor;
import healthcare.Enterprise.Enterprise;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class CompositeNetwork extends Network {

    private ArrayList<Network> networkList = new ArrayList<>();
    
    public CompositeNetwork()
    {
        this.networkList = new ArrayList<>();
    }
    @Override
    public ArrayList<Enterprise.EnterpriseType> supportedEnterpriseTypes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Add(Network network) {
        networkList.add(network);
    }

    @Override
    public void Remove(Network network) {
        networkList.remove(network);
    }

    @Override
    public ArrayList<Network> getChildNetworks() {
        return this.networkList;
    }

    @Override
    public void Accept(ICommunicationVisitor visitor) {
        for(Network net : this.networkList)
        {
            net.Accept(visitor);
        }
    }

    @Override
    public boolean checkIfUsernameIsUnique(String username) {
        boolean result = true;
        for(Network net : this.networkList)
        {
            result = result && net.checkIfUsernameIsUnique(username);
        }
        return result;
    }
    
}
