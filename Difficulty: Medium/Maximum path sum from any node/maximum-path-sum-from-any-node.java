/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    // Function to return maximum path sum from any node in a tree.
  
    private int maxSum;
  int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(Node node) {
        if (node == null) return 0;

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int newPathSum = node.data + leftGain + rightGain;

        maxSum = Math.max(maxSum, newPathSum);
        return node.data + Math.max(leftGain, rightGain);
    }
}