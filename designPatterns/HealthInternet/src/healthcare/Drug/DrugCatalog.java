/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.Drug;

import java.util.ArrayList;

/**
 *
 * @author Muddassar
 */
public class DrugCatalog {
    
    private ArrayList<Drug> drugList;
    
    public DrugCatalog()
    {
        this.drugList = new ArrayList<>();
    }
    
    public Drug addDrug(String name)
    {
        Drug drug = new Drug(name);
        this.drugList.add(drug);
        return drug;
    }

    public ArrayList<Drug> getDrugList() {
        return drugList;
    }
    
}
