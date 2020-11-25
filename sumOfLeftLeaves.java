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
        List<Integer> r=new ArrayList<>();
        searchLeft(root,r);
        int sum=0;
        for (int a:r) {
            sum+=a;
        }
        return sum;
    }
    public static void searchLeft(TreeNode root, List<Integer> r) {
        if (root!=null) {
            searchLeft(root.left,r);
            searchLeft(root.right,r);
            if (root.left!=null && root.left.left==null && root.left.right==null) {r.add(root.left.val);}
        }
    }
}
