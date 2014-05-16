/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithm;

import structures.Graph;
import structures.Node;

/**
 *
 * @author Skrzypek
 */
public class FWAlgorithm {
    
    protected final int nodesAmount;
    protected Graph graph;
    private double[][] pathsTable;
    private int[][] intermediateNodesTable;
    protected String criteria;

    public FWAlgorithm(int nodesAmount, Graph graph) {
        this.nodesAmount = nodesAmount;
        this.graph = graph;
        criteria = "TIME";
        pathsTable = new double[nodesAmount][nodesAmount];
        intermediateNodesTable = new int[nodesAmount][nodesAmount];
        AlgorithmInitializer algorithmInitializer = new AlgorithmInitializer(this,
                pathsTable, intermediateNodesTable);
        algorithmInitializer.initializeTables();
    }

    public void doAlgorithm() {
        for(Node u : graph.getNodes()) {
            for(Node v1 : graph.getNodes()) {
                for(Node v2 : graph.getNodes()) {
                    swapProcedure(u, v1, v2);
                }
            }
        }
    }

    private void swapProcedure(Node u, Node v1, Node v2) {
        int ui = u.getIndex()-1;
        int v1i = v1.getIndex()-1;
        int v2i = v2.getIndex()-1;
        if(shouldSwap(ui, v1i, v2i)) {
            pathsTable[v1i][v2i] = pathsTable[v1i][ui] + pathsTable[ui][v2i];
            intermediateNodesTable[v1i][v2i] = intermediateNodesTable[ui][v2i];
        }
    }

    private boolean shouldSwap(int ui, int v1i, int v2i) {
        if (pathsTable[v1i][v2i] > pathsTable[v1i][ui] + pathsTable[ui][v2i]) {
            return true;
        }
        return false;
    }

    public OutputProcessor getOutputProcessor() {
        return new OutputProcessor(this, pathsTable, intermediateNodesTable);
    }


}