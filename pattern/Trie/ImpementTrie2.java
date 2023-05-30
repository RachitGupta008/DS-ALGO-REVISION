import java.util.*;
class Node {
    Node links[] = new Node[26]; 
    int cntEndWith = 0;
    int cntPrefix = 0;
    
    public Node() {  
    }
    
    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null); 
    }
    Node get(char ch) {
        return links[ch-'a']; 
    }
     void put(char ch, Node node) {
        links[ch-'a'] = node; 
        
    }
     void increaseEnd() {
        cntEndWith++;  
    }
     void increasePrefix() {
        cntPrefix++; 
    }
     void deleteEnd() {
        cntEndWith--; 
    }
     void reducePrefix() {
        cntPrefix--; 
    }
     int getEnd() {
        return cntEndWith; 
    }
     int getPrefix() {
        return cntPrefix; 
    }
}
public class Trie {
    private Node root; 

    //Initialize your data structure here

    Trie() {
        root = new Node(); 
    }


    //Inserts a word into the trie

    public void insert(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node()); 
            }
            node = node.get(word.charAt(i)); 
            node.increasePrefix(); 
        }
        node.increaseEnd(); 
    }


    public int countWordsEqualTo(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            }
            else {
                return 0; 
            }  
        }
        return node.getEnd(); 
    }

    public int countWordsStartingWith(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            }
            else {
                return 0; 
            }  
        }
        return node.getPrefix(); 
    }

    public void erase(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reducePrefix(); 
            }
            else {
                return;
            }
        }
        node.deleteEnd(); 
    }
 public static void main(String args[]) {
  Trie T=new Trie();
  T.insert("apple");
  T.insert("apple");
  T.insert("apps");
  T.insert("apps");
  String word1 = "apps";
  System.out.println("Count Words Equal to "+word1+" "+T.countWordsEqualTo(word1));
  String word2 = "abc";
  System.out.println("Count Words Equal to "+word2+" "+T.countWordsEqualTo(word2));
  String word3 = "ap";
  System.out.println("Count Words Starting With "+word3+" "+T.countWordsStartingWith
  (word3));
  String word4 = "appl";
  System.out.println("Count Words Starting With "+word4+" "+T.countWordsStartingWith
  (word4));
  T.erase(word1);
  System.out.println("Count Words equal to "+word1+" "+T.countWordsEqualTo(word1));
  
}

}
