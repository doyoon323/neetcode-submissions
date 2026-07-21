class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;


        for(int i=0;i<n;i++){
            int cur = i+1; 
            int end = i+nums[i];
            if(end>=n) {
                dp[n-1] = Math.min(dp[n-1],dp[i]+1);
                break; 
            }

            dp[i+nums[i]] = Math.min(dp[i+nums[i]],dp[i]+1);
            while(cur<=end){
                dp[cur]=Math.min(dp[i]+1,dp[cur]);
                cur++; 
            }
        }

        return dp[n-1];
    }
}