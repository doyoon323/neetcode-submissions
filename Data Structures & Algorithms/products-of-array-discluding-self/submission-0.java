class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++) dp[i]=dp[i-1]*nums[i];
        int[] d = new int[nums.length];
        d[nums.length-1] = nums[nums.length-1];

        for(int i=nums.length-2;i>-1;i--) d[i]=d[i+1]*nums[i];

        int[] res =  new int[nums.length];
        Arrays.fill(res,1);

        for(int k=0;k<nums.length;k++){
            if(k-1>=0) res[k]*=dp[k-1];
            if(k+1<nums.length) res[k]*=d[k+1];
        }
        return res; 
    }
}  
