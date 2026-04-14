//Tarjan's algorithm:
import java.util.*;
public class articulationPoint{
    static class Edge{
        int source;
        int destination;
        public Edge(int source , int destination){
            this.source = source;
            this.destination = destination;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
    }
    //o(v+E)
    public static void dfs(ArrayList<Edge>[] graph , int curr ,int parent, boolean[] visited , int[] discoveryTime , int[] lowDiscoveryTime , int time , boolean[] articulationPoint){
        visited[curr] = true;
        discoveryTime[curr] = lowDiscoveryTime[curr] = ++time;
        int children = 0;
        for(int i = 0 ; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            int neighbour = e.destination;
            if(neighbour == parent) continue;
            else if(!visited[neighbour]){
                dfs(graph , neighbour , curr ,visited , discoveryTime , lowDiscoveryTime , time , articulationPoint);
                lowDiscoveryTime[curr] = Math.min(lowDiscoveryTime[curr] , lowDiscoveryTime[neighbour]);
                if(discoveryTime[curr] <= lowDiscoveryTime[neighbour] && parent != -1){
                   articulationPoint[curr] = true;
                }
                children++;
            } else if(visited[neighbour]) {
                lowDiscoveryTime[curr] = Math.min(lowDiscoveryTime[curr], discoveryTime[neighbour]);
            }
        }
        if(parent == -1 && children > 1){
            articulationPoint[curr] = true;
        }
    }
    public static void getArticulationPoint(ArrayList<Edge> graph[] , int vertex){
        int discoveryTime[] = new int[vertex];
        int lowDiscoveryTime[] = new int[vertex];
        int time = 0;
        boolean[] visited = new boolean[vertex];
        boolean[] articulationPoint = new boolean[vertex];
        for(int i = 0 ; i < vertex ; i++){
            if(!visited[i]){
                dfs(graph , i , - 1 , visited , discoveryTime , lowDiscoveryTime , time , articulationPoint);
            }
        }
        for(int i = 0 ; i < vertex ; i++){
            if(articulationPoint[i]){
                System.out.println("AP : " + i);
            }
        }
    }
    public static void main(String args[]){
        int vertex = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[vertex];
        createGraph(graph);
        getArticulationPoint(graph , vertex);
    }
}