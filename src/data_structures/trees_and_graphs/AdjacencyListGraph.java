package data_structures.trees_and_graphs;

import java.util.ArrayList;

public class AdjacencyListGraph implements Graph {
    // Directional Graph Datatype implemented with adjacency list
    public ArrayList<GraphNode> nodes;

    public boolean addVertex(GraphNode n) {
        if (!nodes.contains(n)) {
            nodes.add(n);
            return true;
        }
        return false;
    }

    public boolean addEdge(GraphNode from, GraphNode to) {
        return from.addNeighbour(to);
    }

    public boolean addDoubleEdge(GraphNode n1, GraphNode n2) {
        return n1.addNeighbour(n2) || n2.addNeighbour(n1);
    }



}

class GraphNode {
    String name;
    ArrayList<GraphNode> neighbours;

    public GraphNode(String name) {
        this.name = name;
    }

    public boolean addNeighbour(GraphNode n) {
        if (!neighbours.contains(n)) {
            neighbours.add(n);
            return true;
        }

        return false;
    }
}



