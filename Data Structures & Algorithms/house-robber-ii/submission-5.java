class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        if(n==1) return nums[0];

        dp[0]=0;
        dp[1]=nums[1];
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        int max = dp[n-1];
        System.out.println(max);

        dp[0]=nums[0];
        dp[1]=nums[0];
        for(int i=2;i<n-1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            System.out.println(dp[i]);
        }

        return max > dp[n-2] ? max : dp[n-2];
    }
}
