public boolean isBalanced(TreeNode root) {
        if(h(root)==-1){
            return false;
        }
        return true;
    }

    int h(TreeNode root){

        if(root==null){
            return 0;
        }

        int lh = h(root.left);
        int rh = h(root.right);

        if(lh==-1||rh==-1|| Math.abs(lh-rh)>1){
            return -1;
        }
        return 1+Math.max(lh, rh);

    }
