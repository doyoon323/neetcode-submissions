class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1; 
        dp[0]=1;
//[1,3,6,7,9,4,10,5,6]


        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            int j=i-1;
            while(j>-1 && j<i){
                if(nums[j]<nums[i]) dp[i] = Math.max(dp[j]+1,dp[i]);
                j--;
            }
            max = Math.max(max,dp[i]);
        }
        return max;        
    }
}
