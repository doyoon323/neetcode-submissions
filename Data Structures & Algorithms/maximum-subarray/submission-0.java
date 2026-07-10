class Solution {
    public int maxSubArray(int[] nums) {
        //누적 vs 갱신 

        int max = nums[0];
        int total = nums[0];  

        for(int i=1;i<nums.length;i++){
            total+=nums[i]; 
            if(nums[i]>total) total = nums[i]; 

            max = Math.max(max,total);
        }

        return max; 
    }
}