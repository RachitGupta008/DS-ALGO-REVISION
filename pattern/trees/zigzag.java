public static List<List<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
      if (root == null) {
        return new ArrayList<List<Integer>>();
      }

      Deque<BinaryTreeNode> dq = new LinkedList<BinaryTreeNode>();
      dq.add(root);
      List<List<Integer>> results = new ArrayList<List<Integer>>();

      boolean reverse = false;
      int a = 1;
      while(!dq.isEmpty()){
        int size = dq.size();
        results.add(new ArrayList<Integer>());

        a = a + 1;

        for(int i = 0; i < size; i++){
            if(!reverse){
                BinaryTreeNode node = dq.pollFirst();
                results.get(results.size() - 1).add(node.data);
                if(node.left != null)  dq.addLast(node.left);
                if(node.right != null)  dq.addLast(node.right);
            }
            else{
                BinaryTreeNode node = dq.pollLast();
                results.get(results.size() - 1).add(node.data);
                if(node.right != null)  dq.addFirst(node.right);
                if(node.left != null)  dq.addFirst(node.left);                   
            }
        }

        reverse = !reverse;
        
      }

      return results;
    }
