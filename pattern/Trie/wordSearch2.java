class Solution {

    class Node {
        boolean isWord;
        Node[] nodes = new Node[26];

        
    }

    class Trie {
        Node root = new Node();


       void insert(String word){
            Node ptr = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);

                if(ptr.nodes[ch-'a']==null){

                    ptr.nodes[ch-'a'] = new Node();
                }

                ptr = ptr.nodes[ch-'a'];
            }
            ptr.isWord = true;
        }

    }




    public List<String> findWords(char[][] board, String[] words) {
       Set<String> ans = new HashSet<>();
       int[][] dash = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
       boolean[][] vis = new boolean[board.length][board[0].length]; 
        
        Set<String> tu = new HashSet<>();
        Trie trie = new Trie();
        for(String word: words){
            tu.add(word);
            trie.insert(word);
        }
       for(int i=0;i<board.length;i++){
           
           for(int j=0;j<board[i].length;j++){
               
               if(trie.root.nodes[board[i][j]-'a']!=null)
               f(board,  i, j, vis, ans, dash,""+board[i][j] ,trie.root.nodes[board[i][j]-'a']);
               
           }
       } 
      
      
        return ans.stream().collect(Collectors.toList());
        
    }
    
    void f(char[][] board, int i, int j, boolean vis[][], Set<String> ans, int[][] dash, String word,Node node){
            
           

            if(node.isWord){

                ans.add(word);
                
            }
            vis[i][j] = true;
            for(int k=0;k<dash.length;k++){
                int rd = i + dash[k][0];
                int cd = j + dash[k][1];

                if(cond(rd, cd, board) && !vis[rd][cd] && node.nodes[board[rd][cd]-'a']!=null){
                                
                    f(board, rd, cd, vis, ans, dash,word+board[rd][cd], node.nodes[board[rd][cd]-'a']);
                                
                }


            }
            vis[i][j] = false; 
            
        }
    
    boolean cond(int i, int j,char[][] board ){
         if(i>=board.length|| i<0||j>=board[0].length|| j<0){
                return false;
            }
        return true;
    }
}
