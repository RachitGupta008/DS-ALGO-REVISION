import java.io.*;
import java.util.*;

public class Main {

    public static int solution(long n) {
        //write your code here
    int cnt = 0;

        while(n!=1){
            if(n%2==0){
                n = n/2;
            }
            else if(n==3){
                n = n-1;
            }
            else if(n%4==1){
                n = n-1;
            }
            else if(n%4==3){
                n = n+1;
            }
            cnt++;
        }


            


        return cnt;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        System.out.println(solution(n));
    }
	
	
}
