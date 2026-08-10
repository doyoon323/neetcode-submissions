class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int t=0;
        for(int x : nums){
            t+=x; 
        }
        if (target + t < 0 || (target + t) % 2 != 0) return 0;

        int P = (target + t) / 2;
        int[] dp = new int[P + 1];
        dp[0] = 1;

        for(int x : nums){
            for(int w=P;w>=x;w--){
                dp[w]+=dp[w-x];
            }
        }
        return dp[P];
    }
}
