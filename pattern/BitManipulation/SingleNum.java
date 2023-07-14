 public static int singleNumber(int[] nums){
        // Initialize the result variable with a 0 value
        int result = 0;
        // Loop through every element
        for (int num: nums) {
            // Take bitwise xor of all elements with the result
            result ^= num;
        }
        // return the result that contains single number
        return result;
