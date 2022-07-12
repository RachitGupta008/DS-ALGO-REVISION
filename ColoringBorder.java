import java.util.*;
import java.io.*;
public class Main {

  
  
  public static void coloring_border(int [][] arr, int row, int col , int color){

    int iClr = arr[row][col];

    Pair p = new Pair(row, col);
    Stack<Pair> stk = new Stack<>();
    stk.push(p);
    boolean[][] visited = new boolean[arr.length][arr[0].length];

    Dfs(p, arr, visited, iClr, color);




      
  }
  static int[][] dir = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
  public static void Dfs(Pair p,int[][] arr, boolean[][] visited, int clr, int nClr){
    int row = p.r;
    int col = p.c;
    

    visited[row][col] = true;
    if(row==0 || row==arr.length-1 || col == 0 || col==arr[0].length-1 ){
      arr[row][col] = nClr;

    }else{
      //System.out.println(col == arr[0].length);
      boolean l = !visited[row][col-1] && arr[row][col-1]!=clr;
      boolean r = !visited[row][col+1] && arr[row][col+1]!=clr;
      boolean t = !visited[row-1][col] && arr[row-1][col]!=clr;
      boolean b = !visited[row+1][col] && arr[row+1][col]!=clr;

      
      if(l || r || t || b){
        arr[row][col] = nClr;
      }

    }


    for(int i=0;i<dir.length;i++){
      int rdash = row + dir[i][0];
      int cdash = col + dir[i][1];

      if(rdash<0 || rdash==arr.length || cdash<0 || cdash==arr[0].length 
      || visited[rdash][cdash] || clr!= arr[rdash][cdash]){
        continue;
      }
      Dfs(new Pair(rdash, cdash), arr, visited, clr, nClr);

    }
    



  }
  

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);

    int[][] arr = new int[m][n];

    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }
    st = br.readLine().split(" ");
    int row = Integer.parseInt(st[0]);
    int col = Integer.parseInt(st[1]);
    int color = Integer.parseInt(st[2]);
    
    
    
    coloring_border(arr,row,col,color);
    
    
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(arr[i][j]+"\t");
      }
      System.out.println();
    }
  }
  
}

class Pair{
    int r;
    int c;
    
    Pair(int r, int c){
      this.r = r;
      this.c = c;
    }
  }
