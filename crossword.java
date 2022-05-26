package com.company.Crossword;

import java.io.*;
import java.util.*;

public class Main {

    public static void solution(char[][] arr, String[] words, int vidx) {
        //write your code here

        if(vidx == words.length){
            // System.out.println("hello");
            print(arr);
            return;
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                int cnt=0;
                if(canPlaceH(arr, words[vidx], i, j)){
                    boolean word[] = new boolean[words[vidx].length()];
                    cnt=0;
                    for(int k=j;k<j+words[vidx].length();k++){

                        if(arr[i][k]!='+' && arr[i][k]!='-'){
                            word[cnt] = true;
                        }else{
                            arr[i][k] = words[vidx].charAt(cnt);
                        }
                        cnt++;
                    }
                    solution(arr, words, vidx+1);

                    cnt = 0;
                    for(int k=j;j+k<words[vidx].length();k++){
                        if(!word[cnt]){
                            arr[i][k] = '-';
                        }
                        cnt++;
                    }

                }

                if(canPlaceV(arr, words[vidx], i, j)){
                    boolean word[] = new boolean[words[vidx].length()];
                    for(int k=i;k<i+words[vidx].length();k++){

                        if(arr[k][j]!='+' && arr[k][j]!='-'){
                            word[cnt] = true;
                        }else{
                            arr[k][j] = words[vidx].charAt(cnt);
                        }
                        cnt++;
                    }
                    solution(arr, words, vidx+1);
                    cnt = 0;
                    for(int k=i;k<i+words[vidx].length();k++){
                        if(!word[cnt]){
                            arr[k][j] = '-';
                        }
                        cnt++;
                    }
                }

            }
        }


    }

    public static boolean canPlaceH(char[][] arr, String word, int i, int j){
        if(arr[i][j]=='+'){
            return false;
        }

        if(j>0 && (arr[i][j-1]=='-' || arr[i][j-1]!='+' )){
            return false;
        }

        int k=j;
        int cnt = 0;
        while((k<arr[i].length && (arr[i][k]=='-' || arr[i][k]!='+'))){
            if(!(cnt<word.length())){
                return false;
            }else{
                if((arr[i][k]!='-' && arr[i][k]!=word.charAt(cnt))){
                    return false;
                }

            }
            cnt++;
            k++;
        }

        if(cnt!=word.length()){
            return false;
        }
        return true;

    }

    public static boolean canPlaceV(char[][] arr, String word, int i, int j){
        if(arr[i][j]=='+'){
            return false;
        }

        if(i>0 && (arr[i-1][j]=='-' || arr[i-1][j]!='+')){
            return false;
        }

        int k=i;
        int cnt = 0;
        while((k<arr.length && (arr[k][j]=='-' || arr[k][j]!='+'))){

            if(!(cnt<word.length())){
                return false;
            }else{
                if((arr[k][j]!='-' && arr[k][j]!=word.charAt(cnt))){
                    return false;
                }

            }
            cnt++;
            k++;
        }

        if(cnt!=word.length()){
            return false;
        }
        return true;
    }






    public static void print(char[][] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            for (int j = 0 ; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0 ; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0 ; i  < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);
    }
}
