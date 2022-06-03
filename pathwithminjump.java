//This is a memoized solution it can also be done by tabulation, first by forming the table and then select all the optimial paths from start using the table.

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

public class Main{


    public static List<List<Integer>> solution(int arr[], int i, Map<Integer,
            List<List<Integer>>> memo){

        if(i==arr.length-1){

            List<Integer> li = new ArrayList<>();
            li.add(i);

            List<List<Integer>> ans = new ArrayList<>();
            ans.add(li);

            return ans;
        }

        if(memo.containsKey(i)){
            return memo.get(i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> ansTemp = new ArrayList<>();
        int mCount = Integer.MAX_VALUE;
        for(int j=1;j<=arr[i];j++){
            if(i+j<arr.length){
                List<List<Integer>> temp = solution(arr, i+j, memo);
                if(temp.size()!=0){
                    mCount = Math.min(temp.get(0).size(), mCount);
                    ansTemp.addAll(temp);
                }
            }


        }

        for(List<Integer> li : ansTemp){

            ArrayList<Integer> llist = new ArrayList<>();

            if(li.size() == mCount){

                for(int k=0;k<li.size();k++){
                    llist.add(li.get(k));
                }
                llist.add(i);
                ans.add(llist);
            }

        }

        memo.put(i, ans);


        return ans;
        // write your code here
    }


    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();


        Map<Integer, List<List<Integer>>> memo = new HashMap<>();

        List<List<Integer>> ans = solution(arr, 0 ,  memo);

        if(ans.size()==0){
            System.out.println(0);
            return;
        }
        System.out.println(ans.get(0).size()-1);
        for(List<Integer> li :  ans){

            for(int i=li.size()-1;i>=0;i--){
                if(i == 0){
                    System.out.print(li.get(i)+" .");
                }else{
                    System.out.print(li.get(i)+" -> ");
                }



            }
            System.out.println();

        }


        scn.close();
    }
}
