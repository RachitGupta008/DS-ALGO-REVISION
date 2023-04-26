import java.util.*;
public class JumpGame2{
   public static int jumpGame2(int[] nums) {
      
      int i=0;
        int cnt = 0;

        while(i<nums.length-1 && nums[i]!=0 ){
            int max = 0;
            int maxi = i;
            for(int j=1;j<=nums[i];j++){
                if(i+j==nums.length-1){
                    cnt++;
                    return cnt;
                }
                if(max<i+j+nums[i+j]){
                    max = i+j+nums[i+j];
                    maxi = j;
                }
            }
            cnt++;
            i = i+maxi;


        }

        if(i<nums.length-1 && nums[i]==0){
            return -1;
        }
        return cnt;
   }
}
// Two approaches

class Solution {
    public int jump(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;
        
        for (int i = 0; i < n - 1; ++i) {
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }
        
        return answer;
    }
}
