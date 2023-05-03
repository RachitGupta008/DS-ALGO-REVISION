// If without dp the time comlexity is 2^n since at every level we have 2 choices pick or not pick
// with memoization it reduces to O(nc)
we can prove that the time complexity of the given memoized implementation of the 0/1 Knapsack problem is O(N*C). Let's break down the function and analyze its complexity.

The function f(c, s, weights, values, vtn, dp) is called with parameters:

c: remaining capacity of the knapsack
s: index of the current item
weights: list of weights of items
values: list of values of items
vtn: current total value
dp: a 2D array for memoization
The base case occurs when c == 0 (no remaining capacity) or s >= weights.size() (no items left to consider). In this case, the function returns vtn, the current total value.

The memoization step checks if the value dp[s][c] has been computed before. If it has, the function returns the memoized value.

If the memoization step fails, the function calculates two possibilities:

notpick: The item at index s is not picked. The function calls itself with the same capacity and the next item index (s + 1).
pick: The item at index s is picked if its weight does not exceed the remaining capacity. The function calls itself with the remaining capacity after subtracting the weight of the item at index s and the next item index (s + 1), along with an updated total value.
The memoization array (dp) has dimensions NC, where N is the number of items and C is the capacity of the knapsack. Each cell in the dp array represents a unique subproblem of the form (s, c). Since there are NC possible combinations of s and c, there are N*C unique subproblems.

Due to memoization, each subproblem is computed only once. The time complexity of each subproblem is constant, as the function only performs a constant amount of work outside of the recursive calls (i.e., condition checks, arithmetic operations, and value assignments).

Since each subproblem takes constant time to compute and there are NC subproblems, the overall time complexity of the given memoized implementation is O(NC).


import java.util.*;

public class Main{
   public static int findMaxKnapsackProfit(int capacity, List<Integer> weights, List<Integer> values) {
      
      // Write your code here
      int[][] dp = new int[weights.size()+1][capacity+1];


      
      return f(capacity, 0, weights, values, 0, dp);
   }

   static int f(int c, int s, List<Integer> weights, List<Integer> values, int vtn, int[][] dp){

      if(c==0 || s>=weights.size()){
         return vtn;
      }

      if(dp[s][c]!=0){
         return dp[s][c];
      }


      int notpick = f(c, s+1, weights, values, vtn, dp);
      int pick = 0;
      if(c>=weights.get(s)){
         pick = f(c-weights.get(s), s+1, weights, values, vtn+values.get(s), dp);
      }

      dp[s][c] = Math.max(pick, notpick);
      return dp[s][c];


   }



}



public static int findMaxKnapsackProfit(int capacity, List<Integer> weights, List<Integer> values)
    {
        int valuesLength = values.size();
        if(capacity <= 0 || valuesLength == 0 || weights.size() != valuesLength)
            return 0;
        List<Integer> profits = new ArrayList<Integer>();
        for (int i = 0; i < capacity + 1; i++)
            profits.add(0);
        for (int i = 0; i < valuesLength; i++)
        {
            for (int c = capacity; c >= 0; c--)
            {
                if(weights.get(i) <= c)
                {
                    int newProfit = profits.get(c - weights.get(i)) + values.get(i);
                    profits.set(c, Math.max(profits.get(c), newProfit));
                }
            }
        }
        return profits.get(capacity);
