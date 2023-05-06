    public static int[] findCorruptPair(int[] nums) {
        int i = 0;
        int duplicated = 0;
        int missing = 0;
        int[] pair = {
            0,
            0
        };
        // Apply cyclic sort on the array
        // Traversing the whole array
        while (i < nums.length) {
            // Determining what position the specific element should be at
            int correct = nums[i] - 1;
            //Check if the number is at wrong position
            if (nums[i] != nums[correct]) {
                // Swapping the number to it's correct position
                swap(nums, i, correct);
            } else {
                i = i + 1;
            }
        }
        // Finding the corrupt pair(missing, duplicated)     
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                duplicated = nums[j];
                missing = j + 1;
            }

        }
        pair[0] = missing;
        pair[1] = duplicated;

        return pair;
    }
