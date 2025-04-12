// Time Complexity : O(n), where n is the number of nodes in the tree.
// Space Complexity : O(h), where h is the height of the tree (due to recursion stack).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// - Use DFS to traverse the binary tree while keeping track of each node’s level and parent.
// - If both x and y are found at the same level but have different parents, they are cousins.
// - If either condition fails, they are not cousins.


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
    int x_level, y_level;
    TreeNode x_parent, y_parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        // Start DFS traversal from root at level 0 with null parent
        helper(root,x,y,0, null);
        // Nodes are cousins if they are at the same level but have different parents
        return x_level == y_level && x_parent != y_parent;
    }

    private void helper(TreeNode root, int x, int y, int level, TreeNode parent) {
        //BC + //Check if we found both x and y then dont traverse the tree ahead
        if(root == null || (x_parent != null && y_parent != null)) return;

        //Check if we found x
        if(root.val == x){
            x_level = level;
            x_parent = parent;
        }
        //Check if we found y
        if(root.val == y){
            y_level = level;
            y_parent = parent;
        }

        // Recurse left and right with incremented level and current node as parent
        helper(root.left,x,y,level+1, root);
        helper(root.right,x,y,level+1, root);
    }
}