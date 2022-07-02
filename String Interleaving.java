import java.io.*;
import java.util.*;

public class Main {

  public static boolean solution(String s1, String s2, String s3, Map<String, Boolean> map) {
    // write your code here

    if(s3.length()==0 && s1.length()==0 && s3.length()==0){

      return true;


    }
    if(s3.length()==0 && !(s1.length()==0 && s2.length()==0)){
      return false;
    }

    if(s3.length()!=0 && (s1.length()==0 && s2.length()==0)){
      return false;
    }

    String key = s1+" "+s2+" "+s3;
    if(map.containsKey(key)){
      return map.get(key);

    }

    if(s1.length()!=0 && s2.length()!=0){
       boolean cond1 = false;
      if(s1.charAt(0) == s3.charAt(0)){

        cond1 = solution(s1.substring(1), s2, s3.substring(1), map);
      }
      boolean cond2 = false;
      if(s2.charAt(0) == s3.charAt(0)){

        cond2 = solution(s1, s2.substring(1), s3.substring(1), map);
      }

      map.put(key, cond1 || cond2);
      return cond1 || cond2;


    }else if(s2.length() == 0){
      boolean cond1 = false;
      if(s1.charAt(0) == s3.charAt(0)){

        cond1 = solution(s1.substring(1), s2, s3.substring(1), map);
      }

      map.put(key, cond1);
      return cond1;

    }else {
        boolean cond2 = false;
      if(s2.charAt(0) == s3.charAt(0)){

        cond2 = solution(s1, s2.substring(1), s3.substring(1), map);
      }
      map.put(key, cond2);
      return cond2;

    }




  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();

    Map<String, Boolean> map = new HashMap<>();
    System.out.println(solution(s1, s2, s3, map));
  }

}
