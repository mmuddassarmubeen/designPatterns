/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Encounter;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Muddassar
 */
public class EncounterHistory {
    
    private Stack<Encounter> encounterList;

    public EncounterHistory()
    {
        this.encounterList = new Stack<>();
    }
    public Stack<Encounter> getEncounterList() {
        return encounterList;
    }
    
    public Encounter addEncounter()
    {
        Encounter encounter = new Encounter();
        encounterList.push(encounter);
        return encounter;
    }
    
}
