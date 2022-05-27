import java.io.*;
import java.util.*;

public class Main {

	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, 
	Character oddc, String asf) {

		if(cs == ts){

			String rev = "";
			for(int i=asf.length()-1;i>=0;i--){
				rev = rev+ asf.charAt(i);
			}

			if(oddc!='0'){
				rev = oddc + rev;
			}

			System.out.println(asf+rev);
		}

		for(Character c: fmap.keySet()){
			int freq = fmap.get(c);
			if(freq != 0){
				fmap.put(c, freq-1);
				generatepw(cs+1, ts, fmap, oddc, asf+c);
				fmap.put(c, freq);

			}


		}
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}

		int odd=0;
		char oddc = '0';
		int ts =0;

		for(Character c : fmap.keySet()){
			int freq = fmap.get(c);
			if(freq%2==0){
				fmap.put(c, freq/2);
				
			}else{
				odd++;
				oddc = c;

				fmap.put(c, freq/2);
			}
			ts = ts + freq/2;
			if(odd>1){
				System.out.println(-1);
				return;
			}

		}

		generatepw(0, ts, fmap, oddc, "");

		//write your code here
	}
	
}
