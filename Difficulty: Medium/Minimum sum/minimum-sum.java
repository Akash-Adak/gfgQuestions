class Solution {
    String minSum(int[] arr) {
        // code here
        
        Arrays.sort(arr);
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                num1.append(arr[i]);
            else
                num2.append(arr[i]);
        }
String result = addStrings(num1.toString(), num2.toString());
// Remove ALL leading zeroes safely
result = result.replaceFirst("^0+(?!$)", "");
return result;
    }

    // Helper method to add two numbers represented as strings
    private String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';
            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }


}
