class Solution {
    public boolean isPalindrome(String s) {
        int left=0, right=s.length()-1;
        while(left<=right){
            char lc = s.charAt(left);
            char rc = s.charAt(right);
            if(!((lc >= 'A' && lc<= 'Z') || (lc >= 'a' && lc<= 'z') || (lc >= '0' && lc<= '9'))){
                left++; 
                continue;
            }
            if(!((rc >= 'A' && rc <= 'Z') || (rc >= 'a' && rc <= 'z') || (rc >= '0' && rc<= '9'))){
                right--; 
                continue;
            }

            if((lc >= 'A' && lc<= 'Z')) lc+=32; 
            if((rc >= 'A' && rc<= 'Z')) rc+=32;

            if(lc!=rc) return false; 

            left++;
            right--;
            continue; 
        }
            return true; 
    }
}