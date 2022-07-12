import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(numDistinctIslands(arr));

  }

  public static StringBuilder psf = new StringBuilder();

  public static int numDistinctIslands(int[][] arr) {
    //write your code here
    int l = arr.length;
    int c = arr[0].length;
    HashSet<String> set = new HashSet();

    for(int i=0;i<l;i++){
      for(int j=0;j<c;j++){
        if(arr[i][j] == 1){
          psf = new StringBuilder("x");
          dfs(arr, i, j, psf);
          if(!set.contains(psf.toString())){
            set.add(psf.toString());
          }
          
        }
      }
    }
    //System.out.println(set);
    return set.size();
  }

  public static void dfs(int[][] arr, int i, int j, StringBuilder psf){

    arr[i][j] = 0;

    //System.out.println(i+" "+j);

    if(i-1>=0 && arr[i-1][j] == 1){

      psf.append("t");
      dfs(arr, i-1, j, psf);

    }
    if(j+1<=arr[0].length-1 && arr[i][j+1] == 1){

      psf.append("r");
      dfs(arr, i, j+1, psf);

    }
    if(i+1<=arr.length-1 && arr[i+1][j] == 1){

      psf.append("b");
      dfs(arr, i+1, j, psf);

    }
    if(j-1>=0 && arr[i][j-1] == 1){

      psf.append("l");
      dfs(arr, i, j-1, psf);

    }

    psf.append("z");




  }


}
