class Solution {
    public String largestSwap(String s) {
        // code here

        char[] arr = s.toCharArray();
        int[] last = new int[10];


        for (int i = 0; i < arr.length; i++) {
            last[arr[i] - '0'] = i;
        }

     
        for (int i = 0; i < arr.length; i++) {
            for (int d = 9; d > arr[i] - '0'; d--) {
                if (last[d] > i) {
                    // Swap and return
                    char temp = arr[i];
                    arr[i] = arr[last[d]];
                    arr[last[d]] = temp;
                    return new String(arr);
                }
            }
        }

        return s; 
    }


}