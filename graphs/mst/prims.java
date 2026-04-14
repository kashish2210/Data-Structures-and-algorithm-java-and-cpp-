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
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }
    public static class Pair implements Comparable<Pair>{
        int node ;
        int cost ;
        int parent;
        public Pair(int n , int c ,int p){
            this.node = n;
            this.cost = c;
            this.parent = p;
        }
        @Override
        public int compareTo(Pair p){
            return this.cost - p.cost;
        }
    }
    public static void prims(ArrayList<Edge>[]  graph , int vertex){
        boolean[] visited = new boolean[vertex];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0 , 0 ,-1));
        int mstCost = 0;
        ArrayList<Edge> mstEdges = new ArrayList<>();
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.node]){
                visited[curr.node] = true;
                if(curr.parent != -1){
                    mstEdges.add(new Edge(curr.parent , curr.node , curr.cost));
                }
                mstCost += curr.cost;
                for(int i = 0 ; i < graph[curr.node].size() ; i++){
                    Edge e = graph[curr.node].get(i);
                    if(!visited[e.destination]){
                        pq.add(new Pair(e.destination , e.weight , curr.node));
                    }
                }
            }
        }
        System.out.println("min cost of mst = "+ mstCost);
        for(int i = 0; i < mstEdges.size(); i++){
            Edge e = mstEdges.get(i);
            System.out.println(e.source + " - " + e.destination + " (" + e.weight + ")");
        }
    }
    public static void main(String args[]){
        int vertex = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[vertex];
        createGraph(graph);
        prims(graph , vertex);
    }
}