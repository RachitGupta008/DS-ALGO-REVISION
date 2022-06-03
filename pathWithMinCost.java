import java.io.*;
import java.util.*;

public class Main {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
      }
   }


   public static void minPath(int[][] arr){

      int m = arr.length;
      int n = arr[0].length;
      int dp[][] = new int[m][n];

      

      for(int i=m-1;i>=0;i--){
         for(int j=n-1;j>=0;j--){

            if(i==m-1 && j==n-1){
               dp[i][j] = arr[i][j];
            }else
            if(i==m-1){
               dp[i][j] = arr[i][j]+dp[i][j+1];
            }else if(j==n-1){
               dp[i][j] = arr[i][j] + dp[i+1][j];
            }else{

               dp[i][j] = arr[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);

            }


         }
      }

   System.out.println(dp[0][0]);

   Queue<Pair> paths = new ArrayDeque<>();

   paths.add(new Pair("", 0, 0));

   while(!paths.isEmpty()){
      Pair p = paths.remove();

      if(p.i==m-1 && p.j==n-1){
         System.out.println(p.psf);
         continue;
      }

      if(p.i==m || p.j==n){
         continue;
      }

      int dpVal = dp[p.i][p.j];
      int oVal = arr[p.i][p.j];

      if(p.i!=m-1 && (p.j==n-1 || dp[p.i+1][p.j] == (dpVal - oVal))){
         Pair pl = new Pair( p.psf+"V", p.i+1, p.j);
         paths.add(pl);
      }
      
      if(p.j!=n-1 && (p.i==m-1  || dp[p.i][p.j+1]==(dpVal-oVal))){
         
         Pair pl = new Pair( p.psf+"H", p.i, p.j+1);
         paths.add(pl);
      } 
      
      
   }



   }



   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }


      minPath(arr);
      //write your code here
      
   }

}
