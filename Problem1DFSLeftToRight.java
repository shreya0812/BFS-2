// Time Complexity : O(n), where n is the total number of nodes in the tree.
// Space Complexity : O(h), where h is the height of the tree (due to recursive call stack).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// - TDFS approach
// - this version traverses left first, then right
//   and updates the node at each level with the latest seen value, which eventually ends up being the rightmost node.
// - `level` keeps track of the depth of the tree during traversal.
// - When visiting a level for the first time (`result.size() == level`), add the node's value.
// - If the level already exists, overwrite it with the current node's value using `set`.
// - Because the rightmost node is visited last at each level, it overwrites previous ones, ensuring the correct result.



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
        //If visiting for fist time add it
        if(result.size() == level){
            result.add(root.val);
        } else {// Else all other times update the value
            result.set(level, root.val);
        }

        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}