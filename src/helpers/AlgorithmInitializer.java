/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import algorithm.FWAlgorithm;
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

    public AlgorithmInitializer(FWAlgorithm fwAlgorithm) {
        this.fwa = fwAlgorithm;
        this.nodesAmount = fwa.nodesAmount;
        this.pathsTable = new double[nodesAmount][nodesAmount];
        this.intermediateNodesTable = new int[nodesAmount][nodesAmount];
    }

    public void initializeTables(String criteria) {
        //pathsTable = new double[nodesAmount][nodesAmount];
        //intermediateNodesTable = new int[nodesAmount][nodesAmount];
        initializePathsTable();
        initializeIntermediateNodesTable();
        initializeGraphValues(criteria);
        fwa.setPathsTable(this.pathsTable);
        fwa.setIntermediateNodesTableTable(this.intermediateNodesTable);
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

    private void initializeGraphValues(String criteria) {
        for (Link link : fwa.graph.getLinks()) {
            putValueIntoTables(link, criteria);
        }
    }

    private void putValueIntoTables(Link link, String criteria) {
        int minIndex = link.getNodesIndices().get(0);
        int maxIndex = link.getNodesIndices().get(1);
        pathsTable[minIndex - 1][maxIndex - 1] = link.getValues().get(criteria);
        intermediateNodesTable[minIndex - 1][maxIndex - 1] = minIndex;

        pathsTable[maxIndex - 1][minIndex - 1] = link.getValues().get(criteria);
        intermediateNodesTable[maxIndex - 1][minIndex - 1] = maxIndex;
    }
}
