#Recursion is capable of handling itself if we are able to satisfly the condition before the call.

import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str, String pattern, 
	HashMap<Character,String> map, String op, String os){

		//write your code here
		if(pattern.equals("")){
			if(str.equals("")){
				HashSet<Character> set= new HashSet<>();
					for(int i=0;i<op.length();i++){
						if(!set.contains(op.charAt(i))){
							System.out.print(op.charAt(i)+" -> "+ map.get(op.charAt(i))+", ");
							set.add(op.charAt(i));
						}
					}
					System.out.print(".");
					System.out.println();
			}

			return;

		}
		Character ptrn = pattern.charAt(0);
		if(map.containsKey(ptrn)){
			String val = map.get(ptrn);
			if(str.length()>=val.length()){
				String subVal = str.substring(0, val.length());

			if(subVal.equals(val)){
				solution(str.substring(val.length()), pattern.substring(1), map, op, os);
			}
			}
			

		}

		else{
			for(int i=1;i<=str.length();i++){

			String str1 = str.substring(0, i);
			String str2 = str.substring(i);
			
			

			map.put(ptrn, str1);

			solution(str2,pattern.substring(1), map, op, str);

			map.remove(ptrn);
		}
		}

		

		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern, str);
	}
}
