/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left==null && root.right==null) return 0;
        int sum=0;
        List<Integer> r=new ArrayList<>();
        searchRight(root,r,0);
        int right=0;
        for (int a:r) {
            right+=a;
        }
        sum=searchSum(root,sum);
        System.out.println("sum="+sum+"; r="+r);
        return sum-right;
    }
    public static int searchSum(TreeNode root, int sum) {
        if (root!=null) {
            sum=searchSum(root.left,sum)+searchSum(root.right,sum);
            if (root.left==null && root.right==null) sum+=root.val;
        }
        return sum;
    }
    public static int searchRight(TreeNode root, List<Integer> r, int r_sum) {
        if (root!=null) {
            
            if (root.left!=null) searchRight(root.left,r,r_sum);
            if (root.right!=null) r_sum+=searchRight(root.right,r,r_sum);
            if (root.left==null && root.right==null) return r_sum+=root.val;
            r.add(r_sum);
            System.out.println("r_sum="+r_sum);
        }
        return r_sum;
    }
}
