/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Department;

import healthcare.Person.Doctor;
import healthcare.Person.Person;
import healthcare.Role.DoctorRole;
import healthcare.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class DoctorDepartment extends Department {

    public DoctorDepartment() {
        super(DepartmentType.Doctor.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DoctorRole());
        return roles;
    }

    @Override
    public Person createPerson(String name) {
        Person person = new Doctor();
        person.setName(name);
        this.getPersonDirectory().getPersonList().add(person);
        return person;
    }
    
}
