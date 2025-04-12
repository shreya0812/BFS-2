// Time Complexity : O(n), where n is the number of nodes in the binary tree.
// Space Complexity : O(n), for the queue used in BFS (in worst case, when the last level has n/2 nodes).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// BFS (level order traversal) based solution
// We use a queue to process the tree level by level.
// The `size` variable tells us how many nodes exist at the current level.
// It helps ensure we only process nodes from one level at a time, even as we keep adding nodes from the next level to the queue.
// At each level, we process nodes from right to left by enqueuing `right` child before `left`.
// We add the first node we encounter at each level to the result list — that node is the rightmost one from the current level's perspective.




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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result =  new ArrayList<>();
        if(root  == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            // to track level
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // pop node from the queue
                TreeNode curr =  q.poll();
                // If first node in the level then add to the result
                if(i == 0){
                    result.add(curr.val);
                }
                // Add right child first then left
                if(curr.right != null)
                    q.add(curr.right);
                if(curr.left != null)
                    q.add(curr.left);

            }

        }
        return result;
    }
}