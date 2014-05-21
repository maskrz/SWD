/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithm;

import helpers.OutputProcessor;
import java.io.File;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import repository.ResultsContainer;
import structures.Graph;

/**
 *
 * @author Skrzypek
 */
public class FWAlgorithmIT {
    
    Graph g;
    public FWAlgorithmIT() {
        g = new Graph(new File("test/polish_map.txt"));
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of doAlgorithm method, of class FWAlgorithm.
     */
    @Test
    public void testDoAlgorithm_0args() {
        System.out.println("doAlgorithm");
        FWAlgorithm fwa = new FWAlgorithm(g.getNodes().size(), g);
        fwa.doAlgorithm();
        OutputProcessor op = fwa.getOutputProcessor();
        op.showResults("TIME");
        op.showResults("DISTANCE");
        System.out.println(Arrays.toString(op.getPath("TIME", 1, 2)));
        System.out.println(Arrays.toString(op.getPath("DISTANCE", 1, 2)));

        ResultsContainer rs = fwa.getResultsContainer();
        System.out.println(sameArray(rs.getSingleResult("TIME").getIntermediateNodesTable(),
                rs.getSingleResult("DISTANCE").getIntermediateNodesTable()));
    }

    private boolean sameArray(int[][] a1, int[][] a2){
        for (int i = 0; i < 16; i++) {
            for(int j = 0; j < 16; j++) {
                if(a1[i][j] != a2[i][j]) {
                    System.out.println(i + " " + j);
                    //return false;
                }
            }
        }
        return true;
    }

}
