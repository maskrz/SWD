/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import structures.Graph;
import structures.Link;
import structures.Node;

/**
 *
 * @author Skrzypek
 */
public class GraphReader {
    private final int VALUES_START = 2;
    Graph graph;
    Scanner scanner;
    ArrayList<String> criteriaNames;

    public GraphReader(Graph graph) {
        this.graph = graph;
        criteriaNames = new ArrayList();
    }

    public void createGraphFromString(String data) {
        scanner = new Scanner(data);
        handleCriteria();
        handleNodes();
        handleLinks();
    }

    private void handleCriteria() {
        int criteriaAmount = Integer.valueOf(scanner.nextLine());
        for(int i = 0; i < criteriaAmount; i++) {
            String criteriaName = scanner.nextLine();
            graph.addCrtieria(criteriaName);
            criteriaNames.add(criteriaName);
        }
    }

    private void handleNodes() {
        int nodesAmount = Integer.valueOf(scanner.nextLine());
        for(int i = 0; i < nodesAmount; i++) {
            String nodeInfoLine = scanner.nextLine();
            graph.addNode(createNodeFromString(nodeInfoLine, i));
        }
    }

    private Node createNodeFromString(String line, int i) {
        String[] nodeInfo = line.split(" ");
        return new Node(i+1, nodeInfo[0], Integer.valueOf(nodeInfo[1]),
                Integer.valueOf(nodeInfo[2]));
    }

    private void handleLinks() {
        int linksAmount = Integer.valueOf(scanner.nextLine());
        for(int i = 0; i < linksAmount; i++) {
            String linkInfoLine = scanner.nextLine();
            graph.addLink(createLinkFromString(linkInfoLine));
        }
    }

    private Link createLinkFromString(String linkInfoLine) {
        String[] linkInfo = linkInfoLine.split(" ");        
        return new Link(graph.getNodeById(Integer.valueOf(linkInfo[0])),
                graph.getNodeById(Integer.valueOf(linkInfo[1])),
                createLinkValuesFromInfo(linkInfo,
                criteriaNames.size()));
    }

    private HashMap<String, Double> createLinkValuesFromInfo(String[] linkInfo,
            int criteriaAmount) {
        HashMap<String, Double> linkValues = new HashMap();
        for (int i = 0; i < criteriaAmount; i ++) {
            linkValues.put(criteriaNames.get(i), Double.valueOf(linkInfo[VALUES_START + i]));
        }
        return linkValues;
    }
}
