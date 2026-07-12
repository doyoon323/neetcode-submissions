class Solution {
    public int countSubstrings(String s) {
        int n = s.length(); 
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            int left=i,right=i;
            while(left>=0 && right<n){
                if(s.charAt(left)==s.charAt(right)) dp[i]++; 
                else break; 
                left--;
                right++; 
            }

            left = i; 
            right = i+1;
            while (left >= 0 && right < n) {
                if (s.charAt(left) == s.charAt(right)) {
                    dp[i]++;
                    left--;
                    right++; 
                } else {
                    break; 
                }
            }
        }

        int len=0;
        for(int x:dp)len+=x;
        return len;    
    }
}
