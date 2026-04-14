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
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
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
    public static void topSort(ArrayList<Edge>[] graph , int curr  , boolean[] visited , Stack<Integer> s){
        visited[curr] = true;
        for(int i = 0 ; i < graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.destination]){
                topSort(graph , e.destination , visited , s);
            }
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<Edge>[] graph , int curr  , boolean[] visited){
        visited[curr] = true;
        System.out.print(curr + " ");
        for(int i = 0 ; i < graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.destination]){
                dfs(graph , e.destination , visited);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge> graph[] , int vertex){
        //step 1 topological sorting:
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[vertex];
        for(int i = 0 ; i < vertex ; i++){
            if(!visited[i]){
                topSort(graph , i , visited , s);
            }
        }
        //step2 create transpose of graph:
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] transpose = (ArrayList<Edge>[]) new ArrayList[vertex];
        for(int i = 0 ; i < graph.length ; i++){
            transpose[i] = new ArrayList<Edge>();
        }
        for(int i = 0 ; i < vertex ; i++){
            for(int j = 0 ; j < graph[i].size(); j++){
                Edge e = graph[i].get(j);
                transpose[e.destination].add(new Edge(e.destination , e.source));
            }
        }

        // step 3 perform dfs in each node:
        //resuse visted boolean!
        for(int i = 0 ; i < graph.length ; i++){
            visited[i] = false;
        }
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!visited[curr]){
                dfs(transpose , curr , visited);
                 System.out.println();
            }

        }

    }
    public static void main(String args[]){
        int vertex = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[vertex];
        createGraph1(graph);
        kosaraju(graph , vertex);
    }
}