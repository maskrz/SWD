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
public class Node {

    private int index;
    private ArrayList<Link> links;
    private ArrayList<Node> neighbours;
    private String name;
    private double[] postition;


    public Node(int index, String name, double x, double y) {
        this.index = index;
        this.name = name;
        this.postition = new double[]{x, y};
        this.links = new ArrayList();
        this.neighbours = new ArrayList();
    }

    public int getIndex() {
        return index;
    }

    public void createNeighbourhood(Node node, HashMap<String, Double> linkValues) {
        createLinkIfNotExist(node, linkValues);
    }

    public void createNeighbourhood(Node node, Link link) {
        if(!isNeighbourWith(node.getIndex())) {
            this.addNeighbour(node);
            node.addNeighbour(this);
            addLink(link);
        }
    }

    String getName() {
        return name;
    }

    public double[] getPosition() {
        return postition;
    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    public Link getLinkToNode(int i) {
        for(Link link: links) {
            if(link.containsNodes(i, index)) {
                return link;
            }
        }
        return null;
    }

    public boolean isNeighbourWith(int index) {
        for(Node node: neighbours) {
            if(node.getIndex() == index) {
                return false;
            }
        }
        return false;
    }

    public boolean isNeighbourWith(Node node) {
        return isNeighbourWith(node.getIndex());
    }

    private void createLinkIfNotExist(Node node, HashMap<String, Double> linkValues) {
        if(!this.isNeighbourWith(node.getIndex())) {
            createNewLink(node, linkValues);
        }
    }

    private void createNewLink(Node node, HashMap<String, Double> linkValues) {
        Link link = new Link(this, node, linkValues);
        this.createNeighbourhood(node, link);
        node.createNeighbourhood(this, link);
    }

    private void addNeighbour(Node node) {
        neighbours.add(node);
    }

    private void addLink(Link link) {
        links.add(link);
    }

}
