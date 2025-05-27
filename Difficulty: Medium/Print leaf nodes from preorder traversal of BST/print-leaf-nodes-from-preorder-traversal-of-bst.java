class Solution {
    

     int index = 0;

    public  void findLeaves(int[] preorder, int min, int max, List<Integer> leaves) {
        if (index >= preorder.length) return;

        int val = preorder[index];

        if (val < min || val > max) return;

        index++;

        int current = index;

        // Process left subtree
        findLeaves(preorder, min, val, leaves);

        // Process right subtree
        findLeaves(preorder, val, max, leaves);

        // If no new nodes were processed, it's a leaf
        if (index == current) {
            leaves.add(val);
        }
    }

   public ArrayList<Integer> leafNodes(int[] preorder) {
        index = 0;
        ArrayList<Integer> leaves = new ArrayList<>();
        findLeaves(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, leaves);
        return leaves;
    }

  

}