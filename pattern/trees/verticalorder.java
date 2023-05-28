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
    // A TreeMap to maintain the vertical order of nodes
    private Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        
        for (TreeMap<Integer, PriorityQueue<Integer>> yMap : map.values()) {
            List<Integer> tempList = new ArrayList<>();
            
            for (PriorityQueue<Integer> nodes : yMap.values()) {
                while (!nodes.isEmpty()) {
                    tempList.add(nodes.poll());
                }
            }
            result.add(tempList);
        }
        return result;
    }
    
    private void traverse(TreeNode root, int x, int y) {
        if (root == null) return;
        
        // Initialize the TreeMap and PriorityQueue if they're not present
        map.computeIfAbsent(x, key -> new TreeMap<>())
           .computeIfAbsent(y, key -> new PriorityQueue<>())
           .add(root.val);
        
        traverse(root.left, x - 1, y + 1);
        traverse(root.right, x + 1, y + 1);
    }
}



class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        // Use BFS: at each level of the tree, record x-coordinate, y-coordinate, and value of each node
        Queue<int[]> queue = new LinkedList<>();
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        queue.offer(new int[]{0, 0, root.val});  // {x-coordinate, y-coordinate, value}

        while (!root.left && !root.right) {
            TreeNode node = root;
            root = null;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] info = queue.poll();
                int x = info[0], y = info[1], val = info[2];

                map.computeIfAbsent(x, k -> new TreeMap<>())
                   .computeIfAbsent(y, k -> new PriorityQueue<>())
                   .add(val);

                if (node.left != null) {
                    queue.offer(new int[]{x - 1, y + 1, node.left.val});
                    root = node.left;
                }
                if (node.right != null) {
                    queue.offer(new int[]{x + 1, y + 1, node.right.val});
                    root = node.right;
                }
            }
        }

        // Build the result
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> yMap : map.values()) {
            List<Integer> level = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : yMap.values()) {
                while (!nodes.isEmpty()) {
                    level.add(nodes.poll());
                }
            }
            result.add(level);
        }
        return result;
    }
}
