import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
    Queue<Integer> q = new ArrayDeque<>();
      boolean[] visited = new boolean[graph.length];
      
   int len = 0;
      for(int i=0;i<graph.length;i++){
         if(visited[i]){
            continue;
         }
         q.add(i);
         len = 0;

         while(!q.isEmpty()){

         int elem = q.remove();
         if(!visited[elem]){
         len++;
         }
         
         if(!visited[elem]){
            visited[elem] = true;
         }else{
            if(len%2==1){
            System.out.println("false");
            return;
            }
            
         }
        
         for(Edge e : graph[elem]){
         //   System.out.println(e.nbr);
            if(!visited[e.nbr]){
               q.add(e.nbr);
            }

         }
       //  System.out.println(q);

      }
      }
      
     System.out.println("true");
      // write your code here
   }
}
