/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class PostMessageWorkRequest extends WorkRequest {
    
    private String title;
    private ArrayList<Message> messages;
    
    public PostMessageWorkRequest()
    {
        this.messages = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
    
    public void addMessage(Message message) {
        this.messages.add(message);
    }
    
    
   
}
