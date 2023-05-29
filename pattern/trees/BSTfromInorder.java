class Solution {
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {

        return bt(preorder, Integer.MAX_VALUE);
        
        
    }

    public TreeNode bt(int [] preorder, int ub){
        if(idx>=preorder.length|| preorder[idx]>ub){
            return null;
        }

        TreeNode t = new TreeNode(preorder[idx]);
        idx++;
        t.left = bt(preorder, t.val);
        t.right = bt(preorder, ub);

        return t;


    }

    public TreeNode bst(int[] preorder, int s, int e){

        if(s>e){
            return null;
        }

        TreeNode t = new TreeNode(preorder[s]);
        int idx = bsearch(preorder, s, e, t.val);

        t.left = bst(preorder, s+1, idx);
        t.right = bst(preorder, idx+1, e);

        return t;

    }

    public int bsearch(int []preorder, int s, int e, int elem){

        while(s<e){
            int mid = s + (e-s)/2;

            if(preorder[mid]<elem){
                s=mid+1;

            }else{
                e=mid-1;
            }



        }
    return s-1;

    }
}
