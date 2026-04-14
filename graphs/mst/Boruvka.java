import java.util.*;

public class Boruvka {
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

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) {
                return false;
            }
            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pb] < rank[pa]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public static void boruvka(int vertex, ArrayList<Edge> edges) {
        DSU dsu = new DSU(vertex);
        int components = vertex;
        int mstCost = 0;
        ArrayList<Edge> mstEdges = new ArrayList<>();

        while (components > 1) {
            int[] cheapest = new int[vertex];
            Arrays.fill(cheapest, -1);

            for (int i = 0; i < edges.size(); i++) {
                Edge e = edges.get(i);
                int setA = dsu.find(e.source);
                int setB = dsu.find(e.destination);
                if (setA == setB) {
                    continue;
                }
                if (cheapest[setA] == -1 || edges.get(cheapest[setA]).weight > e.weight) {
                    cheapest[setA] = i;
                }
                if (cheapest[setB] == -1 || edges.get(cheapest[setB]).weight > e.weight) {
                    cheapest[setB] = i;
                }
            }

            for (int i = 0; i < vertex; i++) {
                int edgeIndex = cheapest[i];
                if (edgeIndex != -1) {
                    Edge e = edges.get(edgeIndex);
                    if (dsu.union(e.source, e.destination)) {
                        mstEdges.add(e);
                        mstCost += e.weight;
                        components--;
                    }
                }
            }
        }

        System.out.println("edges in mst:");
        for (int i = 0; i < mstEdges.size(); i++) {
            Edge e = mstEdges.get(i);
            System.out.println(e.source + " - " + e.destination + " (" + e.weight + ")");
        }
        System.out.println("min cost of mst = " + mstCost);
    }

    public static void main(String[] args) {
        int vertex = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
        boruvka(vertex, edges);
    }
}
