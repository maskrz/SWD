/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

/**
 *
 * @author Skrzypek
 */
public class SingleResult {
    public double[][] pathsTable;
    public int[][] intermediateNodesTable;

    public SingleResult() {
        pathsTable = new double[16][16];
        intermediateNodesTable = new int[16][16];
    }

    public SingleResult(double[][] pathsTable, int[][] intermediateNodesTables) {
        this.intermediateNodesTable = intermediateNodesTables;
        this.pathsTable = pathsTable;
    }

    /**
     * @return the pathsTable
     */
    public double[][] getPathsTable() {
        return pathsTable;
    }

    /**
     * @param pathsTable the pathsTable to set
     */
    public void setPathsTable(double[][] pathsTable) {
        this.pathsTable = pathsTable;
    }

    /**
     * @return the intermediateNodesTable
     */
    public int[][] getIntermediateNodesTable() {
        return intermediateNodesTable;
    }

    /**
     * @param intermediateNodesTable the intermediateNodesTable to set
     */
    public void setIntermediateNodesTable(int[][] intermediateNodesTable) {
        this.intermediateNodesTable = intermediateNodesTable;
    }
}
