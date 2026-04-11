// BellMan ford algo;
// sum of all weights < 0 (bellmanFord doen not works)!
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
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -10));
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
    public static void bellmanFord(ArrayList<Edge> graph[], int src , int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist  = new int[V];
        for(int i =  0 ; i < V ; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0 ; i < V - 1 ; i++){//O(v))
            //O(E)
            for(int j = 0 ; j < V ; j++){
                for(int k = 0 ; k < graph[j].size(); k++){
                    Edge e = graph[j].get(k);
                    int u = e.source;
                    int v = e.destination;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] +  e.weight  < dist[v]){
                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }
        //detect -ve weight cycle!
        for(int j = 0 ; j < V ; j++){
                for(int k = 0 ; k < graph[j].size(); k++){
                    Edge e = graph[j].get(k);
                    int u = e.source;
                    int v = e.destination;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] +  e.weight  < dist[v]){
                        System.out.println("there is negative weight cycle");
                    }
                }
            }
        for(int i = 0 ; i < V ; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int vertex = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[vertex];
        createGraph(graph);
        bellmanFord(graph , 0 , vertex);
    }
}