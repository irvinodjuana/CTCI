package data_structures.trees_and_graphs;

import java.util.*;

public class Question4_1 {
    public static boolean BFS(AdjacencyListGraph graph, GraphNode start, GraphNode end) {
        Queue<GraphNode> q = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        GraphNode n;

        // Run BFS searching n1 -> n2
        while (!q.isEmpty()) {
            n = q.remove();
            visited.add(n);
            if (n == end) return true;
            for (GraphNode nbor : n.neighbours) {
                if (!visited.contains(nbor)) {
                    q.add(nbor);
                }
            }
        }
        return false;
    }

    public static boolean isPath(AdjacencyListGraph graph, GraphNode n1, GraphNode n2) {
        return BFS(graph, n1, n2) || BFS(graph, n2, n1);
    }

    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph();
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);

        n1.addNeighbour(n2);
        n1.addNeighbour(n3);
        n3.addNeighbour(n2);
        n4.addNeighbour(n3);
        n5.addNeighbour(n4);

        System.out.println(isPath(graph, n2, n5));  // true
        System.out.println(isPath(graph, n5, n1));  // false

    }
}
