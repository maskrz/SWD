/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structures;

import helpers.GraphReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Skrzypek
 */
public class Graph {
    private ArrayList<Node> nodes;
    private ArrayList<Link> links;
    private ArrayList<String> criteria;
    private Scanner scanner;

    public Graph(String data) {
        nodes = new ArrayList();
        links = new ArrayList();
        criteria = new ArrayList();
        GraphReader graphReader = new GraphReader(this);
        graphReader.createGraphFromString(data);
    }

    public Graph(File f) {
        this(createDataFromFile(f));
        
    }

    private static String createDataFromFile(File f) {
        try {
            String data = "";
            StringBuilder sb = new StringBuilder(data);
            Scanner sc = new Scanner(f);
            String line = "";
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                sb.append(line).append(System.getProperty("line.separator"));
            }
            return sb.toString();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    public void addCrtieria(String criteria) {
        this.criteria.add(criteria);
    }

    public ArrayList<String> getCrtieria() {
        return criteria;
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public void addLink(Link link) {
        links.add(link);
        linkNodes(link);
    }

    private void linkNodes(Link link) {
        link.getNodes().get(0).createNeighbourhood(link.getNodes().get(1), link);
    }
}
