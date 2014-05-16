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
public class GraphTest {

    String newLine;
    public GraphTest() {
        newLine = System.getProperty("line.separator");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGraphConstructor() {
        String input = createTestInput();
        Graph g = new Graph(input);

        Assert.assertEquals(4, g.getLinks().size());
        Assert.assertEquals(4, g.getNodes().size());
        Assert.assertEquals(2, g.getNodeById(2).getNeighbours().size());
        Assert.assertEquals(2.0, g.getNodeById(2).getPosition()[0]);
        Assert.assertEquals(3, g.getNodeById(3).getLinkToNode(4).getValues().get("DISTANCE"));
    }

    private String createTestInput() {
        String result = "4 2 TIME DISTANCE" + newLine;
        result += "one 1 1" + newLine;
        result += "two 2 2" + newLine;
        result += "three 3 3" + newLine;
        result += "four 4 4" + newLine;
        result += "1 2 1 2" + newLine;
        result += "1 3 1 3" + newLine;
        result += "2 3 2 3" + newLine;
        result += "3 4 3 4" + newLine;
        return result;
    }

}
