/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helpers;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import structures.Graph;

/**
 *
 * @author Skrzypek
 */
public class GraphReaderTest {

    String newLine;
    public GraphReaderTest() {
        newLine = System.getProperty("line.separator");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of createGraphFromString method, of class GraphReader.
     */
    @Test
    public void testCreateGraphFromString() {
        String input = createTestInput();
        Graph g = new Graph(input);

        Assert.assertEquals(4, g.getLinks().size());
        Assert.assertEquals(4, g.getNodes().size());
        Assert.assertEquals(2, g.getNodeById(2).getNeighbours().size());
        Assert.assertEquals(2.0, g.getNodeById(2).getPosition()[0]);
        Assert.assertEquals(4.0, g.getNodeById(3).getLinkToNode(4).getValues().get("DISTANCE"));
    }

    private String createTestInput() {
        String result = "2" + newLine;
        result += "TIME" + newLine;
        result += "DISTANCE" + newLine;
        result += "4" + newLine;
        result += "one 1 1" + newLine;
        result += "two 2 2" + newLine;
        result += "three 3 3" + newLine;
        result += "four 4 4" + newLine;
        result += "4" + newLine;
        result += "1 2 1 2" + newLine;
        result += "1 3 1 3" + newLine;
        result += "2 3 2 3" + newLine;
        result += "3 4 3 4" + newLine;
        return result;
    }

}
