class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:arr) map.put(i,map.getOrDefault(i,0)+1);
        
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue()> n/3) ans.add(e.getKey());
        }
        Collections.sort(ans);
        return ans;
    }
}