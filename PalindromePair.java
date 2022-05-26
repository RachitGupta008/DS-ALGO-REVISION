

import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, String asf) {
        //write you code here

        if(str.equals("")){
            System.out.println(asf);
            return;
        }


        for(int i=1;i<=str.length();i++){
            String sub1 = str.substring(0, i);
            String sub2 = str.substring(i);

            if(isPalindrome(sub1)){

                solution(sub2, asf+"("+sub1+") ");
            }
            /*
            int idx1 = asf.lastIndexOf("(");
            if(idx1!=-1){
                String sub = asf.substring(idx1+1, asf.lastIndexOf(")"));
                sub = sub+sub1;
                if(isPalindrome(sub)){
                    String asf1 = asf.substring(0, idx1);
                    solution(sub2, asf1+"("+sub+") ");
                }

            }
            */
        }



    }

    public static boolean isPalindrome(String str){

        int a = 0;
        int b = str.length()-1;

        if(str.equals("")){
            return true;
        }
        else{
            while(b>a){
                if(str.charAt(a)!=str.charAt(b)){
                    return false;
                }
                a++;
                b--;

            }

        }
        return true;

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "");
    }

}
