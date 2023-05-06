O(n), O(1)
Solution {
    public int firstMissingPositive(int[] nums) {
     cyclicSort(nums);

     for(int i=0;i<nums.length;i++){
         if(nums[i] != i+1){
             return i+1;
         }
     }
     return nums.length+1;

    }
    public  void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i]-1;
            if (correctIndex>=0 && correctIndex<nums.length && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    private  void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
