/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Skrzypek
 */
public class StraightDistanceTableTest {

    public StraightDistanceTableTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void constructorTest() {
        StraightDistanceTable sdt = new StraightDistanceTable();
        Assert.assertEquals(0.0, sdt.getDistanceBeetwenPoints(5, 5));
        Assert.assertEquals(237.5, sdt.getDistanceBeetwenPoints(1, 0));
        Assert.assertEquals(237.5, sdt.getDistanceBeetwenPoints(0, 1));
        Assert.assertEquals(308.0, sdt.getDistanceBeetwenPoints(14, 12));
    }

}
