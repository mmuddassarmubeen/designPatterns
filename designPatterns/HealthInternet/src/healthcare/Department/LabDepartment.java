/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Department;

import healthcare.Person.LabAssistant;
import healthcare.Person.Person;
import healthcare.Role.LabAssistantRole;
import healthcare.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class LabDepartment extends Department {

    public LabDepartment() {
        super(DepartmentType.Lab.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LabAssistantRole());
        return roles;
    }

    @Override
    public Person createPerson(String name) {
        Person person = new LabAssistant();
        person.setName(name);
        this.getPersonDirectory().getPersonList().add(person);
        return person;
    }
    
}
