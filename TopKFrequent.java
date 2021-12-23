import java.util.*;
class TopKFrequent {
    static int COUNT = 0;
    class Pair implements Comparable<Pair>{
        int key;
        int value;
        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
       public int compareTo(Pair p) {
           int a = this.value;
           int b = p.value;
        //    System.out.println("a: " + a + "--- b: " + b);
           if (a < b) return -1;
           else if( a > b) return  1;
           else return 0;
        }
        public String toString(){
           return "key: " + this.key + " -- val: " + this.value;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        if(k > nums.length) k = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],1);
            else map.put(nums[i],map.get(nums[i])+1);
        }
        Pair[] pairs = new Pair[map.size()];
        int i = 0;
        for(Integer key : map.keySet()) pairs[i++] =  new Pair(key, map.get(key));
        Arrays.sort(pairs, Collections.reverseOrder());
        int[] a =  new int[k];
        for(int j = 0; j < a.length; j++)a[j] = pairs[j].key;
        return a;
    }
    public static String toString(final int[] arr){									        // convert int array to string array
		String s = "";
        for(int i = 0; i < arr.length; i++){
            if(i == arr.length - 1) s += Integer.toString(arr[i]);
            else s += Integer.toString(arr[i]) + " ";
        }
        return s;
	}
    public static int[] toInt(final String s){									            // convert string array to int array
        String[] str = s.split(" ");
        if(s == "") return new int[0];
        int[] arr = new int[str.length];
        if(s == "") return arr;
        for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(str[i]);
        return arr;
	}
    public static void test(String str,String answer, int k){                                                           // general test function
        TopKFrequent l = new TopKFrequent();
        int[] nums = toInt(str);
        int[] ans = l.topKFrequent(nums,k);
        String output = toString(ans);
        // System.out.println("TEST: " + output);
		assert(answer.equals(output));
        COUNT++;
    }
    public static void main(String args[]){
        test("1", "1", 1);
        test("1", "1", 100);
        test("1 1 1 2 2 3", "1 2", 2);
        test("1 1 1 2 2 2 3", "1 2", 2);
        test("1 1 1 2 2 2 2 3", "2 1", 2);
        test("1 1 1 2 2 2 2 3 3 4 4 4 4 4 4 4 5 5 6 6 6 6 ", "4 2 6", 3);
        System.out.println("Passes: "+ COUNT + " Tests");
    }
}