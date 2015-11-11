/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Network;

import healthcare.Enterprise.Enterprise.EnterpriseType;
import healthcare.Network.Network.NetworkType;

/**
 *
 * @author Muddassar
 */
public class NetworkFactory {
    
    public static Network createNetwork(NetworkType type)
    {
        Network network = null;
        if(type.equals(NetworkType.Hospital))
        {
            network = new HospitalNetwork();
        }
        else if(type.equals(NetworkType.SocialNetwork))
        {
            network = new SocialNetwork();
        }
        else if(type.equals(NetworkType.PharmaceuticalCompanyNetwork))
        {
            network = new PharmaceuticalCompaniesNetwork();
        }
        return network;
    }
    
}
