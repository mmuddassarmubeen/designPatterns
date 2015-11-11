/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Department;

import healthcare.Patient.Patient;
import healthcare.Person.Person;
import healthcare.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class PatientDepartment extends Department {

    public PatientDepartment()
    {
        super(DepartmentType.Patient.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    @Override
    public Person createPerson(String name) {
        Person person = new Patient();
        person.setName(name);
        this.getPersonDirectory().getPersonList().add(person);
        return person;
    }
    
}
