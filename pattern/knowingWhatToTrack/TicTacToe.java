// The trick is to not use the full board but keep a tracker
// this helps us check whether a player has won or not in O(1) time 

class TicTacToe {
  List < Integer > rows;
  List < Integer > cols;
  int diagonal = 0;
  int antiDiagonal = 0;
  
  public TicTacToe(int n) {
    this.rows = new ArrayList < Integer > (Collections.nCopies(n, 0));
    this.cols = new ArrayList < Integer > (Collections.nCopies(n, 0));
    this.diagonal = 0;
    this.antiDiagonal = 0;
  }

  public static String repeat(String str, int pValue) {
    String out = "";
    for (int i = 0; i < pValue; i++) {
      out += str;
    }
    return out;
  }

  public int move(int row, int col, int player) {

    int currentPlayer = -1;
    if(player == 1)
        currentPlayer = 1;
   
    this.rows.set(row, this.rows.get(row) + currentPlayer);
    this.cols.set(col, this.cols.get(col) +currentPlayer);
  
    if (row == col)
        this.diagonal += currentPlayer;
    
    if (col == (this.cols.size() - row - 1))
        this.antiDiagonal += currentPlayer;
    
    int n = this.rows.size();

    if (Math.abs(this.rows.get(row)) == n || Math.abs(this.cols.get(col)) == n || Math.abs(this.diagonal) == n || Math.abs(this.antiDiagonal) == n) return player;
    return 0;
  }
