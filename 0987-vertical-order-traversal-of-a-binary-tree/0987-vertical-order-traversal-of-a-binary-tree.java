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
    int maxOfPosition = 0;
    int minOfPosition = 0;

    void getWidth(TreeNode root, int pos) {
        if (root == null) {
            return;
        }

        getWidth(root.left, pos - 1);
        getWidth(root.right, pos + 1);

        maxOfPosition = Math.max(pos, maxOfPosition);
        minOfPosition = Math.min(pos, minOfPosition);

        return;
    }

    class Pair implements Comparable<Pair> {
        TreeNode node;
        int pos;

        Pair(TreeNode node, int pos) {
            this.pos = pos;
            this.node = node;
        }

        @Override 
        public int compareTo(Pair other) {
            if (this.pos == other.pos) {
                return this.node.val - other.node.val;
            }

            return this.pos - other.pos;
        }
    }

    List<List<Integer>> verticalTraversal(TreeNode root) {
        // Write your code here
        getWidth(root, 0);
        int width = maxOfPosition - minOfPosition;

        int levels = width + 1;
        List<List<Integer>> vw = new ArrayList<>();
        for (int i = 0; i < levels; i++) {
            vw.add(new ArrayList<>());
        }

        PriorityQueue<Pair> Ppq = new PriorityQueue<>();
        Ppq.add(new Pair(root, -minOfPosition));

        while (Ppq.size() > 0) {
            int size = Ppq.size();

            PriorityQueue<Pair> Cpq = new PriorityQueue<>();

            while (size-- > 0) {
                Pair rpair = Ppq.remove();

                vw.get(rpair.pos).add(rpair.node.val);

                if (rpair.node.left != null) {
                    Cpq.add(new Pair(rpair.node.left, rpair.pos - 1));
                }

                if (rpair.node.right != null) {
                    Cpq.add(new Pair(rpair.node.right, rpair.pos + 1));
                }
            }

            Ppq = Cpq;
        }

        return vw;
    }
}