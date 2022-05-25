import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String[] words, int[] farr, int[] score, int idx) {
		//write your code here
		if(idx==words.length){
			return 0;

		}

		int mScore = 0;
		int yScore = 0;	
		
		if(possible(farr, words[idx])){
			
			int scr = 0;
			for(int i=0;i<words[idx].length();i++){
			char ch = words[idx].charAt(i);
			farr[ch - 'a']--;
			scr = score[ch-'a']+scr;
		}
			
			yScore = scr + solution(words, farr, score, idx+1);

			for(int i=0;i<words[idx].length();i++){
			char ch = words[idx].charAt(i);
			farr[ch - 'a']++;
			scr = score[ch-'a']+scr;
		}

		}
		int nScore = solution(words, farr, score, idx+1);

		mScore = Math.max(nScore, yScore);
		return mScore;
	}

	public static boolean possible(int[] farr, String word){
		int[] nArr = farr.clone();

		for(int i=0;i<word.length();i++){
			char ch = word.charAt(i);
			nArr[ch - 'a']--;
			if(nArr[ch - 'a'] == -1){
				return false;
			}
		}
		return true;
	}



	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution(words, farr, score, 0));

	}
}
