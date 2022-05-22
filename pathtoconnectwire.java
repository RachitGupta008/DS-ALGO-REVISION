import java.io.*;
import java.util.*;

public class Main {

   static class Pair{
       int src;
       int dest;
       int wt;
      public int getWt(){
         return wt;
      }

      Pair(int src, int dest, int wt){
         this.src = src;
         this.dest = dest;
         this.wt = wt;  
      }
   }
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

      PriorityQueue<Pair> pq = new PriorityQueue(Comparator.comparing(Pair :: getWt));
      boolean[] isVisited = new boolean[graph.length];

      pq.add(new Pair(-1, 0, 0));
      while(!pq.isEmpty()){

         Pair elem = pq.remove();

         if(isVisited[elem.dest]){
            continue;
         }

         isVisited[elem.dest] = true;

         if(elem.src!=-1){
            System.out.println("["+elem.dest+"-"+elem.src+"@"+elem.wt+"]");
         }

         for(Edge e : graph[elem.dest]){
            if(!isVisited[e.nbr]){
               pq.add(new Pair(e.src, e.nbr, e.wt));
            }
         }

      }

      // write your code here
   }

}
