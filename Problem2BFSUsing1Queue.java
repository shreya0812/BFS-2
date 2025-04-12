// Time Complexity : O(n), where n is the number of nodes in the tree.
// Space Complexity : O(n), due to the queue used for BFS traversal.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// - We perform level-order traversal (BFS) using a single queue.
// - For every node, we check if it has both left and right children,
//   and whether those children are x and y -> if so, return false (they are siblings).
// - We set flags when we find either x or y at the current level.
// - If both are found in the same level, return true.
// - If only one is found at the level, they are not cousins -> return false.


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
        Queue<TreeNode>  q  = new LinkedList<>();
        q.add(root);

        boolean foundx = false;
        boolean foundy = false;

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                // Check if children are present -> check if both are x and y thrn -> not cousins.
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.right.val == x && curr.left.val == y) return false;
                }
                //Check if curr node is x
                if(curr.val == x){
                    foundx = true;
                }
                //Check if curr node is y
                if(curr.val == y){
                    foundy = true;
                }
                //Add children in the queue
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            //If both are found -> return true;
            if(foundx && foundy) return true;
            //If only one of them is found at a level return false-> they dont have same depth.
            if(foundx || foundy) return false;

        }
        return false;
    }
}