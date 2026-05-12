public class Experiment {

    public void runTraversals(Graph g) {
        System.out.println("\n--- TRAVERSALS ---");
        long start, end;

        start = System.nanoTime();
        g.bfs(0);
        end = System.nanoTime();
        System.out.printf("BFS time: %d ns (%.3f ms)\n", end - start, (end - start) / 1_000_000.0);

        start = System.nanoTime();
        g.dfs(0);
        end = System.nanoTime();
        System.out.printf("DFS time: %d ns (%.3f ms)\n", end - start, (end - start) / 1_000_000.0);
    }

    public void runMultipleTests() {
        System.out.println("\n==========================================");
        System.out.println("     GRAPH TRAVERSAL ANALYSIS");
        System.out.println("==========================================");

        int[] sizes = {10, 30, 100};

        for (int size : sizes) {
            System.out.println("\n--- GRAPH SIZE: " + size + " vertices ---");

            int edges = size * 15 / 10;
            Graph g = Graph.generateRandomGraph(size, edges);

            g.printGraph();
            runTraversals(g);
        }
    }

    public void printResults() {
        System.out.println("\n==========================================");
        System.out.println("              FINAL RESULTS");
        System.out.println("==========================================");
    }
}