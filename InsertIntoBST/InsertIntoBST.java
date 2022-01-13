public class InsertIntoBST {
    static int COUNT = 0;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        insert(root,val);
        return root;
    } 
    public void insert(TreeNode root, int val){
        if(val < root.val) { 
            if(root.left == null) root.left = new TreeNode(val);
            else insert(root.left,  val);
        }
        else {
            if(root.right == null) root.right = new TreeNode(val);
            else insert(root.right,  val);
        }
    }
    public class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
	}
    public String preOrderTraversal(TreeNode root){
        String s = "";
		if(root != null){
			s += root.val + " ";
			if(root.left  != null) s += preOrderTraversal(root.left)  + " ";  else s += "null ";
			if(root.right != null) s += preOrderTraversal(root.right) + " ";  else s += "null ";
		}
	    return s.replaceAll("\\s+"," ").replaceAll("\\s+$","");                                      // $ - end of line
    }
    public TreeNode stringToTreeNode(String str){
        String[] s = str.split(" ");
        if(s.length == 0) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        for(int i = 1; i < s.length; i++) insert(root,Integer.parseInt(s[i]));
        return root;
    }
    public void test(String str,int n, String a) {
        TreeNode root = stringToTreeNode(str);
        root = insertIntoBST(root,n);
        assert(a.equals(preOrderTraversal(root)));
		COUNT++;
	}
    public static void main(String args[]){
        InsertIntoBST i = new InsertIntoBST();
		i.test(" ", 1, "1 null null");
        i.test("4 2 6 1 3", 5, "4 2 1 null null 3 null null 6 5 null null null");
        i.test("2 1", 3, "2 1 null null 3 null null");
        i.test("40 20 60 10 30 50 70", 25, "40 20 10 null null 30 25 null null null 60 50 null null 70 null null");
        System.out.println("Passes: "+ COUNT + " Tests");
    }
}
