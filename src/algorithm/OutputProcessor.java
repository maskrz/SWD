/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Skrzypek
 */
public class OutputProcessor {

    FWAlgorithm fwa;
    private int nodesAmount;
    private double[][] pathsTable;
    private int[][] intermediateNodesTable;

    public OutputProcessor(FWAlgorithm fwAlgorithm, double[][] pathsTable,
            int[][] intermediateNodesTable) {
        this.fwa = fwAlgorithm;
        this.nodesAmount = fwa.nodesAmount;
        this.pathsTable = pathsTable;
        this.intermediateNodesTable = intermediateNodesTable;
    }


    public double getResult(int departure, int destination) {
        return departure < destination? pathsTable[departure-1][destination-1] :
                pathsTable[destination-1][departure-1];
    }

    public int[] getPath(int departure, int destination) {
        int min, max;
        boolean expectReverse;
        if(departure < destination) {
            min = departure - 1;
            max = destination - 1;
            expectReverse = false;
        } else {
            min = destination - 1;
            max = departure - 1;
            expectReverse = true;
        }
        ArrayList<Integer> startPath = new ArrayList<Integer>();
        startPath.add(max+1);
        ArrayList<Integer> reversedPath = buildPath(min, max, startPath);
        if(!expectReverse) {
            Collections.reverse(reversedPath);
        }
        return createArray(reversedPath);
    }

    public String printPathsTable() {
        String result = "";
        for(int i = 0; i < nodesAmount; i ++) {
            for (int j = 0; j < nodesAmount; j++) {
                result += pathsTable[i][j] + " ";
            }
            result += System.getProperty("line.separator");
        }
        return result;
    }

    public String printIntermediateNodesTable() {
        String result = "";
        for(int i = 0; i < nodesAmount; i ++) {
            for (int j = 0; j < nodesAmount; j++) {
                result += intermediateNodesTable[i][j] + " ";
            }
            result += System.getProperty("line.separator");
        }
        return result;
    }

    private ArrayList buildPath(int departure, int destination, ArrayList<Integer> path) {
        int intermediateNode = intermediateNodesTable[departure][destination] - 1;
        path.add(intermediateNode+1);
        if (intermediateNode == departure) {
            return path;
        } else {
            return buildPath(departure, intermediateNode, path);
        }
    }

    private int[] createArray(ArrayList<Integer> path) {
        int[] arrayPath = new int[path.size()];
        int i = 0;
        for (Integer step : path) {
            arrayPath[i] = step;
            i++;
        }
        return arrayPath;
    }


    // to test!
    public void setIntermediateNodes(int[][] intermediates) {
        intermediateNodesTable = intermediates;
    }
}
