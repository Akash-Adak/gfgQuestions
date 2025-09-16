class Solution {
    public int evaluatePostfix(String[] arr) {
        // code here
        
        Stack<Integer> stack = new Stack<>();

        for (String token : arr) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }

    private int applyOperator(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return floorDivide(a, b);
            case "^": return (int) Math.pow(a, b);
            default: throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    private int floorDivide(int a, int b) {
        int result = a / b;
        if ((a ^ b) < 0 && a % b != 0) {
            result--;
        }
        return result;
    }


}