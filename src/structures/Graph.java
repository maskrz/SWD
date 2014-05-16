/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structures;

import java.util.ArrayList;

/**
 *
 * @author Skrzypek
 */
public class Graph {
    private ArrayList<Node> nodes;
    private ArrayList<Link> links;

    public Graph(String datas) {
        createGraphFromString(datas);
    }

    private void createGraphFromString(String datas) {
        
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public Node getNodeById(int i) {
        for(Node node: nodes) {
            if(node.getIndex() == i)
                return node;
        }
        return null;
    }

    public Node getNodeByName(String name) {
        for(Node node: nodes) {
            if(name.equals(node.getName()))
                return node;
        }
        return null;
    }
}
