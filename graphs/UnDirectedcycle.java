//indirect level order traversal/search
import java.util.*;
public class graphs{
    static class Edge{
        int source;
        int destination;
        public Edge(int source , int destination){
            this.source = source;
            this.destination = destination;
        }
    }
    private static void addUndirectedEdge(ArrayList<Edge> graph[], int u, int v){
        graph[u].add(new Edge(u, v));
        graph[v].add(new Edge(v, u));
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<Edge>();
        }
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 0, 2);
        addUndirectedEdge(graph, 1, 3);
        addUndirectedEdge(graph, 2, 4);
        // addUndirectedEdge(graph, 3, 4);
        // addUndirectedEdge(graph, 3, 5);
        // addUndirectedEdge(graph, 4, 5);
        addUndirectedEdge(graph, 5, 6);
    }

    public static boolean isCycle(ArrayList<Edge> graph[] , int curr , boolean[] visited , int parent){
        visited[curr] = true;
        for(int i = 0 ; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(visited[e.destination] == true && parent != e.destination) return true;
            if(!visited[e.destination]){
                if(isCycle(graph , e.destination , visited , curr)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        int vertex = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[vertex];
        createGraph(graph);
        System.out.print(isCycle(graph , 0 , new boolean[vertex], -1));
    }
}