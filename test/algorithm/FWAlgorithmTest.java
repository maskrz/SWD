/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithm;

import helpers.GraphReader;
import helpers.OutputProcessor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import structures.Graph;

/**
 *
 * @author Skrzypek
 */
public class FWAlgorithmTest {

    String newLine;
    Graph g;
    GraphReader gr;
    String source = "test1.txt";
    final String testPath = "test/";
    final String testCriteria = "TIME";
    public FWAlgorithmTest() {
        newLine = System.getProperty("line.separator");
        g = new Graph(createTestInput());
        gr = new GraphReader(g);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testConstructor() {
        FWAlgorithm fwa = new FWAlgorithm(g.getNodes().size(), g);
        //System.out.println(fwa.printPathsTable());
        //System.out.println(fwa.printIntermediateNodesTable());
    }

    /*
    @Test
    public void testReadingPath() {
        FWAlgorithm fwa = new FWAlgorithm(g.getNodes().size(), g);
        int[][] testIntermediates = createIntermediates();
        fwa.setIntermediateNodes(testIntermediates);
        int[] result = fwa.getPath(1, 4);
        Assert.assertEquals(1, result[0]);
        Assert.assertEquals(2, result[1]);
        Assert.assertEquals(3, result[2]);
        Assert.assertEquals(4, result[3]);
        result = fwa.getPath(3, 1);
        Assert.assertEquals(1, result[2]);
        Assert.assertEquals(2, result[1]);
        Assert.assertEquals(3, result[0]);
        result = fwa.getPath(1, 2);
        Assert.assertEquals(1, result[0]);
        Assert.assertEquals(2, result[1]); 
    }
    */
    @Test
    public void testDoAlgorithm() {
        
        FWAlgorithm fwa = new FWAlgorithm(g.getNodes().size(), g);
        fwa.doAlgorithm();
        OutputProcessor op = fwa.getOutputProcessor();
        op.showResults(testCriteria);
        int[] path = op.getPath(testCriteria, 1, 5);
        
        System.out.println(op.getResult(testCriteria, 1, 5));
        for(int i = 0; i < path.length; i++) {
            System.out.println(path[i]);
        }
        path = op.getPath(testCriteria, 3, 1);
        System.out.println(op.getResult(testCriteria, 3, 1));
        for(int i = 0; i < path.length; i++) {
            System.out.println(path[i]);
        }
    }

    private String createTestInput() {
        File f = new File(testPath + source);
        String result = "";
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()) {
                result += sc.nextLine() + newLine;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FWAlgorithmTest.class.getName()).log(Level.SEVERE, null, ex);
        }
//        String result = "1" + newLine;
//        result += "TIME" + newLine;
//        result += "6" + newLine;
//        result += "one 1 1" + newLine;
//        result += "two 2 2" + newLine;
//        result += "three 3 3" + newLine;
//        result += "four 4 4" + newLine;
//        result += "five 3 3" + newLine;
//        result += "six 4 4" + newLine;
//        result += "8" + newLine;
//        result += "1 3 100" + newLine;
//        result += "2 3 5" + newLine;
//        result += "1 5 50" + newLine;
//        result += "1 6 10" + newLine;
//        result += "2 4 5" + newLine;
//        result += "4 5 5" + newLine;
//        result += "2 6 10" + newLine;
//        result += "1 2 200" + newLine;
        System.out.println(result);
        return result;
    }

    private int[][] createIntermediates() {
        int[][] tab = {{0, 1, 2, 3}, {0, 0, 2, 3}, {0, 0, 0, 3}, {0, 0, 0, 0}};
        return tab;
    }

}
