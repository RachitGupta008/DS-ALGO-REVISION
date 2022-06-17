import java.io.*;
import java.util.*;

public class Main {

	public static boolean isScrambleTab(String s1, String s2, Map<String, Boolean> map) {
		//write your code here

		if(s1.equals(s2)){
			return true;
		}
		if(map.containsKey(s1+" "+ s2)){
			return map.get(s1+" "+ s2);
		}
		int l = s1.length();

		for(int i=1;i<s1.length();i++){

			boolean same = isScrambleTab(s1.substring(0, i), s2.substring(0,i), map) 
			&& isScrambleTab(s1.substring(i), s2.substring(i), map);

			if(same){
				map.put(s1+" "+ s2, true);
				return true;
			}

			boolean diff = isScrambleTab(s1.substring(0,i), s2.substring(l-i), map) 
			&& isScrambleTab(s1.substring(i), s2.substring(0,l-i), map);
			if(diff){
				map.put(s1+" "+ s2, true);
				return true;
			}

		}
		map.put(s1+" "+ s2, false);
		return false;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		Map<String, Boolean> map = new HashMap<>();
		System.out.println(isScrambleTab(s1,s2, map));
	}

}
