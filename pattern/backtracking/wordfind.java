The time complexity of the exist method is O(NM3^L), where N and M are the dimensions of the board, and L is the length of the target word. The algorithm explores each cell on the board as a starting point, and for each starting point, it makes at most 3 recursive calls (since the algorithm cannot backtrack to the previous cell), and it needs to check if the current cell matches the corresponding character in the target word. Therefore, the overall time complexity of the algorithm is proportional to the number of cells on the board multiplied by the number of recursive calls made for each cell, which is 3^L.

The space complexity of the algorithm is O(N*M), which is the space required to store the vis boolean array that keeps track of whether each cell on the board has been visited or not. Additionally, the recursive calls made by the algorithm will also consume space on the stack proportional to the length of the target word, which is at most L. Therefore, the overall space complexity of the algorithm is proportional to the size of the board.
  
  
  
  

  class Solution {
    int[][] dir = {{1,0}, {-1, 0}, {0, 1}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){

                if(word.charAt(0)==board[i][j]){
                    vis[i][j] = true;
                    if(f(board, vis,word,  1, i, j)){
                        return true;
                    }
                    vis[i][j] = false;

                }


            }
        }
        return false;


    }

    boolean f(char[][] board, boolean [][] vis, String word, int i, int r, int c){
        
        if(i==word.length()){
            return true;
        }


        for(int j=0;j<dir.length;j++){
            int rd = r + dir[j][0];
            int cd = c + dir[j][1];

            if(rd>=0 && rd<board.length && cd>=0 && cd <board[0].length && word.charAt(i)==board[rd][cd] && !vis[rd][cd]){
                vis[rd][cd] = true;
                if(f(board, vis, word, i+1, rd, cd)){
                    return true;
                }
                vis[rd][cd] = false;

            }


        }

    return false;


    }
}
