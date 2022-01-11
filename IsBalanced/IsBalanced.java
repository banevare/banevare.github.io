class IsBalanced {
    static int COUNT = 0;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        final TreeBalanceCheck t = new TreeBalanceCheck();
        postOrder(root,t);
        return t.balanced;
    }
    public int postOrder(TreeNode root, TreeBalanceCheck t){
        int leftDepth = 0, rightDepth = 0;
        if (root.left  != null) leftDepth  = postOrder(root.left,  t)  + 1;
        if (root.right != null) rightDepth = postOrder(root.right, t)  + 1;
        if (Math.abs(leftDepth - rightDepth) > 1) { 
            t.balanced = false; 
            t.nUnbalanced++;
        }
        return Math.max(leftDepth,rightDepth);
    }
    public class TreeBalanceCheck { boolean balanced = true; int nUnbalanced = 0; }
    public class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		  }
    }
    public TreeNode makeTree(){ return new TreeNode(1); }
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
    public TreeNode makeTree3(){                
        TreeNode r  = new TreeNode(3);
		    TreeNode l2 = new TreeNode(9);
		    TreeNode r2 = new TreeNode(20);
		    TreeNode l3 = new TreeNode(15);
		    TreeNode r3 = new TreeNode(7);
        r.left   = l2;
        r.right  = r2;
        r2.left  = l3;
        r2.right = r3;
		return r;
	}   
    public TreeNode makeTree4(){                
        TreeNode r  = new TreeNode(1);
		    TreeNode l2 = new TreeNode(2);
		    TreeNode r2 = new TreeNode(2);
		    TreeNode l3 = new TreeNode(3);
		    TreeNode r3 = new TreeNode(3);
		    TreeNode l4 = new TreeNode(4);
        TreeNode r4 = new TreeNode(4);
        r.left   = l2;
        r.right  = r2;
        l2.left  = l3;
        l2.right = r3;
        l3.left  = l4;
        l3.right = r4;
		return r;
	}
    public TreeNode makeTree5(){            
        TreeNode r  = new TreeNode(1);
		    TreeNode l2 = new TreeNode(2);
		    TreeNode r2 = new TreeNode(2);
		    TreeNode l3 = new TreeNode(3);
		    TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(3);
        TreeNode l5 = new TreeNode(4);
        TreeNode r5 = new TreeNode(4);
        TreeNode l6 = new TreeNode(4);
        TreeNode r7 = new TreeNode(5);
        r.left   = l2;
        r.right  = r2;
        l2.left  = l3;
        l2.right = r3;
        r2.right = r4;
        l3.left  = l5;
        l3.right = r5;
        r4.left  = l6;
        r5.right = r7;
		return r;
	}
    public static void test(TreeNode root,boolean ans) {
        assert(ans == (new IsBalanced().isBalanced(root)));
		COUNT++;
	}
    public static void main(String args[]){
        TreeNode root  = new IsBalanced().makeTree3();
        TreeNode root1 = new IsBalanced().makeTree1();
        TreeNode root2 = new IsBalanced().makeTree2();
        TreeNode root3 = new IsBalanced().makeTree();
        TreeNode root4 = new IsBalanced().makeTree4();
        TreeNode root5 = new IsBalanced().makeTree5();

        test(null,true);
        test(root,true);
        test(root1,true);
        test(root2,true);
        test(root3,true);
        test(root4,false);
        test(root5, false);
        System.out.println("Passes: "+ COUNT + " Tests");
    }
}
