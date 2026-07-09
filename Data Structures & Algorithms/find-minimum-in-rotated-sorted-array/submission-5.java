class Solution {
    public int findMin(int[] nums) {
        int res = nums[0]; 
        int left=0, right = nums.length-1; 


        while(left<right){
            int mid=(left+right)/2; 

            if(nums[mid] > nums[right]) left = mid+1;
            else {
                right = mid;  
            }
        }

        return nums[left]; 
    }
}