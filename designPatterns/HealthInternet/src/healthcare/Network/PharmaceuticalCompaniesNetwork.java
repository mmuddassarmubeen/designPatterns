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
public class PharmaceuticalCompaniesNetwork extends Network {

    @Override
    public ArrayList<Enterprise.EnterpriseType> supportedEnterpriseTypes() {
       ArrayList<Enterprise.EnterpriseType> enterprises = new ArrayList<Enterprise.EnterpriseType>(); 
       enterprises.add(Enterprise.EnterpriseType.PharmaceuticalCompany);
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
        visitor.Visit(this);
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
