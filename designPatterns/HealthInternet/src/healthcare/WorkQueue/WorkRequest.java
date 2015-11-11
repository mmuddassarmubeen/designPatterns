/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.WorkQueue;

import healthcare.Commons.WorkRequestStatusType;
import healthcare.Enterprise.Enterprise;
import healthcare.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Muddassar
 */
public abstract class WorkRequest {
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private WorkRequestStatusType status;
    private Date requestDate;
    private Date resolveDate;
    private Enterprise requestingEnterprise;
    
    public WorkRequest(){
        requestDate = new Date();
        this.status = WorkRequestStatusType.Created;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public WorkRequestStatusType getStatus() {
        return status;
    }

    public void setStatus(WorkRequestStatusType status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
    
    public Enterprise getRequestingEnterprise() {
        return requestingEnterprise;
    }

    public void setRequestingEnterprise(Enterprise enterprise) {
        this.requestingEnterprise = enterprise;
    }

    @Override
    public String toString() {
        return this.message; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
