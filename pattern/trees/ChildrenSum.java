The overall intuition of the code is to modify the binary tree such that the data of each node is replaced with the sum of its child nodes' data, but only if the sum is greater than the original data of the node. This transformation is applied recursively to each node in the tree, starting from the root.



static void reorder(Node  root) {
  if (root == null) return;
  int child = 0;
  if (root . left!=null) {
    child += root . left . data;
  }
  if (root . right!=null) {
    child += root . right . data;
  }
  
  // We do the below step to remove the chance where root needs to decrease based upon child since child is set based on root this removed the possibility

  if (child < root . data) {
    if (root . left!=null) root . left . data = root . data;
    else if (root . right!=null) root . right . data = root . data;
  }

  reorder(root . left);
  reorder(root . right);

  int tot = 0;
  if (root . left!=null) tot += root . left . data;
  if (root . right!=null) tot += root . right . data;
  if (root . left!=null || root . right!=null) root . data = tot;
}
