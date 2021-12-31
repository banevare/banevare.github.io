public class HasPathSum {
    static int COUNT = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) return false;
		try {preorderTraversal(root,targetSum);}													                        // Can also do root.preorderTraversal(targetSum);
		catch(Found f)	   { System.out.println("Node Val = " + f.val); return true;  }				    // Won't catch exception but Found
		catch(Exception e) { System.out.println("EXCEPTION!");          return false; }													
        return false;
    } 
	public class Found extends Exception{
		int val;
		public Found(int val){
			this.val = val;
		}
	}
	public void preorderTraversal(TreeNode root, int targetSum) throws Found{
		targetSum -= root.val;																		// Calculating new sum to find
		if(targetSum == 0 && root.right == null && root.left == null) throw(new Found(root.val));	
		if (root.left  != null) preorderTraversal (root.left, targetSum);
		if (root.right != null) preorderTraversal(root.right,targetSum);	
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
		public void printInOrder(int depth) {
			if (this.left  != null) this.left.printInOrder (depth + 1);	
			visualizeTree(depth);
			if (this.right != null) this.right.printInOrder(depth + 1);	
		}
		public void printPreOrder(int depth) {
			visualizeTree(depth);
			if (this.left  != null) this.left.printInOrder (depth + 1);
			if (this.right != null) this.right.printInOrder(depth + 1);	
		}
		public void printPostOrder(int depth) {
			if (this.left  != null) this.left.printInOrder (depth + 1);	
			if (this.right != null) this.right.printInOrder(depth + 1);	
			visualizeTree(depth);
		}
		public void visualizeTree(int depth){
			for (int i = 0; i < depth; i++) System.out.print("    ");
			System.out.println(this.val);
		}
		public void preorderTraversal(int targetSum) throws Exception{
			targetSum -= this.val;																	                                // Calculating new sum to find
			if(targetSum == 0)throw(new Exception());
			if (this.left  != null) this.left.preorderTraversal (targetSum);
			if (this.right != null) this.right.preorderTraversal(targetSum);	
		}
	} 
	public TreeNode makeTree1(){
    TreeNode r  = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
    r.left = l2;
		return r;
	}
	public TreeNode makeTree2(){
    TreeNode r  = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode r2 = new TreeNode(3);
    r.left  = l2;
		r.right = r2;
		return r;
	}
    public TreeNode makeTree(){
      TreeNode r  = new TreeNode(5);
      TreeNode l2 = new TreeNode(4);
      TreeNode r2 = new TreeNode(8);
      TreeNode l3 = new TreeNode(11);
      TreeNode l4 = new TreeNode(13);
      TreeNode r4 = new TreeNode(4);
      TreeNode l5 = new TreeNode(7);
      TreeNode r5 = new TreeNode(2);
      TreeNode r6 = new TreeNode(1);
      r.left   = l2;
      r.right  = r2;
      l2.left  = l3;
      l3.left  = l5;
      l3.right = r5;
      r2.left  = l4;
      r2.right = r4;
      r4.right = r6;
		  return r;
	}
    public static void test(TreeNode root, int targetSum, boolean a) {
      assert(a == new HasPathSum().hasPathSum(root, targetSum));
		  COUNT++;
	}
    public static void main(String args[]){
      TreeNode root = new HasPathSum().makeTree();
      TreeNode root1 = new HasPathSum().makeTree1();
      TreeNode root2 = new HasPathSum().makeTree2();
      test(null,0,false);
      test(root,22,true);
      test(root,26,true);
      test(root,21,false);
      test(root1,1,false);
      test(root2,5,false);
      System.out.println("Passes: "+ COUNT + " Tests");
    }
}
