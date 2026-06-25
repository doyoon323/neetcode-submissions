class Solution {
    public boolean validPalindrome(String s) {
        int left=0;
        int right = s.length()-1;

        while(left<=right){
            char s1= s.charAt(left);
            char s2 = s.charAt(right);
        
            if(s1 != s2){
                return isPalindrome(s,left,right-1) || isPalindrome(s,left+1,right);
            }
            left++;
            right--;
        }
        return true; 
    }
    public boolean isPalindrome(String s, int left,int right){
        while(left<=right){
            char s1= s.charAt(left);
            char s2 = s.charAt(right);

            if(s1!=s2) return false; 
            left++;
            right--; 
        }
        return true; 
    }
}