class Solution {
    public int romanToDecimal(String s) {
        // code here
    int ans = 0;
    for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        switch (c){
            case 'I' :{
                if(i < (s.length()-1) && ((s.charAt(i+1) == 'V')|| (s.charAt(i+1) == 'X'))){
                    ans -= 1;
                }else ans +=1;
                break;
            }
            case 'V' : ans +=5;
                break;
            case 'X' :{ 
                if(i < (s.length()-1) && ((s.charAt(i+1) == 'L')|| (s.charAt(i+1) == 'C'))){
                    ans -= 10;
                }else ans +=10;
                break;
            }
            case 'L' : ans +=50;
                break;
            case 'C' : {
                if(i < (s.length()-1) && ((s.charAt(i+1) == 'D')|| (s.charAt(i+1) == 'M'))){
                    ans -= 100;
                }else ans +=100;
                break;
            }
            case 'D' : ans +=500;
                break;
            case 'M' : ans +=1000;
                break;
        }
    }
    return ans;
    }
}