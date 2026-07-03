class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        if(s.charAt(n-1)=='0' && n==1) return 0;
        dp[n-1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for(int i=n-2;i>=0;i--){
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i+1];
            int twoDigit = Integer.parseInt(s.substring(i, i + 2));
            if (twoDigit>=10 && twoDigit<=26) {
                if(i+2<n) dp[i] += dp[i + 2];
                else dp[i] += 1;
            }
        }
        return dp[0];
    }
}
