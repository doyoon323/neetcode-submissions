class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0; 
        Arrays.sort(nums);
        int len = 1, max = 1; 
        System.out.println(Arrays.toString(nums));
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]) continue;

            if(nums[i-1]+1 == nums[i]) {
                len++;
                max = Math.max(max,len);
            }
            else len = 1; 
        }
        return max; 
    }
}
