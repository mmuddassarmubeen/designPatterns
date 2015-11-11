/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserAccount;

import healthcare.DB4OUtil.DB4OUtil;
import healthcare.Ecosystem.EcoSystem;
import healthcare.Network.Network;
import healthcare.Person.Person;
import healthcare.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;
    

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
        
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Person person, Role role){
        if(globalCheckIfUsernameIsUnique(username))
        {
            UserAccount userAccount = new UserAccount();
            userAccount.setUsername(username);
            userAccount.setPassword(password);
            userAccount.setPerson(person);
            userAccount.setRole(role);
            userAccountList.add(userAccount);
            return userAccount;
        }
        return null;
    }
    
    public boolean globalCheckIfUsernameIsUnique(String username){
        //DB4OUtil dB4OUtil = DB4OUtil.getInstance();
        EcoSystem system = EcoSystem.getInstance();
        return system.checkIfUsernameIsUnique(username);
    }
    
   public boolean checkIfUsernameIsUnique(String username){
        for(UserAccount account : this.userAccountList)
        {
            if(account.getUsername().equals(username))
            {
                return false;
            }
        }
        return true;
   }
    
    
}
