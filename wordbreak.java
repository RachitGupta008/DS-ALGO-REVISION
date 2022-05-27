import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dict = new HashSet<>();
		for(int i = 0  ; i  < n; i++){
			dict.add(scn.next());
		}
		String sentence = scn.next();
		wordBreak(sentence,"", dict);
	}

	public static void wordBreak(String str, String ans, HashSet<String> dict){
		// write your code here

		if(str.equals("")){
			System.out.println(ans);
		}

		for(int i=1;i<=str.length();i++){
			String sub = str.substring(0, i);

			if(dict.contains(sub)){

				wordBreak(str.substring(i), ans+sub+" ", dict);
			}


		}

	}
		
}
