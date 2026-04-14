import java.util.*;

public class PrimMatrix {
    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // O(V^2) Prim using adjacency matrix
    public static void prims(int[][] graph) {
        int vertex = graph.length;
        boolean[] inMst = new boolean[vertex];
        int[] key = new int[vertex];
        int[] parent = new int[vertex];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[0] = 0;
        for (int count = 0; count < vertex; count++) {
            int u = -1;
            int minKey = Integer.MAX_VALUE;
            for (int v = 0; v < vertex; v++) {
                if (!inMst[v] && key[v] < minKey) {
                    minKey = key[v];
                    u = v;
                }
            }
            if (u == -1) {
                break;
            }
            inMst[u] = true;

            for (int v = 0; v < vertex; v++) {
                int weight = graph[u][v];
                if (weight != 0 && !inMst[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                }
            }
        }

        int mstCost = 0;
        System.out.println("edges in mst:");
        for (int v = 1; v < vertex; v++) {
            if (parent[v] != -1) {
                int w = graph[parent[v]][v];
                mstCost += w;
                System.out.println(parent[v] + " - " + v + " (" + w + ")");
            }
        }
        System.out.println("min cost of mst = " + mstCost);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 15, 30},
                {10, 0, 0, 40},
                {15, 0, 0, 50},
                {30, 40, 50, 0}
        };
        prims(graph);
    }
}
