import java.io.*;

import java.util.*;

public class Main {
    public static int solution(String s, String t, int si, int ti) {
		// write your code here
		
	if (si == s.length()) {
      if (ti < t.length()) {
        return 0;
      }
      else {
        return 1;
      }
    }
    else if (ti == t.length()) {
      return 1;
    }
		
		
		
		char ch1 = s.charAt(si);
		char ch2 = t.charAt(ti);
		
		int tw = 0;
		
		if(ch1 == ch2){
		    int tw1 = solution(s, t, si + 1, ti);
         int tw2 = solution(s, t, si + 1, ti + 1);
            tw = tw1 + tw2;
		    
		    
		}else{
		    tw=solution(s, t, si+1, ti);
		}
		
		
		return tw;
	}

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String
    s1 = scn.next();
    String s2 = scn.next();
    System.out.println(solution(s1, s2, 0, 0));
  }
}
