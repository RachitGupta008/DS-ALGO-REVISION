/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null){
            return root;
        }

        Queue<Node> q = new ArrayDeque<>();

        q.add(root);

        while(!q.isEmpty()){

            int l = q.size();
            for(int i=0;i<l;i++){
                Node n = q.remove();
                if(i!=(l-1)){
                    n.next = q.peek();
                }

                if(n.left!=null){
                    q.add(n.left);
                }

                if(n.right!=null){
                    q.add(n.right);
                }

            }


        }
        return root;
    }


}


// connect all siblings

public static void populateNextNodePointers(BinaryTreeNode root) {
		// Write your code here

		if(root == null){
            return;
        }

        Queue<BinaryTreeNode> q = new ArrayDeque<>();

        q.add(root);

        while(!q.isEmpty()){

            int l = q.size();
            for(int i=0;i<l;i++){
                BinaryTreeNode n = q.remove();
                
                   
                

                if(n.left!=null){
                    q.add(n.left);
                }

                if(n.right!=null){
                    q.add(n.right);
                }
				 n.next = q.peek();
            }


        }
	}



