class Solution {
    public int subsetXORSum(int[] nums) {//넣을까 말까
        return dfs(0,0,nums);
    }

    public int dfs(int idx,int xor, int[] nums){
        if(idx == nums.length) return xor;

        return dfs(idx+1,xor,nums) + dfs(idx+1,xor^nums[idx],nums); // x && o 
    }
}