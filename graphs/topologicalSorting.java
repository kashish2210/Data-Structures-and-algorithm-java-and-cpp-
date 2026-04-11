//indirect level order traversal/search
import java.util.*;
//direted acyclic graphh(DAG)only
public class graphs{
    static class Edge{
        int source;
        int destination;
        public Edge(int source , int destination){
            this.source = source;
            this.destination = destination;
        }
    }
    public static void createGraph1(ArrayList<Edge> graph[]){
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<Edge>();
        }
        // DAG example
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 6));
    }

    public static boolean isCycle(ArrayList<Edge> graph[] , int curr , boolean[] visited , boolean[] rec){
        visited[curr] = true;
        rec[curr] = true;
        for(int i = 0 ; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(rec[e.destination] == true){
                return true;
            }else if(!visited[e.destination]){
                if(isCycle(graph , e.destination , visited , rec));{
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }
    public static void topologicalUtil(ArrayList<Edge>[] graph , int curr  , boolean[] visited , Stack<Integer> s){
        visited[curr] = true;
        for(int i = 0 ; i < graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.destination]){
                topologicalUtil(graph , e.destination , visited , s);
            }
        }
        s.push(curr);
    }
    public static void topSort(ArrayList<Edge>[] graph , int vertex){
        boolean[] visited = new boolean[vertex];
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i < vertex ; i++){
            if(!visited[i]){
                topologicalUtil(graph , i , visited, s);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }
    public static void main(String args[]){
        int vertex = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[vertex];
        createGraph1(graph);
        topSort(graph , vertex);
    }
}