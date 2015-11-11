/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Network;

import healthcare.CommunicationBroadcast.ICommunicationVisitor;
import healthcare.Enterprise.Enterprise;
import healthcare.Enterprise.Enterprise.EnterpriseType;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class SocialNetwork extends Network {

    @Override
    public ArrayList<Enterprise.EnterpriseType> supportedEnterpriseTypes() {
       ArrayList<EnterpriseType> enterprises = new ArrayList<EnterpriseType>(); 
       enterprises.add(EnterpriseType.Social);
       return enterprises;
    }

    @Override
    public void Add(Network network) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Remove(Network network) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Network> getChildNetworks() {
        return null;
    }

    @Override
    public void Accept(ICommunicationVisitor visitor) {
        
    }
    
    @Override
    public boolean checkIfUsernameIsUnique(String username) {
        boolean result = true;
        for(Enterprise ent : this.getEnterpriseDirectory().getEnterpriseList())
        {
            result = result && ent.checkIfUsernameIsUnique(username);
        }
        return result;
    }
    
}
