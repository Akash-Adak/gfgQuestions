class Solution {
    public static String caseSort(String str) {
        // code here
        char[] s = str.toCharArray();
        List<Character> lower = new ArrayList<>();
        List<Character> upper = new ArrayList<>();

        // Separate characters by case
        for (char c : s) {
            if (Character.isLowerCase(c)) lower.add(c);
            else upper.add(c);
        }

        // Sort both lists
        Collections.sort(lower);
        Collections.sort(upper);

        // Reconstruct string preserving original case pattern
        StringBuilder sb = new StringBuilder();
        int li = 0, ui = 0;
        for (char c : s) {
            if (Character.isLowerCase(c)) sb.append(lower.get(li++));
            else sb.append(upper.get(ui++));
        }

        return sb.toString();
    }


}