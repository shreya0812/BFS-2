// Time Complexity : O(n), where n is the number of nodes in the tree.
// Space Complexity : O(n), due to the space required by the queues in worst-case (all nodes at a level).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// - We perform a level-order traversal (BFS) using two queues:
//     1. `q`  -> holds the current level's nodes
//     2. `pq` -> holds the parent of each node in `q`
// - As we traverse, we check for nodes with values x and y.
// - If both are found at the same level, we compare their parents:
//     -> If parents are different, they are cousins: return true.
//     -> If parents are same, they are siblings: return false.
// - If only one of x or y is found in a level, they can't be cousins, so we return false.

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
        Queue<TreeNode> pq = new LinkedList<>();
        q.add(root);
        pq.add(null);
        boolean foundx = false;
        boolean foundy = false;
        TreeNode parentx = null;
        TreeNode parenty = null;

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                TreeNode currParent = pq.poll();
                //Check if curr node is x
                if(curr.val == x){
                    foundx = true;
                    parentx = currParent;
                }
                //Check if curr node is y
                if(curr.val == y){
                    foundy = true;
                    parenty = currParent;
                }
                //Add children in the queue and their parents in parents queue
                if (curr.left != null) {
                    q.add(curr.left);
                    pq.add(curr);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    pq.add(curr);
                }
            }
            //If both are found -> check if parents are different -> if so return true;
            if(foundx && foundy) return parentx != parenty;
            //If only one of them is found at a level return false-> they dont have same depth.
            if(foundx || foundy) return false;

        }
        return false;
    }
}