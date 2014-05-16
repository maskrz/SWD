/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structures;

import java.util.ArrayList;
import java.util.HashMap;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Skrzypek
 */
public class LinkTest {

    Link link;
    Node node1;
    Node node2;
    public LinkTest() {
    }

    @Before
    public void setUpOnce() {
        node1 = new Node(1, "first", 1, 1);
        node2 = new Node(2, "two", 2, 2);
        HashMap<String, Double> values = new HashMap();
        values.put("TIME", 5.0);
        values.put("DISTANCE", 1.0);
        link = new Link(node1, node2, values);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getNodes method, of class Link.
     */
    @Test
    public void testGetNodes() {
        System.out.println("getNodes");
        ArrayList<Node> nodes = link.getNodes();

        Assert.assertEquals("first", nodes.get(0).getName());
        Assert.assertEquals(2, nodes.get(1).getIndex());
    }

    /**
     * Test of hasNodes method, of class Link.
     */
    @Test
    public void testHasNodes() {
        System.out.println("hasNodes");
        Assert.assertTrue(link.containsNodes(1, 2));
        Assert.assertFalse(link.containsNodes(4, 2));
    }

    /**
     * Test of getNodesIndices method, of class Link.
     */
    @Test
    public void testGetNodesIndices() {
        System.out.println("getNodesIndices");
        ArrayList<Integer> indices = link.getNodesIndices();
        Assert.assertTrue(indices.contains(1));
        Assert.assertTrue(indices.contains(2));
        Assert.assertFalse(indices.contains(3));
        Assert.assertFalse(indices.contains(0));
    }

}
