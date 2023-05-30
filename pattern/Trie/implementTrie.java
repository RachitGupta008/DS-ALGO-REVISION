class Trie {
    class Node{
        Node node[];
        boolean flag;

        Node(){
            node = new Node[26];
            flag = false;
        }
    boolean containsKey(char ch){

        return node[ch-'a']!=null;
    }

    void put(char ch, Node n){
        node[ch-'a'] = n;
    }
    Node get(char ch){
        return node[ch-'a'];
    }
    }
    
    Node root;

    public Trie() {
        root = new Node();
    }
    

   
    public void insert(String word) {
        Node ptr = root;

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!ptr.containsKey(ch)){

                ptr.put(ch, new Node());
            }
            ptr = ptr.get(ch);

        }

       ptr.flag = true; 

    }
    
    public boolean search(String word) {
        Node ptr = root;

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!ptr.containsKey(ch)){
                return false;
            }
            ptr = ptr.get(word.charAt(i));
        }

        return ptr.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node ptr = root;

        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!ptr.containsKey(ch)){
                return false;
            }
            ptr = ptr.get(prefix.charAt(i));
        }

        return ptr!=null;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
