/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structures;

import java.util.HashMap;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Skrzypek
 */
public class NodeTest {

    Link link;
    Node node1;
    Node node2;
    public NodeTest() {
    }

    @Before
    public void setUpOnce() {
        node1 = new Node(1, "first", 1, 1);
        node2 = new Node(2, "two", 2, 2);
        HashMap<String, Double> values = new HashMap();
        values.put("TIME", 5.0);
        values.put("DISTANCE", 1.0);
        node1.addNeighbour(node2, values);

    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getLinkToNode method, of class Node.
     */
    @Test
    public void testGetLinkToNode() {
        System.out.println("getLinkToNode");

        Assert.assertNull(node1.getLinkToNode(3));
        Assert.assertNull(node1.getLinkToNode(1));
        Assert.assertEquals(5.0, node1.getLinkToNode(2).getValues().get("TIME"));
        Assert.assertEquals(1.0, node2.getLinkToNode(1).getValues().get("DISTANCE"));
    }

}
