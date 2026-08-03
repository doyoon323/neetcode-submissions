class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
        중복된값이 있다. 
        subset을 구하세요.
        */

        Arrays.sort(nums);
        backtrack(0,nums,new ArrayList<>(), true);
        
        return res; 
    }

    public void backtrack(int idx, int[] nums, List<Integer> path, boolean prev){
        if(idx == nums.length){
            res.add(new ArrayList<>(path));
            return; 
        }
        
        if(idx>0 && nums[idx]==nums[idx-1] && !prev) backtrack(idx+1,nums,path,false);
        else{
            backtrack(idx+1, nums,path,false);
            path.add(nums[idx]);
            backtrack(idx+1,nums,path,true);
            path.remove(path.size()-1);
        }
        
    }
}
