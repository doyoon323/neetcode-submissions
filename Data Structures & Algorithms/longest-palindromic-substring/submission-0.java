class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int maxr=0,maxl=0; 

        for(int i=0;i<n;i++){
            int left=i, right=i;
            while(left>=0 && right<n){
                if(s.charAt(left)==s.charAt(right)){
                    if(maxr-maxl+1<right-left+1){
                        maxl=left;
                        maxr=right;
                    }
                }
                else break;

                left--;
                right++; 
            }
            left=i;
            right=i+1; 
            while(left>=0 && right<n){
                if(s.charAt(left)==s.charAt(right)){
                    if(maxr-maxl+1<right-left+1){
                        maxl=left;
                        maxr=right;
                    }
                }
                else break;

                left--;
                right++; 
            }
        }
        return s.substring(maxl,maxr+1); 
    }
}
