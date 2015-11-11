/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.WorkQueue;

import healthcare.Patient.Patient;
import healthcare.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Muddassar
 */
public class Message {
    
    private String message;
    private UserAccount postedBy;
    private Date postedTime;
    private int rating;
    
    public Message(String message, UserAccount postedBy, Date postedTime)
    {
        this.message = message;
        this.postedBy = postedBy;
        this.postedTime = postedTime;
        this.rating = 0;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public UserAccount getPostedBy() {
        return postedBy;
    }

    public Date getPostedTime() {
        return postedTime;
    }
    
    
    
    
    
}
