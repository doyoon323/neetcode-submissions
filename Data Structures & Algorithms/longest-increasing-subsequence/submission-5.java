class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int[] tails = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int idx = Arrays.binarySearch(tails, 0, len, num); 
            if (idx < 0) idx = -(idx + 1);
            tails[idx] = num;
            
            if (idx==len) len++;
        }
        return len;
    }
}