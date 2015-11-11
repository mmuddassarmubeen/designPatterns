/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Department;

import healthcare.Drug.Drug;
import healthcare.Drug.DrugCatalog;
import healthcare.Person.FDAOfficial;
import healthcare.Person.Person;
import healthcare.Role.FDADrugRegulator;
import healthcare.Role.Role;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Muddassar
 */
public class PharmaceuticalDrugRegulatoryDepartment extends Department{

    private DrugCatalog drugCatalog;
    private HashMap<Drug,Department> drugUpdateSubscriptions;

    public DrugCatalog getDrugCatalog() {
        return drugCatalog;
    }
    
    public PharmaceuticalDrugRegulatoryDepartment()
    {
        super(DepartmentType.PharmaceuticalDrugRegulatoryDepartment.getValue());
        this.drugCatalog = new DrugCatalog();
        this.drugUpdateSubscriptions = new HashMap<>();
    }

    public HashMap<Drug, Department> getDrugUpdateSubscriptions() {
        return drugUpdateSubscriptions;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new FDADrugRegulator());
        return roles;
    }

    @Override
    public Person createPerson(String name) {
        Person person = new FDAOfficial();
        person.setName(name);
        this.getPersonDirectory().getPersonList().add(person);
        return person;
    }
    
}
