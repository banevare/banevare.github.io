public class SortedArrayToBST {
    static int COUNT = 0;
    public TreeNode recursive(int[] nums, int i, int j) { 
        final int diff = j - i, indexMid = (diff % 2 == 0) ? (i + diff/2) : (i + diff/2 + 1);
        final TreeNode root = new TreeNode(nums[indexMid]);
        if(indexMid - 1 >= i ) root.left  = recursive(nums,i,indexMid-1);   
        if(indexMid + 1 <= j ) root.right = recursive(nums,indexMid+1,j);  
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) { 
        if(nums.length == 0) return null;
        if(nums.length == 1) return new TreeNode(nums[0]);                           
        return recursive(nums,0,nums.length -1);
    }
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
	}
    public static String preOrderTraversal(TreeNode root){
        String s = "";
		if(root != null){
			s += root.val + " ";
			if(root.left  != null) s += preOrderTraversal(root.left)  + " ";  else s += "null ";
			if(root.right != null) s += preOrderTraversal(root.right) + " ";  else s += "null ";
		}
	    return s.replaceAll("\\s+"," ").replaceAll("\\s+$","");                                        // $ - end of line
    }
    public static int[] toInt(final String s){									                                     // convert string array to int array
        String[] str = s.split(" ");
        if(s == "") return new int[0];
        int[] arr = new int[str.length];
        if(s == "") return arr;
        for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(str[i]);
        return arr;
	}
    public static void test(String s, String t){                                                     // general test function
        assert(t.equals(preOrderTraversal(new SortedArrayToBST().sortedArrayToBST(toInt(s)))));
        COUNT++;
    }
	public static void main(String[] args) {
        test("1", "1 null null");
        test("1 3", "3 1 null null null");          
        test("1 2 3 4", "3 2 1 null null null 4 null null");
        test("1 2 3 4 5", "3 2 1 null null null 5 4 null null null");
        test("-10 -3 0 5 9", "0 -3 -10 null null null 9 5 null null null");
        test("1 2 3 4 5 6", "4 2 1 null null 3 null null 6 5 null null null");
        test("1 2 3 4 5 6 7", "4 2 1 null null 3 null null 6 5 null null 7 null null");
        System.out.println("Passes: "+ COUNT + " Tests");
	}
}
