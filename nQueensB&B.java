#Branch and bound algo for Nqueens

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    nQueens(board, 0, 0, new boolean[n], new boolean[2*n-1], new boolean[2*n-1], "");
    //write your code here


    
  }

  public static void nQueens(boolean[][] board, int r, int col,
  boolean[] cols, boolean[] rdiag, boolean[] ldiag,String asf ){

    if(r==board.length){
      System.out.println(asf+ ".");
      return;
    }


    for(int c=0;c<board.length;c++){

    if(canPlace(board, r, c, cols, rdiag, ldiag)){

      board[r][c] = true;
      cols[c] = true;
      rdiag[r+c] = true;
      ldiag[r-c + (board.length-1)] = true;


      nQueens(board, r+1, c, cols, rdiag, ldiag, asf+r+"-"+c+", ");

      board[r][c] = false;
      cols[c] = false;
      rdiag[r+c] = false;
      ldiag[r-c + (board.length-1)] = false;

    }
    }



  }

  public static boolean canPlace(boolean[][] board, int r, int c,
  boolean[] cols, boolean[] rdiag, boolean[] ldiag){

    return !(cols[c] || rdiag[r+c] || ldiag[r-c + (board.length-1)]);

  }


}
