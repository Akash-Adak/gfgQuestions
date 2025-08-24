class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        if(arr.length < k*m) return -1;
        if(arr.length==k*m) return Arrays.stream(arr).max().getAsInt();
        
        int count=0;
        int left=Arrays.stream(arr).min().getAsInt();
        int right=Arrays.stream(arr).max().getAsInt();
        while(left<= right){
            int mid=(left+right)/2;
            if(canPossible(mid,arr,m,k)){
                count=mid;
                right=mid-1;
            }else left=mid+1;
        }
        return count;
    }
    
    private boolean canPossible(int day,int[] arr,int m,int k){
        int bo=0,f=0;
        for(int i: arr){
            if(i<=day){
                f+=1;
                if(f==k){
                    bo+=1;
                    f=0;
                }
            }else{
                f=0;
            }
        }
        return bo>=m;
    }
}