public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }

        if(p==null || q==null){
            return false;
        }

        boolean l = isSameTree(p.left, q.left);
        boolean r = isSameTree(p.right, q.right);

        return l&r&(p.val==q.val);


    }
