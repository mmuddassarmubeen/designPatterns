/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Person;

import healthcare.Commons.DoctorSpecialtyType;

/**
 *
 * @author Muddassar
 */
public class Doctor extends Person {
    
    private DoctorSpecialtyType speciality;

    public DoctorSpecialtyType getSpeciality() {
        return speciality;
    }

    public void setSpeciality(DoctorSpecialtyType speciality) {
        this.speciality = speciality;
    }
    
    
}
