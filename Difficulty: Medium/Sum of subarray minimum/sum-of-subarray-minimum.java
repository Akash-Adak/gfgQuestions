class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int n = arr.length;
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Previous Less Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? i : i - stack.peek() - 1;
            stack.push(i);
        }

        stack.clear();

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? n - i - 1 : stack.peek() - i - 1;
            stack.push(i);
        }

        // Calculate result
        long result = 0;
        int MOD = (int)1e9 + 7;
        for (int i = 0; i < n; i++) {
            long count = (long)(prevLess[i] + 1) * (nextLess[i] + 1);
            result = (result + count * arr[i]) % MOD;
        }

        return (int)result;
    }


}
