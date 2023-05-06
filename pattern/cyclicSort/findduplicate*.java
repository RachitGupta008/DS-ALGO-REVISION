// This is based upon the fact that the number at each index if we traverse will appear once only except for duplicate num which will appear twice and thereby forming a cycle.    

public static int findDuplicate(int[] nums) {
        // Intialize the fast and slow pointers and make them point the first
        // element of the array
        int fast = nums[0];
        int slow = nums[0];
        // PART #1
        // Traverse in array until the intersection point is not found
        while (true) {
            // Move the slow pointer using the nums[slow] flow
            slow = nums[slow];
            // Move the fast pointer two times fast as the slow pointer using the 
            // nums[nums[fast]] flow 
            fast = nums[nums[fast]];
            // Break of the slow pointer becomes equal to the fast pointer, i.e., 
            // if the intersection is found
            if (slow == fast) {
                break;
            }

        }
        // PART #2
        // Make the slow pointer point the starting position of an array again, i.e.,
        // start the slow pointer from starting position
        slow = nums[0];
        // Traverse in an array until the slow pointer does not become equal to the
        // fast pointer
        while (slow != fast) {
            // Move the slow pointer using the nums[slow] flow
            slow = nums[slow];
            // Move the fast pointer slower than before, i.e., move the fast pointer
            // using the nums[fast] flow
            fast = nums[fast];
        }
        // Return the fast pointer as it points the duplicate number of the array
        return fast;
    }
