// Time Complexity : O(n) where `n` is the number of nodes in the binary tree.
// Space Complexity : O(n), all nodes might be stored in the stack at once. Also, we store additional info (parent and level) per node.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// - Use a custom class (NodeInfo) to store the node, its parent, and its level.
// - Use a stack to simulate DFS traversal of the binary tree.
// - As you traverse, track the parent and level of nodes x and y.
// - At the end, check if x and y are at the same level but have different parents — if so, they are cousins.


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

class NodeInfo{
    TreeNode node;
    TreeNode parent;
    int level;

    public NodeInfo(TreeNode node, TreeNode parent, int level) {
        this.node = node;
        this.parent = parent;
        this.level = level;
    }


}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Stack<NodeInfo> st = new Stack<>();

        // Variables to store the level and parent of x and y when found
        int x_level = -1;
        int y_level = -1;
        TreeNode x_parent = null;
        TreeNode y_parent = null;

        // Initialize the stacks with the root node, null parent of root node, and level 0
        st.push(new NodeInfo(root, null, 0));

        while(!st.isEmpty()){
            NodeInfo curr_Node = st.pop();

            //logic
            //Check if we found x
            if(curr_Node.node.val == x){
                x_level = curr_Node.level;
                x_parent = curr_Node.parent;
            }
            //Check if we found y
            if(curr_Node.node.val == y){
                y_level = curr_Node.level;
                y_parent = curr_Node.parent;
            }

            //Push children into stack
            if(curr_Node.node.left != null){
                st.push(new NodeInfo(curr_Node.node.left, curr_Node.node, curr_Node.level+1));
            }
            if(curr_Node.node.right != null){
                st.push(new NodeInfo(curr_Node.node.right, curr_Node.node, curr_Node.level+1));
            }
        }
        // Nodes are cousins if they are at the same level but have different parents
        return x_level == y_level && x_parent != y_parent;

    }
}