import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList;
    private Map<Integer, Vertex> vertices;

    public Graph() {
        adjList = new HashMap<>();
        vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        int id = v.getId();
        if (!vertices.containsKey(id)) {
            vertices.put(id, v);
            adjList.put(id, new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(to);
        }
    }

    public void bfs(int start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Vertex " + start + " not found");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS order: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(vertices.get(current) + " ");

            for (int neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Vertex " + start + " not found");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS order: ");
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(vertices.get(current) + " ");

        for (int neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void printGraph() {
        System.out.println("\nGraph structure (adjacency list):");
        for (int id : adjList.keySet()) {
            System.out.print(vertices.get(id) + " -> ");
            for (int neighbor : adjList.get(id)) {
                System.out.print(vertices.get(neighbor) + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return vertices.size();
    }

    public static Graph generateRandomGraph(int numVertices, int numEdges) {
        Graph g = new Graph();

        for (int i = 0; i < numVertices; i++) {
            g.addVertex(new Vertex(i));
        }

        Random rand = new Random();
        for (int i = 0; i < numEdges; i++) {
            int from = rand.nextInt(numVertices);
            int to = rand.nextInt(numVertices);
            if (from != to) {
                g.addEdge(from, to);
            }
        }

        return g;
    }
}