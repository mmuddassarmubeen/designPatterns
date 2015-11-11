/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Encounter;

import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class SocialHabitSummary {
    
    private ArrayList<SocialHabits> socialHabitsList;
    
    public SocialHabitSummary()
    {
        this.socialHabitsList = new ArrayList<>();
    }
    
    public SocialHabits addSocialHabit()
    {
        SocialHabits habit = new SocialHabits();
        this.socialHabitsList.add(habit);
        return habit;
    }

    public ArrayList<SocialHabits> getSocialHabitsList() {
        return socialHabitsList;
    }
    
    
}
