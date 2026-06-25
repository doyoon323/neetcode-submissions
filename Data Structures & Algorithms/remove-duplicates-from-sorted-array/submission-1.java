class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        int n= nums.length;
        int num=nums[0];

        for(int i=1;i<n;i++){
            if(nums[i]!=num){
                nums[k] = nums[i]; 
                num = nums[i]; //update
                k++; //increment 
            }
        }
        return k; 
    }
}