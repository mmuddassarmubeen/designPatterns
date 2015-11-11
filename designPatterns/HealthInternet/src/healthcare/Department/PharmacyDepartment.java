/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Department;

import healthcare.Drug.DrugCatalog;
import healthcare.Person.Person;
import healthcare.Person.Pharmacist;
import healthcare.Role.PharmacyRole;
import healthcare.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class PharmacyDepartment extends Department {

    private DrugCatalog drugCatalog;
    
    public PharmacyDepartment() {
        super(DepartmentType.Pharmacy.getValue());
        this.drugCatalog = new DrugCatalog();
    }

    public DrugCatalog getDrugCatalog() {
        return drugCatalog;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PharmacyRole());
        return roles;
    }

    @Override
    public Person createPerson(String name) {
        Person person = new Pharmacist();
        person.setName(name);
        this.getPersonDirectory().getPersonList().add(person);
        return person;
    }
    
}
