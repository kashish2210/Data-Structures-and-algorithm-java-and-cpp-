//Tarjan's algorithm:
import java.util.*;
public class bridge{
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
    public static void dfs(ArrayList<Edge>[] graph , int curr , boolean[] visited , int[] discoveryTime , int[] lowDiscoveryTime , int time , int parent){
        visited[curr] = true;
        discoveryTime[curr] = lowDiscoveryTime[curr] = ++time;
        for(int i = 0 ; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(e.destination == parent) continue;
            else if(!visited[e.destination]){
                dfs(graph , e.destination , visited , discoveryTime , lowDiscoveryTime , time , curr);
                lowDiscoveryTime[curr] = Math.min(lowDiscoveryTime[curr] , lowDiscoveryTime[e.destination]);
                if(discoveryTime[curr] < lowDiscoveryTime[e.destination]){
                    System.out.println("Bridge is : " + curr + "------" + e.destination);
                }
            } else {
                lowDiscoveryTime[curr] = Math.min(lowDiscoveryTime[curr], discoveryTime[e.destination]);
            }
        }
    }
    public static void getBridge(ArrayList<Edge> graph[] , int vertex){
        int discoveryTime[] = new int[vertex];
        int lowDiscoveryTime[] = new int[vertex];
        int time = 0;
        boolean[] visited = new boolean[vertex];
        for(int i = 0 ; i < vertex ; i++){
            if(!visited[i]){
                dfs(graph , i , visited , discoveryTime , lowDiscoveryTime , time , -1);
            }
        }
    }
    public static void main(String args[]){
        int vertex = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[vertex];
        createGraph(graph);
        getBridge(graph , vertex);
    }
}