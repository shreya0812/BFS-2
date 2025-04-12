// Time Complexity : O(n), where n is the number of nodes in the binary tree.
// Space Complexity : O(h), where h is the height of the tree (due to recursion stack).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// DFS-based solution
// We traverse the tree in root-right-left i.e from right side order so that rightmost nodes at each level are visited first.
// The `level` variable tracks the current depth in the tree.
// if `result.size() == level`, it means this level hasn't been added yet,so we add the current node's value — which will always be the rightmost node due to our traversal order.


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
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)  return result;
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        //BC
        if(root == null)return;

        if(result.size() == level){
            result.add(root.val);
        }

        helper(root.right, level+1);

        helper(root.left, level+1);
    }
}