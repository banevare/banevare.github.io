public class CountNodes {
    static int COUNT = 0;
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        final int depth = findDepth(root);
        final NumMissNodes o = new NumMissNodes();
        reversePreOrder(root,1, depth - 1, o);
        return (int) Math.pow(2, depth) - 1 - o.n;
    }
    public int findDepth(TreeNode root){
        if(root == null) return 0;                                                              // recursive call : return findDepth(root.left) + 1;
        int depth = 1;
        while(root.left != null){
            depth++;
            root = root.left;
        }
        return depth;
    }
    public void reversePreOrder( TreeNode root, int depth, int targetDepth, NumMissNodes o){
        if(depth == targetDepth) {
            if(root.right == null && root.left != null) o.n++; 
            if(root.right == null && root.left == null) o.n += 2;
        }
        if(root.right != null) reversePreOrder(root.right, depth + 1, targetDepth,o);
        if(root.left != null) reversePreOrder( root.left,  depth + 1, targetDepth,o);
    }
    public class NumMissNodes{int n = 0;}
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
    public TreeNode makeTree(){
		return new TreeNode(1);
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
    public TreeNode makeTree3(){
        TreeNode r  = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode r2 = new TreeNode(3);
		TreeNode l3 = new TreeNode(4);
		TreeNode r3 = new TreeNode(5);
		TreeNode l4 = new TreeNode(6);
        r.left   = l2;
        r.right  = r2;
        l2.left  = l3;
        l2.right = r3;
        r2.left  = l4;
		return r;
	}
    public TreeNode makeTree4(){
        TreeNode r  = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode r2 = new TreeNode(3);
		TreeNode l3 = new TreeNode(4);
		TreeNode r3 = new TreeNode(5);
		TreeNode l4 = new TreeNode(6);
        TreeNode r4 = new TreeNode(7);
        TreeNode l5 = new TreeNode(8);
        TreeNode r5 = new TreeNode(9);
        TreeNode l6 = new TreeNode(10);
        r.left   = l2;
        r.right  = r2;
        l2.left  = l3;
        l2.right = r3;
        r2.left  = l4;
        r2.right = r4;
        l3.left  = l5;
        l3.right = r5;
        r3.left  = l6;
		return r;
	}
    public static void test(TreeNode root,int ans) {
        assert(ans == (new CountNodes().countNodes(root)));
		COUNT++;
	}
    public static void main(String args[]){
        TreeNode root  = new CountNodes().makeTree3();
		TreeNode root1 = new CountNodes().makeTree1();
		TreeNode root2 = new CountNodes().makeTree2();
        TreeNode root3 = new CountNodes().makeTree();
        TreeNode root4 = new CountNodes().makeTree4();
		test(null,0);
        test(root,6);
        test(root4,10);
		test(root1,2);
		test(root2,3);
        test(root3,1);
        System.out.println("Passes: "+ COUNT + " Tests");
    }
}
