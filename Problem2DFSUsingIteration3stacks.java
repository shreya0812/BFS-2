// Time Complexity: O(n), where n is the number of nodes in the binary tree.
// Space Complexity: O(n) in the worst case (due to stack storage for nodes, parents, and levels).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
//Iterative approach
// - Use three stacks to simulate DFS: one for nodes, one for their parents, and one for their levels.
// - Track x and y's parent and depth as you traverse.
// - At the end, check if they are at the same level and have different parents → then they're cousins.

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
    public boolean isCousins(TreeNode root, int x, int y) {
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> parent = new Stack<>();
        Stack<Integer> level = new Stack<>();

        // Variables to store the level and parent of x and y when found
        int x_level = -1;
        int y_level = -1;
        TreeNode x_parent = null;
        TreeNode y_parent = null;

        // Initialize the stacks with the root node, null parent of root node, and level 0
        st.push(root);
        parent.push(null);
        level.push(0);

        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            TreeNode curr_parent = parent.pop();
            int curr_level = level.pop();

            //logic
            //Check if we found x
            if(curr.val == x){
                x_level = curr_level;
                x_parent = curr_parent;
            }
            //Check if we found y
            if(curr.val == y){
                y_level = curr_level;
                y_parent = curr_parent;
            }

            //Push children into stack
            if(curr.left != null){
                st.push(curr.left);
                parent.push(curr);
                level.push(curr_level+1);
            }
            if(curr.right != null){
                st.push(curr.right);
                parent.push(curr);
                level.push(curr_level+1);
            }
        }
        // Nodes are cousins if they are at the same level but have different parents
        return x_level == y_level && x_parent != y_parent;

    }
}