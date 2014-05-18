/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helpers;

import algorithm.FWAlgorithm;
import repository.ResultsContainer;

/**
 *
 * @author Skrzypek
 */
public class OutputProcessor {

    FWAlgorithm fwa;
    private int nodesAmount;
    private ResultsContainer resultsContainer;

    public OutputProcessor(FWAlgorithm fwAlgorithm, ResultsContainer resultsContainer) {
        this.fwa = fwAlgorithm;
        this.nodesAmount = fwa.nodesAmount;
        this.resultsContainer = resultsContainer;
    }


    public double getResult(String criteria, int departure, int destination) {
        return resultsContainer.getResult(criteria, departure, destination);
    }

    public int[] getPath(String criteria, int departure, int destination) {
        return resultsContainer.getPath(criteria, departure, destination);
    }

    public String printPathsTable(String criteria) {
        return resultsContainer.printPathsTable(criteria);
    }

    public String printIntermediateNodesTable(String criteria) {
        return resultsContainer.printIntermediateNodesTable(criteria);
    }

    public void showResults(String criteria) {
        System.out.println(printPathsTable(criteria));
        System.out.println(printIntermediateNodesTable(criteria));
    }


    // to test!
//    public void setIntermediateNodes(int[][] intermediates) {
//        intermediateNodesTable = intermediates;
//    }
}
