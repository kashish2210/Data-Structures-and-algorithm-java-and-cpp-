import java.util.*;
public class undirected_weighted{
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
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0 , 2));
        graph[2].add(new Edge(2, 1 , 10));
        graph[2].add(new Edge(2, 3 , -1));

        graph[3].add(new Edge(3, 1 , 0));
        graph[3].add(new Edge(3, 2, -1));
    }

    public static void printGraph(ArrayList<Edge> graph[]){
        for(int i = 0 ; i < graph.length ; i++){
            System.out.print(i + " -> ");
            for(int j = 0 ; j < graph[i].size() ; j++){
                Edge e = graph[i].get(j);
                System.out.print(e.destination + "(w = " + e.weight + ") ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int vertex = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[vertex];
        createGraph(graph);
        printGraph(graph);
    }
}