package data_structures.trees_and_graphs;

import java.util.ArrayList;

public class AdjacencyListGraph implements Graph {
    // Directional Graph Datatype implemented with adjacency list
    private ArrayList<GraphNode> nodes;

    public void addVertex(GraphNode n) {
        if (!nodes.contains(n)) {
            nodes.add(n);
        }
    }

    public void addEdge(GraphNode from, GraphNode to) {
        from.addNeighbour(to);
    }

    public void addDoubleEdge(GraphNode n1, GraphNode n2) {
        n1.addNeighbour(n2);
        n2.addNeighbour(n1);
    }

    public ArrayList<GraphNode> getNodes() {
        return this.nodes;
    }

}

class GraphNode {
    int val;
    ArrayList<GraphNode> neighbours;

    public GraphNode(int val) {
        this.val = val;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbour(GraphNode n) {
        if (!neighbours.contains(n)) {
            neighbours.add(n);
        }
    }
}



