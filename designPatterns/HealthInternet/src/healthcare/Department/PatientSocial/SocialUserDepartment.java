/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Department.PatientSocial;

import healthcare.Department.Department;
import healthcare.Department.DepartmentType;
import healthcare.Person.Person;
import healthcare.Role.PatientRole;
import healthcare.Role.Role;
import healthcare.Patient.Patient;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class SocialUserDepartment extends Department {

    private SocialGroupDirectory groupsDirectory;
    
    public SocialUserDepartment() {
        super(DepartmentType.SocailGroups.getValue());
        this.groupsDirectory = new SocialGroupDirectory();
    }

    public SocialGroupDirectory getGroupsDirectory() {
        return groupsDirectory;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PatientRole());
        return roles;
    }

    @Override
    public Person createPerson(String name) {
        Person person = new Patient();
        person.setName(name);
        this.getPersonDirectory().getPersonList().add(person);
        return person;
        
    }
    
}
