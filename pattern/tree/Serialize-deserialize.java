//Used similar recursion pattern as diameter
// A val of index that change based upon recursive call

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");

        dfs(root, sb);

        return sb.toString();
    }

    public void dfs(TreeNode root, StringBuilder stream){
        if(root == null){
            stream.append("null");
             stream.append(":");
            return;
        }
        
        stream.append(String.valueOf(root.val));
        stream.append(":");
        dfs(root.left, stream);
        dfs(root.right, stream);

        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] stream = data.split(":");
        //Arrays.stream(stream).forEach(e->System.out.println(e));
        TreeNode n = util(new int[]{0}, stream);
        return n;
        
    }

    public static TreeNode  util(int[] n, String[] stream){
        
        if(n[0]>=stream.length){
            return null;
        }

        String val = stream[n[0]];

        if(val.equals("null") || val.equals("")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        n[0]++;
        node.left = util(n, stream);
        n[0]++;
        node.right = util(n, stream);

        return node;

    }
}
