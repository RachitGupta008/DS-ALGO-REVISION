/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Similar to the diameter approach nothing fancy
class Solution {

    
    
    public int maxPathSum(TreeNode root) {

     int max[] = new int[1];
     max[0]=Integer.MIN_VALUE;
     mp(root, max);
     return max[0];
    
    }

    public int mp(TreeNode root, int[] max){

        if(root==null){
            return 0;
        }

        int l = mp(root.left, max);
        int r = mp(root.right, max);
        int ans = Math.max(root.val,root.val+Math.max(l,r));
        max[0] = Math.max(l+r+root.val,Math.max(ans, max[0]));

        return ans;

    }
}
