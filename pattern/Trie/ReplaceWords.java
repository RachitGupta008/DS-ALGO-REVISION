class Solution {

    class Node {
        boolean isWord;
        Node nodes[];

        Node(){
            nodes = new Node[26];
            isWord = false;
        }
    }

    class Trie {
        Node root;
        Trie(){
            root = new Node();
        }
        boolean contains(Node node, char ch){
            return node.nodes[ch-'a']!=null;
        }

       void insert(String word){

           Node ptr = root;

           for(int i=0;i<word.length();i++){
               char ch = word.charAt(i);
               if(!contains(ptr, ch)){
                   ptr.nodes[ch-'a'] = new Node();
               }

             ptr = ptr.nodes[ch-'a'];
           }

           ptr.isWord = true;
       }
      String replace(String word){
           Node ptr = root;
           String wtn = "";
           for(int i=0;i<word.length();i++){
               char ch = word.charAt(i);
               if(ptr.isWord){
                   return wtn;
               }
               
               if(!contains(ptr, ch)){
                   return word;
               }

              wtn = wtn + ch;
              ptr = ptr.nodes[ch-'a'];
           }

           return word;

      }
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        for(String s : dictionary ){
            trie.insert(s);
        }

        String[] sent = sentence.split(" ");
        String ans="";
        for(String s : sent){
            ans = ans + " " + trie.replace(s);

        }

        return ans.substring(1, ans.length());

        
    }
}
