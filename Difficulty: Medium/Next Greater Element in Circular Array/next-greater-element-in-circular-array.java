class Solution {
    public ArrayList<Integer> nextGreater(int[] nums) {
        // code here

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            int curr = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < curr) {
                result[stack.pop()] = curr;
            }
            if (i < n) {
                stack.push(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(n);
        for (int num : result) ans.add(num);
        return ans;
    

    }
}