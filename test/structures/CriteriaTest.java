/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structures;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Skrzypek
 */
public class CriteriaTest {

    public CriteriaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addCrtieria method, of class Criteria.
     */
    @Test
    public void testAddCrtieria() {
        System.out.println("addCrtieria");
        Criteria instance = new Criteria();
        instance.addCrtieria("TIME");
        instance.addCrtieria("DISTANCE");

        Assert.assertEquals(2, instance.size());
        Assert.assertEquals("TIME", instance.criteria.get(0));
    }

}
