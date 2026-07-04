class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0; 
        
        int[] dp = new int[amount+1];
        for(int c:coins) if(c<=amount) dp[c]=1; 
        for(int i=1;i<=amount;i++){
            if(dp[i]==0)
                for(int c:coins){
                    if(i-c>=0 && dp[i-c]!=0){
                        if(dp[i]!=0) dp[i] = Math.min(dp[i],dp[i-c]+1);
                        else dp[i] = dp[i-c]+1;
                    }
                }
            System.out.println(dp[i]);
        }
        // [1,2,5] & 11 
        // dp[1]=1;
        return dp[amount]==0?-1:dp[amount]; 
    }
}
