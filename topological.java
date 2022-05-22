import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
      }
      Stack<Integer> stk = new Stack<>();
      boolean[] visited = new boolean[graph.length];

      for(int i=0;i<graph.length;i++){
         if(!visited[i]){
            topological(graph, i , stk, visited);
         }
      }

      while(!stk.isEmpty()){
         System.out.println(stk.pop());
      }


      // write your code here
   }

   public static void topological( ArrayList<Edge>[] graph, int src, Stack<Integer> stk, boolean[] visited){
      visited[src] = true;

      for(Edge e : graph[src]){
         if(!visited[e.nbr]){
            topological(graph, e.nbr, stk, visited);
         }
      }

      stk.push(src);

   }

}
