/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Department.PatientSocial;

import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class SocialGroupDirectory {
    
    private ArrayList<SocialGroup> socialGroups;
    
    public SocialGroupDirectory()
    {
        this.socialGroups = new ArrayList<>();
    }
    
    public SocialGroup addSocialGroup()
    {
        SocialGroup group = new SocialGroup();
        this.socialGroups.add(group);
        return group;
    }
    
}
