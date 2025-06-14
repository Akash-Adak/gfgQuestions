/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    public boolean isSymmetric(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root.left);
    queue.add(root.right);

    while(!queue.isEmpty()) {
      Node left = queue.poll();
      Node right = queue.poll();

      if(left == null && right == null) {
        continue;
      }
      
      if(left == null || right == null) {
         return false;
      }

      if (left.data != right.data) {
        return false;
      }

      queue.add(left.left);
      queue.add(right.right);
      queue.add(left.right);
      queue.add(right.left);
      
    }
    return true;
  }
}