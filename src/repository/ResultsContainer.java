/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Skrzypek
 */
public class ResultsContainer {
    HashMap<String, SingleResult> results;

    public ResultsContainer() {
        results = new HashMap();
    }
    public double getResult(String criteria, int departure, int destination) {
        SingleResult result = results.get(criteria);
        return departure < destination? result.pathsTable[departure-1][destination-1] :
                result.pathsTable[destination-1][departure-1];
    }

    public int[] getPath(String criteria, int departure, int destination) {
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
        ArrayList<Integer> reversedPath = buildPath(criteria, min, max, startPath);
        if(!expectReverse) {
            Collections.reverse(reversedPath);
        }
        return createArray(reversedPath);
    }

    private ArrayList buildPath(String criteria, int departure, int destination, ArrayList<Integer> path) {
        SingleResult result = results.get(criteria);
        int intermediateNode = result.intermediateNodesTable[departure][destination] - 1;
        path.add(intermediateNode+1);
        if (intermediateNode == departure) {
            return path;
        } else {
            return buildPath(criteria, departure, intermediateNode, path);
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

    public String printPathsTable(String criteria) {
        SingleResult result = results.get(criteria);
        int nodesAmount = result.pathsTable.length;
        String resultString = "";
        for(int i = 0; i < nodesAmount; i ++) {
            for (int j = 0; j < nodesAmount; j++) {
                resultString += result.pathsTable[i][j] + " ";
            }
            resultString += System.getProperty("line.separator");
        }
        return resultString;
    }

    public String printIntermediateNodesTable(String criteria) {
        SingleResult result = results.get(criteria);
        int nodesAmount = result.pathsTable.length;
        String resultString = "";
        for(int i = 0; i < nodesAmount; i ++) {
            for (int j = 0; j < nodesAmount; j++) {
                resultString += result.intermediateNodesTable[i][j] + " ";
            }
            resultString += System.getProperty("line.separator");
        }
        return resultString;
    }

    public void addResult(String criteria, double[][] pathsTable, int[][] intermediateNodesTable) {
        if(!results.containsKey(criteria)) {
            SingleResult newResult = new SingleResult(pathsTable, intermediateNodesTable);
            results.put(criteria, newResult);
        }
    }

    public SingleResult getSingleResult(String criteria) {
        return results.get(criteria);
    }
}
