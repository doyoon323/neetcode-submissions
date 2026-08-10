class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int x:nums) total+=x; 
        if(total%2!=0) return false; 

        boolean[] dp = new boolean[total/2+1];
        dp[0]=true;

        for(int x : nums){
            for(int i=total/2;i>=x;i--){
                    dp[i] = dp[i] || dp[i-x];
            }
            if(dp[total/2])return true;
        }
        return dp[total/2];
    }
}