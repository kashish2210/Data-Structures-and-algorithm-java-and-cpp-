import java.util.*;

public class KruskalDSU {
    static class Edge implements Comparable<Edge> {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
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

    public static void kruskal(int vertex, ArrayList<Edge> edges) {
        Collections.sort(edges);
        DSU dsu = new DSU(vertex);
        int mstCost = 0;
        ArrayList<Edge> mstEdges = new ArrayList<>();

        for (int i = 0; i < edges.size(); i++) {
            Edge e = edges.get(i);
            if (dsu.union(e.source, e.destination)) {
                mstEdges.add(e);
                mstCost += e.weight;
                if (mstEdges.size() == vertex - 1) {
                    break;
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
        kruskal(vertex, edges);
    }
}
