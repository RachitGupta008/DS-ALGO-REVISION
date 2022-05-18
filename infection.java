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

   public static class Pair {
      public int node;
      public int level;
      Pair(int node, int level){
         this.node = node;
         this.level = level;
      }
      public String toString(){
         return "<"+node+" ,"+level+">";
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
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      

      Queue<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src, 1));
      boolean[] visited = new boolean[graph.length];
      int cnt = 0;
      while(!q.isEmpty()){
         Pair elem = q.remove();
         
         if(elem.level>t){
            break;
         }
         if(!visited[elem.node]){
         cnt++;
         visited[elem.node] = true;
         }
         

         for(Edge e : graph[elem.node]){

            if(!visited[e.nbr]){
               q.add(new Pair(e.nbr, elem.level+1));
            }
         }
 //        System.out.println(q);
      }
      System.out.println(cnt);

      // write your code here
   }

}
