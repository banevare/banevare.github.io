import java.util.*;
public class BuildTree {
    static int COUNT = 0;
    // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7] Output: [3,9,20,null,null,15,7]
    public TreeNode buildTree(int[] preorder, int[] inorder) {                                                        // 2 n log(n) --> O(nlogn)
        if(preorder.length == 0)              { System.out.println("EMPTY ERROR");  System.exit(1); }
        if(preorder.length != inorder.length) { System.out.println("LENGTH ERROR"); System.exit(2); }
        TreeNode root = new TreeNode(preorder[0]);
        Map <Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)map.put(inorder[i],i);
        for(int i = 1; i < preorder.length; i++) buildTreeRecursively(inorder,root,preorder[i],map);
        return root;
    }
    public boolean leftTree(Map<Integer, Integer> map, int x,int y) {return map.get(x) < map.get(y);}
    public void buildTreeRecursively(int[] inorder, TreeNode root, int value, Map<Integer, Integer> map){
        if(leftTree(map,value,root.val)) {
            if(root.left != null) buildTreeRecursively(inorder, root.left,value,map);
            else  root.left = new TreeNode(value);
        }
        else{
            if(root.right != null) buildTreeRecursively(inorder, root.right,value,map);
            else root.right = new TreeNode(value);
        }
    }
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
    }
    public static String preOrderTraversal(TreeNode root){
        String s = "";
		if(root != null){
			s += root.val + " ";
			if(root.left  != null) s += preOrderTraversal(root.left)  + " ";  else s += "n ";
			if(root.right != null) s += preOrderTraversal(root.right) + " ";  else s += "n ";
		}
	    return s.replaceAll("\\s+"," ").replaceAll("\\s+$","");                                                       // $ - end of line
    }
    public static int[] toInt(final String s){									                                                    // convert string array to int array
        String[] str = s.split(" ");
        if(s == "") return new int[0];
        int[] arr = new int[str.length];
        if(s == "") return arr;
        for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(str[i]);
        return arr;
	}
    public static void test(String p, String i,String o) {
        assert(o.equals(preOrderTraversal(new BuildTree().buildTree(toInt(p),toInt(i)))));
		COUNT++;
	}
    public static void main(String args[]){
        test("-1", "-1", "-1 n n");
        test("3 9 20 15 7", "9 3 15 20 7", "3 9 n n 20 15 n n 7 n n");
        System.out.println("Passes: "+ COUNT + " Tests");
    }
}
