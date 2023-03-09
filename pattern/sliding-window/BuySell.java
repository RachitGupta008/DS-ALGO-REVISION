import java.util.*;
public class MaxProfit{
   public static int maxProfit(int[] stockPrices) {
      
      // your code will replace this placeholder return statement

      int l=0;
      int r = 1;

      int ans = 0;
      while(r<stockPrices.length){

         if(stockPrices[r]<stockPrices[l]){
            l=r;
         }

         ans = Math.max(ans, stockPrices[r]-stockPrices[l]);

         r++;

      }



      return ans;
   }
}
