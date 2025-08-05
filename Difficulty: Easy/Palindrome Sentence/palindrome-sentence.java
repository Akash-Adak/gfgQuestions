class Solution {
    public boolean isPalinSent(String s) {
        // code here
        StringBuilder sb=new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetter(ch)) sb.append(Character.toLowerCase(ch));
            if(Character.isDigit(ch)) sb.append(ch);
        }
        
        String curr=sb.toString();
        return curr.equals(sb.reverse().toString())? true:false;
    }
}