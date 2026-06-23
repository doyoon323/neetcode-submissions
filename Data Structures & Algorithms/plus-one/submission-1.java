class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1; 
        int n = i+1; 
        digits[i]++; 
        if(digits[i]!=10) return digits; 

        while(i>0){
            if(digits[i]==10){
                digits[i] = 0;
                digits[i-1]++; 
            }else return digits; 
            i--; 
        }
        if(digits[0]==10){
            int[] res = new int[n+1];
            res[0]=1; 
            return res; 
        }else return digits; 
    }
}
