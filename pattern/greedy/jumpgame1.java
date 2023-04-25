  public static boolean jumpGame(int[] nums) {
    int targetNumIndex = nums.length - 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      if(targetNumIndex <= (i + nums[i]))
      {
        targetNumIndex = i;
      }
    }
    if(targetNumIndex == 0)
        return true;
    return false;
  }

class Solution {
    public boolean canJump(int[] nums) {
        int i=0;

        while(i<nums.length-1 && nums[i]!=0 ){
            int max = 0;
            int maxi = i;
            for(int j=1;j<=nums[i];j++){
                if(i+j==nums.length-1){
                    return true;
                }
                if(max<i+j+nums[i+j]){
                    max = i+j+nums[i+j];
                    maxi = j;
                }
            }

            i = i+maxi;


        }

        if(i<nums.length-1 && nums[i]==0){
            return false;
        }
        return true;
    }
}


class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                // The current position cannot be reached
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
