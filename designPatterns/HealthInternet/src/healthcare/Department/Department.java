/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Department;

import healthcare.Person.Person;
import healthcare.Person.PersonDirectory;
import healthcare.Role.Role;
import healthcare.UserAccount.UserAccountDirectory;
import healthcare.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public abstract class Department {
    
    private String name;
    private WorkQueue workQueue;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int departmentID;
    private static int counter;
    
    

    public Department(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        departmentID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    public abstract Person createPerson(String name);
    
    public boolean checkIfUsernameIsUnique(String username){
        return this.userAccountDirectory.checkIfUsernameIsUnique(username);
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
