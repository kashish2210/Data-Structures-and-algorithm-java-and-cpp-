import java.util.*;

public class unweighted_matrix {
    static class Edge {
        int source;
        int destination;

        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    public static int[][] buildMatrix(ArrayList<Edge>[] graph) {
        int n = graph.length;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (Edge e : graph[i]) {
                matrix[i][e.destination] = 1;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertex = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[vertex];
        createGraph(graph);
        int[][] matrix = buildMatrix(graph);
        printMatrix(matrix);
    }
}
