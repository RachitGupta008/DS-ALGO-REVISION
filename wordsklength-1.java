import java.io.*;
import java.util.*;

public class Main {

 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    Character[] arr = new Character[k];
    permute(arr, 0, ustr, k, 0);
    
  }

  public static void permute(Character[] ch, int l, String s, int ts, int sf){
    //System.out.println(sf + " "+ ts);
    if(sf== ts){
      for(int i=0;i<ch.length;i++){
        System.out.print(ch[i]);
      }
      System.out.println("");
      return;
    }

    if(l==s.length()){
      return;
    }
  char c = s.charAt(l);
  //System.out.println(c);

  for(int i=0;i<ch.length;i++){
    //System.out.println(ch[i]);
    if(ch[i]==null){
      ch[i] = c;
      permute(ch, l+1, s, ts, sf+1);
      ch[i] = null;

    }

  }

  permute(ch, l+1, s, ts, sf);



  }

}
