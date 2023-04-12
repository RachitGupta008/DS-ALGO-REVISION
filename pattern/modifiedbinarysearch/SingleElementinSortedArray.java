   public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            // Calculating mid point
           
            int mid = l + (r - l) / 2;
         // with this we are making sure the left/right side of mid always have even elements
          // we stand at middle
          if (mid % 2 == 1) mid--;
            // If the element at mid and mid + 1 are the same then
            // the single element must be after the mid point
          // Since right side of mid has even elements and if we match the first element on the right side
          // it implies that right is left with only odd no of elemnents so potential answer reside here
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                // Otherwise we must search before the mid point
              // if we don't match the first element on the right
              // this means answer in on the left side in <=Mid point because left side+Middle element == odd no of elems so answer reside there
                r = mid;
            }
        }
        return nums[l];
    }
