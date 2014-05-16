/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structures;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Skrzypek
 */
public class Link {
    private Node firstNode;
    private Node secondNode;
    private HashMap<String, Double> linkValues;

    public Link(Node n1, Node n2, HashMap<String, Double> linkValues) {
        firstNode = n1.getIndex() < n2.getIndex()? n1 : n2;
        secondNode = n1.getIndex() > n2.getIndex()? n1 : n2;
        this.linkValues = linkValues;
    }

    public HashMap<String, Double> getValues() {
        return linkValues;
    }

    public ArrayList<Node> getNodes() {
        ArrayList<Node> nodes = new ArrayList();
        nodes.add(firstNode);
        nodes.add(secondNode);

        return nodes;
    }

    public boolean containsNodes(int first, int second) {
        return (firstNode.getIndex() == first && secondNode.getIndex() == second) ||
                (firstNode.getIndex() == second && secondNode.getIndex() == first);
    }

    public ArrayList<Integer> getNodesIndices() {
        ArrayList<Integer> nodes = new ArrayList();
        nodes.add(firstNode.getIndex());
        nodes.add(secondNode.getIndex());

        return nodes;
    }
}
