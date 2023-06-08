import java.util.*;
public class Main{
    // Tip: You may use some of the code templates provided
    // in the support files
  
    public static boolean permutePalindrome(String st) {

        // Write your code here
        Set<Character> set = new HashSet<>();
        int cnt= 0;

        for(int i=0;i<st.length();i++){
            char ch = st.charAt(i);

            if(set.contains(ch)){
                cnt = cnt+2;
                set.remove(ch);
            }else{
                set.add(ch);
            }


        }

        if(set.size()==1){
            cnt++;
        }
    
        return cnt==st.length();
    }
}
