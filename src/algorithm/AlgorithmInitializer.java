/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import structures.Link;

/**
 *
 * @author Skrzypek
 */
public class AlgorithmInitializer {

    FWAlgorithm fwa;
    private int nodesAmount;
    private double[][] pathsTable;
    private int[][] intermediateNodesTable;

    public AlgorithmInitializer(FWAlgorithm fwAlgorithm, double[][] pathsTable,
            int[][] intermediateNodesTable) {
        this.fwa = fwAlgorithm;
        this.nodesAmount = fwa.nodesAmount;
        this.pathsTable = pathsTable;
        this.intermediateNodesTable = intermediateNodesTable;
    }

    public void initializeTables() {
        initializePathsTable();
        initializeIntermediateNodesTable();
        initializeGraphValues();
    }

    private void initializePathsTable() {
        for (int i = 0; i < nodesAmount; i++) {
            for (int j = 0; j < nodesAmount; j++) {
                if (j == i) {
                    pathsTable[i][j] = 0;
                } else {
                    pathsTable[i][j] = Double.MAX_VALUE;
                }
            }
        }
    }

    private void initializeIntermediateNodesTable() {
        for (int i = 0; i < nodesAmount; i++) {
            for (int j = 0; j < nodesAmount; j++) {
                intermediateNodesTable[i][j] = 0;
            }
        }
    }

    private void initializeGraphValues() {
        for (Link link : fwa.graph.getLinks()) {
            putValueIntoTables(link);
        }
    }

    private void putValueIntoTables(Link link) {
        int minIndex = link.getNodesIndices().get(0);
        int maxIndex = link.getNodesIndices().get(1);
        pathsTable[minIndex - 1][maxIndex - 1] = link.getValues().get(fwa.criteria);
        intermediateNodesTable[minIndex - 1][maxIndex - 1] = minIndex;

        pathsTable[maxIndex - 1][minIndex - 1] = link.getValues().get(fwa.criteria);
        intermediateNodesTable[maxIndex - 1][minIndex - 1] = maxIndex;
    }
}
