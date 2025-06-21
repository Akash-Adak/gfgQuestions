class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        int n = arr.length;
        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P')
                police.add(i);
            else if (arr[i] == 'T')
                thieves.add(i);
        }

        int i = 0, j = 0, caught = 0;
        while (i < police.size() && j < thieves.size()) {
            if (Math.abs(police.get(i) - thieves.get(j)) <= k) {
                caught++;
                i++;
                j++;
            } else if (police.get(i) < thieves.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return caught;
    }


}