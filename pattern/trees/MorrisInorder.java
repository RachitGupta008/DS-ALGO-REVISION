    void fm(TreeNode root, List<Integer> ans){
        TreeNode c = root;
       
        while(c!=null){
            TreeNode l = c.left;
            if(l==null){
                ans.add(c.val);
                c = c.right;

            }else{
                TreeNode temp = l;
                while(temp.right!=null && temp.right !=c){
                    temp = temp.right;
                }

                if(temp.right==null){
                    temp.right = c;
                    c = l;
                    
                }else{
                    temp.right = null;
                    ans.add(c.val);
                    c=c.right;
                }


            }


        }


    }
