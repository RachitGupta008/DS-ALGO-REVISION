

import java.io.*;
import java.util.*;

public class Main {
    public static boolean isPossible(char ch, char[][] arr, char[][] ans, int row, int col){
        int r =0;
        int c = 0;
        if(ch=='+'){
            if(ans[row][col] == 'X'){
                if(col-1>=0 && ans[row][col-1]=='+'){
                    return false;
                }
                if(row-1>=0 && ans[row-1][col]=='+'){
                    return false;
                }

                if(row+1<ans.length && ans[row+1][col]=='+'){
                    return false;
                }
                if(col+1<ans[row].length && ans[row][col+1]=='+'){
                    return false;
                }

            }else{
                return false;
            }

        }else{


            if(ans[row][col] == 'X'){
                if(col-1>=0 && ans[row][col-1]=='-'){
                    return false;
                }
                if(row-1>=0 && ans[row-1][col]=='-'){
                    return false;
                }

                if(row+1<ans.length && ans[row+1][col]=='-'){
                    return false;
                }
                if(col+1<ans[row].length && ans[row][col+1]=='-'){
                    return false;
                }



            }else{
                return false;
            }


        }
    return true;
    }

    public static boolean isValidAnswer(char[][] ans,int[] top, int[] left, int[] right, int[] bottom){
    int ansPlusV = 0;
    int ansPlusH = 0;
    int ansMinusH = 0;
    int ansMinusV = 0;

    for(int i=0;i<ans[0].length;i++){
        for(int j=0;j<ans.length;j++){
            if(ans[j][i]=='+'){
                ansPlusV++;
            }
            if(ans[j][i]=='-'){
                ansMinusV++;
            }

        }
        if(top[i]!=-1 && top[i]!=ansPlusV){
            return false;
        }
        if(bottom[i]!=-1 && bottom[i]!=ansMinusV){
            return false;
        }
        ansPlusV =0;
        ansMinusV =0;

    }

    for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                if(ans[i][j]=='+'){
                    ansPlusH++;
                }
                if(ans[i][j]=='-'){
                    ansMinusH++;
                }

            }
            if(left[i]!=-1 && left[i]!=ansPlusH){
                return false;
            }
            if(right[i]!=-1 && right[i]!=ansMinusH){
                return false;
            }
            ansPlusH =0;
            ansMinusH =0;

        }

        return true;
    }

    public static boolean solution(char[][] arr, int[] top, int[] left, int[] right, int[] bottom, char[][] ans,
                                   int row, int col) {

        //write your code here
        if(row == arr.length){
            if(isValidAnswer(ans, top, left, right , bottom)){
                return true;
            }else{
                return false;
            }


        }



        char ch = arr[row][col];
        boolean cond = (col == arr[row].length-2);
        boolean cond1 = (col == arr[0].length-1);
        if(ch=='L'){
            if(isPossible('+', arr, ans, row, col) && isPossible('-', arr, ans, row, col+1)) {
                //Place plus
                ans[row][col] = '+';
                ans[row][col + 1] = '-';
                //for row and cols

                boolean ansPlus = solution(arr, top, left, right, bottom, ans, cond ? row + 1 : row, cond ? 0 : col + 2);

                if (ansPlus) {
                    return true;
                }

                ans[row][col] = 'X';
                ans[row][col + 1] = 'X';
            }

            if(isPossible('-', arr, ans, row, col) && isPossible('+', arr, ans, row, col+1)){
                //Place plus
                ans[row][col] = '-';
                ans[row][col+1] = '+';
                //for row and cols

                boolean ansMinus = solution(arr, top, left, right, bottom, ans, cond?row+1:row, cond?0:col+2);

                if(ansMinus){
                    return true;
                }

                ans[row][col] ='X';
                ans[row][col+1] = 'X';

                }

        }else if(ch=='T'){
            if(isPossible('+', arr, ans, row, col) && isPossible('-', arr, ans, row+1, col)) {
                //Place plus
                ans[row][col] = '+';
                ans[row+1][col] = '-';
                //for row and cols

                boolean ansPlus = solution(arr, top, left, right, bottom, ans, cond1 ? row + 1 : row, cond1 ? 0 : col + 1);

                if (ansPlus) {
                    return true;
                }

                ans[row][col] = 'X';
                ans[row+1][col] = 'X';
            }

            if(isPossible('-', arr, ans, row, col) && isPossible('+', arr, ans, row+1, col)){
                //Place plus
                ans[row][col] = '-';
                ans[row+1][col] = '+';
                //for row and cols

                boolean ansMinus = solution(arr, top, left, right, bottom, ans, cond1?row+1:row, cond1?0:col+1);

                if(ansMinus){
                    return true;
                }

                ans[row][col] ='X';
                ans[row+1][col] = 'X';

            }
        }

        boolean ansNormal = solution(arr, top, left, right, bottom, ans, cond1?row+1:row, cond1?0:col+1);
        if(ansNormal){
            return true;
        }

        return false;
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        char[][] arr = new char[m][n];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = scn.nextInt();
        }
        int[] left = new int[m];
        for (int i = 0; i < m; i++) {
            left[i] = scn.nextInt();
        }
        int[] right = new int[m];
        for (int i = 0; i < m; i++) {
            right[i] = scn.nextInt();
        }
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            bottom[i] = scn.nextInt();
        }

        char[][] ans = new char[m][n];
        for (int i = 0; i < ans.length; i++) {
            for(int j=0;j<ans[i].length;j++){
                ans[i][j] = 'X';
            }
        }
        boolean sol = solution(arr, top, left, right , bottom , ans, 0, 0);
        if(sol==false){
            System.out.println("No Solution");
        }else{
          print(ans);  
        }

        
        //write your code here
    }


}
