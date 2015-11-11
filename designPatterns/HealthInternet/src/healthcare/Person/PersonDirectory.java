/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Person;


import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class PersonDirectory {
    private ArrayList<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
    
    public Person createPerson(String name){
        Person person = new Person();
        
        if(person !=null)
        {
            person.setName(name);
            personList.add(person);
        }
        return person;
    }
    
    public Person searchPerson(String ssn)
    {
        for(Person p : this.personList)
        {
            if(p.getSsn().equals(ssn))
            {
                return p;
            }
        }
        return null;
    }
}
