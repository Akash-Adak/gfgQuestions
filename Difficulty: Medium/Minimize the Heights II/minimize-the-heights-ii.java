

// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int min=arr[arr.length-1]-arr[0];
        
        for(int i=0;i<arr.length-1;i++){
            int h=Math.max(arr[arr.length-1]-k,arr[i]+k);
            int l=Math.min(arr[0]+k,arr[i+1]-k);
              if(l>=0){
                  min=Math.min(min,h-l);
              }
        }
        return min;
    }
}
