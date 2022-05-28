import java.io.*;
import java.util.*;

public class Main {

  public static void generateWords(int cc, String str, Character[] spots, 
                                   HashMap<Character, Integer> lastOccurence) {


    // write your code here
    if(cc == str.length()){
      for(int i=0;i<spots.length;i++){
        System.out.print(spots[i]);
      }
      System.out.println();
      return;
    }


    char c = str.charAt(cc);
    for(int i=lastOccurence.get(c)+1;i<spots.length;i++){
      //System.out.println(spots[i]);
      if(spots[i]==null){
        spots[i] = c;
        int lc = lastOccurence.get(c);

        lastOccurence.put(c, i);
        generateWords(cc+1, str, spots, lastOccurence);

        spots[i] = null;
        lastOccurence.put(c, lc);

      }


    }


  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Character[] spots = new Character[str.length()];
    HashMap<Character, Integer> lastOccurence = new HashMap<>();
    for(char ch: str.toCharArray()){
      lastOccurence.put(ch, -1);
    }

    generateWords(0, str, spots, lastOccurence);
  }

}
