class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        //int temp;
        for(int i=1;i<nums.length;i++) {
            /*
            if(nums[i]<0) {
                temp = max;
                max = min;
                min = temp;
            }
            */
            // Better solution for inituition
            int temp = max;
            max = Integer.max(Integer.max(nums[i],nums[i]*max), nums[i]*min);
            min = Integer.min(nums[i]*temp,Integer.min(nums[i],nums[i]*min));
            ans = Integer.max(ans,max);
        }
       // System.out.println(max);
       // System.out.println(min);
        return ans;
    }
}
