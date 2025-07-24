class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        
        int lastLeft = 0;
        for (int pos : left)
            lastLeft = Math.max(lastLeft, pos);

        int lastRight = 0;
        for (int pos : right)
            lastRight = Math.max(lastRight, n - pos);

        return Math.max(lastLeft, lastRight);
    }


}