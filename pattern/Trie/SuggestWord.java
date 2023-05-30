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

       List<String> suggest(String word){
           Node ptr = root;
           List<String> ans = new ArrayList<>();
           StringBuilder temp = new StringBuilder("");
           for(int i=0;i<word.length();i++){
               char ch = word.charAt(i);
               if(!contains(ptr, ch)){
                   return ans;
               }
             temp = temp.append(ch);
            // System.out.println(temp.toString());
             ptr = ptr.nodes[ch-'a'];
           }
        
           find(ptr, ans, temp);
           return ans;


       }

       private void find(Node start, List<String> ans,StringBuilder temp){
           if(ans.size()==3){
               return;
           }

           if(start.isWord){
               ans.add(temp.toString());
           }

           for(int i=0;i<26;i++){
               if(start.nodes[i]!=null){
                   temp.append((char)('a'+i));
                   find(start.nodes[i], ans, temp);
                   temp.deleteCharAt(temp.length() - 1);
               }

           } 


       }
    }



    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for(int i=0;i<products.length;i++){
            trie.insert(products[i]);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=1;i<=searchWord.length();i++){
            String s = searchWord.substring(0, i);
            List<String> temp = trie.suggest(s);
            ans.add(temp);

        }
        return ans;
        
    }
}
