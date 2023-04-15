Time complexity: O(n! * n), where n is the length of the input array nums. This is because there are n! possible permutations, and for each permutation, we spend O(n) time copying the list in the base case (ans.add(new ArrayList(temp))).

Space complexity: O(n! * n), as we store n! permutations, each of length n. Additionally, we have the recursion stack with a maximum depth of n, so the overall space complexity is O(n! * n + n) which simplifies to O(n! * n).

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // To store the final permutations
        Arrays.sort(nums); // Sort the array to handle duplicates
        f(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }

    void f(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> ans) {
        // Base case: when the temporary list 'temp' has the same length as the input array
        if (temp.size() == nums.length) {
            ans.add(new ArrayList(temp)); // Add the permutation to the answer list
        }

        // Iterate through the input array
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) { // Check if the element at index 'i' has been used in the current permutation

                // If the current element is the same as the previous element and the previous element hasn't been used,
                // skip the current iteration to avoid duplicates
                if (i > 0 && !used[i - 1] && nums[i - 1] == nums[i]) {
                    continue;
                }

                used[i] = true; // Mark the current element as used
                temp.add(nums[i]); // Add the current element to the temporary list 'temp'
                f(nums, used, temp, ans); // Recursively generate permutations
                temp.remove(temp.size() - 1); // Remove the last element from 'temp' to backtrack
                used[i] = false; // Mark the current element as unused for the next iteration
            }
        }
    }
}
