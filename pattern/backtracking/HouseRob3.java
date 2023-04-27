The time complexity of the rob method is O(N), where N is the number of nodes in the binary tree. This is because the algorithm visits each node in the binary tree exactly once and performs constant time operations at each node.

The space complexity of the algorithm is O(N), which is the space required to store the map HashMap that keeps track of the maximum amount of money that can be robbed from each node in the binary tree. Additionally, the recursive calls made by the algorithm will also consume space on the stack proportional to the height of the binary tree, which is at most log N for a balanced binary tree, and can be as much as N for a skewed binary tree. Therefore, the overall space complexity of the algorithm is proportional to the size of the binary tree.




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
class Solution {
    Map<TreeNode, int[]> map  =  new HashMap<>(); 
    public int rob(TreeNode root) {
       
        return Math.max(f(root, true), f(root, false));
    }

    int f(TreeNode root, boolean loot){

        if(root == null){
            return 0;
        }
        if(map.containsKey(root)){
            int[] looted = map.get(root);
            if(loot == true && looted[1]!=-1){
                return looted[1];
            }else if(loot==false && looted[0]!=-1){
                return looted[0];
            }
        }
        int [] looted = new int[2];
        looted[0] = -1;
        looted[1] = -1;

        
        



        if(loot==true){
            int lnl = f(root.left, false);
            int rnl =f(root.right, false);
            int amt = root.val;
            looted[1] = amt + rnl + lnl;
            map.put(root, looted);
            return looted[1];

        }else{
            int rl = f(root.right, true);
        
            int ll = f(root.left, true);
            int lnl = f(root.left, false);
            int rnl =f(root.right, false);
           looted[0] = Math.max(ll , lnl)+ Math.max(rl, rnl);
           map.put(root, looted);
           return looted[0]; 
            
        }

        



    }


}
