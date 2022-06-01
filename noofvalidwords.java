
// Furthar optimization, for a puzzle check only the words with first char available for that we can create a Hashmap of Character and List to store the corresponding mapping.
import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        //write your code here

        Integer[] nWords = new Integer[words.length];
        Integer[] nPuzzles = new Integer[puzzles.length];

        Integer[] sWords = new Integer[words.length];
        Integer[] sPuzzles = new Integer[puzzles.length];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<words.length;i++){
            int val = 0;
            for(int j=0;j<words[i].length();j++){
                char ch = words[i].charAt(j);

                int mask = 1 << (int)(ch-'a');
                val = val | mask;


            }
            nWords[i] = val;

        }

        for(int i=0;i<puzzles.length;i++){
            int val = 0;
            for(int j=0;j<puzzles[i].length();j++){
                char ch = puzzles[i].charAt(j);

                int mask = 1 << (int)(ch-'a');
                val = val | mask;


            }
            nPuzzles[i] = val;

        }


        for(int j=0;j<puzzles.length;j++){
            int cnt =0;
            for(int i=0;i<words.length;i++){

                char first = puzzles[j].charAt(0);
                int maskFirst = 1 << (int)(first-'a');

                if(((nWords[i]&maskFirst) == maskFirst) &&
                        ((nPuzzles[j] | nWords[i]) == nPuzzles[j])){
                    cnt++;

                }


            }
            ans.add(cnt);

        }




        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i = 0 ; i < words.length; i++) {
            words[i] = scn.next();
        }
        int m = scn.nextInt();
        String[] puzzles = new String[m];
        for(int i = 0 ; i < m ;i++) {
            puzzles[i] = scn.next();
        }
        ArrayList<Integer> ans = findNumOfValidWords(words,puzzles);
        for(int i=0;i<puzzles.length;i++) {
            System.out.println(puzzles[i] + " -> " + ans.get(i));
        }
    }

}
