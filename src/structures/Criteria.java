/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structures;

import java.util.ArrayList;

/**
 *
 * @author Skrzypek
 */
public class Criteria {
    public ArrayList<String> criteria;

    public Criteria() {
        criteria = new ArrayList();
    }

    public void addCrtieria(String criteria) {
        this.criteria.add(criteria);
    }

    public int size() {
        return criteria.size();
    }
}
