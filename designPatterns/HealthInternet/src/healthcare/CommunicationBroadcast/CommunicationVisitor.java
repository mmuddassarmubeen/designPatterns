/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.CommunicationBroadcast;

import healthcare.Enterprise.Enterprise;
import healthcare.Network.HospitalNetwork;
import healthcare.Network.Network;
import healthcare.Network.PharmaceuticalCompaniesNetwork;
import healthcare.WorkQueue.DrugReportWorkRequest;
import healthcare.WorkQueue.PatientHistoryWorkRequest;
import healthcare.WorkQueue.PatientProfileWorkRequest;
import healthcare.WorkQueue.WorkRequest;

/**
 *
 * @author Muddassar
 */
public class CommunicationVisitor implements ICommunicationVisitor {

    private WorkRequest workRequest = null;

    public WorkRequest getWorkRequest() {
        return workRequest;
    }

    public void setWorkRequest(WorkRequest workRequest) {
        this.workRequest = workRequest;
    }
    
    @Override
    public void Visit(HospitalNetwork network) {
        if((this.workRequest instanceof PatientProfileWorkRequest) || (this.workRequest instanceof PatientHistoryWorkRequest))
        {
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList())
            {
                if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Hospital) && ( workRequest.getRequestingEnterprise() == null || !enterprise.getName().equals(workRequest.getRequestingEnterprise().getName()))) //&& )
                {
                    enterprise.processCommunicationRequests(workRequest);
                }
            }
        }
    }

    @Override
    public void Visit(PharmaceuticalCompaniesNetwork network) {
        if(this.workRequest instanceof DrugReportWorkRequest)
        {
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList())
            {
                if(enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.PharmaceuticalCompany) && !enterprise.getName().equals(workRequest.getRequestingEnterprise().getClass()))
                {
                    enterprise.getWorkQueue().getWorkRequestList().add(workRequest);
                }
            }
        }
    }
    
}
