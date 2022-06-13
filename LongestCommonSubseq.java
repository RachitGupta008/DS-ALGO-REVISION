import java.io.*;
import java.util.*;

public class Main {

    public static String find(String s1, String s2, Map<String, String> map){

        if(s1.equals("") || s2.equals("")){
            return "";
        }
       else if(map.containsKey(s1+" "+s2)){
            return map.get(s1+" "+s2);
        }

        String ans1 = "";
        

        if(s1.charAt(0) == s2.charAt(0)){

            ans1+=s1.charAt(0);
            ans1+=find(s1.substring(1), s2.substring(1), map);
            
            map.put(s1+" "+s2, ans1);
            return ans1;
           
        }

        String ans2 = find(s1.substring(1), s2.substring(0), map);
        String ans3 = find(s1.substring(0), s2.substring(1), map);
        String finalStr = "";

        if(ans1.length()>ans2.length() && ans1.length()>ans3.length()){
            
            

            finalStr = ans1;
        }else if(ans2.length()>ans1.length() && ans2.length()>ans3.length()){
            finalStr = ans2;
            
        }else{
             finalStr = ans3;
        }
        map.put(s1+" "+s2, finalStr);
        /*
        if(map.containsKey(s1+" "+s2) && (map.get(s1+" "+s2).length())<(finalStr.length())){
                
        }
        */
        return finalStr;

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        Map<String, String> map = new HashMap<>();

        System.out.println(find(s1, s2, map).length());
    }

}
