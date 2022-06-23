import java.util.Scanner;
public class Main{
    public static int solution(int m , int[] x, int[] rev, int t) {
        // write your code here
        int[] dp = new int[m+1];
        int j = rev.length-1;
        for(int i=m;i>=0;i--){
            
            if(j>=0 && i==x[j]){
                int temp = (i+t+1<=m)?dp[i+t+1]:0;
                dp[i] = Math.max(rev[j]+temp, i+1<=m?dp[i+1]:0);
                j--;

            }else{

                dp[i] = i+1<=m?dp[i+1]:0;
            }



        }




        return dp[0];
    }
    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}
