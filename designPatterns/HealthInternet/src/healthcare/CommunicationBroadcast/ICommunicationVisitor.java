/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.CommunicationBroadcast;

import healthcare.Network.HospitalNetwork;
import healthcare.Network.Network;
import healthcare.Network.PharmaceuticalCompaniesNetwork;

/**
 *
 * @author Muddassar
 */
public interface ICommunicationVisitor {
    
    void Visit(HospitalNetwork network);
    void Visit(PharmaceuticalCompaniesNetwork network);
    
}
