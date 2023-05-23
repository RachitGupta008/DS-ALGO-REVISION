import java.util.*;
public class InvertTree{
    public static BinaryTreeNode invertTree(BinaryTreeNode root) {
      
    // Write your code here

    if(root == null){
      return root;
    }

  BinaryTreeNode l = invertTree(root.left);
  BinaryTreeNode r = invertTree(root.right);


  root.left = r;
  root.right = l;


    return root;
  }
}
