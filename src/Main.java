import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Experiment experiment = new Experiment();

        printHeader();

        // Часть 1: Демонстрация на маленьком графе
        demonstration();

        // Часть 2: Запуск экспериментов
        experiment.runMultipleTests();

        // Часть 3: Интерактивный режим
        interactiveMode();

        experiment.printResults();
        printFooter();
    }

    private static void demonstration() {
        System.out.println("\n1. DEMONSTRATION ON SMALL GRAPH");
        System.out.println("--------------------------------");

        // Создаем маленький граф вручную для демонстрации
        Graph g = new Graph();

        // Добавляем вершины (0-6)
        for (int i = 0; i < 7; i++) {
            g.addVertex(new Vertex(i));
        }

        // Добавляем ребра
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        g.printGraph();

        System.out.println("\nStarting traversal from vertex 0:");
        g.bfs(0);
        g.dfs(0);
    }

    private static void interactiveMode() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n2. INTERACTIVE MODE");
        System.out.println("--------------------");
        System.out.print("\nEnter graph size (vertices, max 20): ");
        int size = scanner.nextInt();

        Graph g = Graph.generateRandomGraph(size, size * 2);
        g.printGraph();

        System.out.println("\nChoose traversal:");
        System.out.println("1 - BFS (Breadth-First Search)");
        System.out.println("2 - DFS (Depth-First Search)");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();

        long start = System.nanoTime();
        if (choice == 1) {
            g.bfs(0);
        } else if (choice == 2) {
            g.dfs(0);
        } else {
            System.out.println("Invalid choice");
            scanner.close();
            return;
        }
        long end = System.nanoTime();

        System.out.printf("Time: %d ns (%.3f ms)\n", end - start, (end - start) / 1_000_000.0);

        scanner.close();
    }

    private static void printHeader() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║     GRAPH TRAVERSAL ANALYSIS SYSTEM       ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║  Algorithms: BFS and DFS                   ║");
        System.out.println("║  Representation: Adjacency List            ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }

    private static void printFooter() {
        System.out.println("\n==========================================");
        System.out.println("           EXPERIMENT COMPLETE");
        System.out.println("==========================================");
    }
}