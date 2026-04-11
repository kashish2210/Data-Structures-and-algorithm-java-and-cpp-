// Dijkstra algo

import java.util.*;
public class shortestPath{
    static class Edge{
        int source;
        int destination;
        int weight;
        public Edge(int source , int destination , int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 5));
        graph[1].add(new Edge(1, 3, 10));

        graph[2].add(new Edge(2, 3, 3));

        graph[3].add(new Edge(3, 1, 1));
    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int n , int d){
            this.node = n;
            this.dist = d;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;//ascending
            // return p2.dist - this.dist; desending
        }
    }
    //O(E + ElogV);
    public static void Dijkstra(ArrayList<Edge> graph[], int src , int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist  = new int[V];
        for(int i =  0 ; i < V ; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] vis  = new boolean[V];
        pq.add(new Pair(0 , 0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;
                for(int i = 0 ; i < graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.source;
                    int v = e.destination;
                    if(dist[u] + e.weight < dist[v]){
                        dist[v] = dist[u] + e.weight;
                        pq.add(new Pair( v , dist[v]));
                    }
                }
            }
        }
        for(int i = 0 ; i < V ; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int vertex = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[vertex];
        createGraph(graph);
        Dijkstra(graph , 0 , vertex);
    }
}