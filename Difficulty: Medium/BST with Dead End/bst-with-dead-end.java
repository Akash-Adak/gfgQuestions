/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {

        // Code here.
  
     boolean checkDeadEnd(Node root, int min, int max) {
        if (root == null) return false;

        // If a node is at a dead-end, its range gets reduced to a single point
        if (min == max) return true;

        return checkDeadEnd(root.left, min, root.data - 1) || checkDeadEnd(root.right, root.data + 1, max);
    }

       public boolean isDeadEnd(Node root) {
        return checkDeadEnd(root, 1, Integer.MAX_VALUE);
    }
}