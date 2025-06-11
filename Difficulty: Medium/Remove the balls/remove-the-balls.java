class Solution {

        // code here
     class Ball {
        int color;
        int radius;

        Ball(int color, int radius) {
            this.color = color;
            this.radius = radius;
        }
    }

        public int findLength(int[] color, int[] radius) {
            int N=color.length;
        Stack<Ball> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            // Check if the stack is not empty and the current ball
            // matches the top ball in color and radius
            if (!stack.isEmpty() && stack.peek().color == color[i] && stack.peek().radius == radius[i]) {
                stack.pop(); // Remove the matching pair
            } else {
                // Otherwise, push the current ball onto the stack
                stack.push(new Ball(color[i], radius[i]));
            }
        }

        return stack.size(); // The remaining balls are in the stack
    }

}