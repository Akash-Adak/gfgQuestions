class Solution {
    public int startStation(int[] gas1, int[] cost1) {
        // Your code here
        int gas=0,cost=0;
        int s=0,tank=0;
        for(int i=0;i<gas1.length;i++){
            gas+=gas1[i];
            cost+=cost1[i];
            tank+=gas1[i]-cost1[i];
            if(tank<0){
                s=i+1;
                tank=0;
            }
        }
        return gas>=cost ? s :-1;
        
    }
}