class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] num) {
        List<Integer> nums = new ArrayList<>();
        for (int n : num) nums.add(n);
        backtrack(new ArrayList<>(),nums);
        return res;
    }

    public void backtrack(List<Integer> paths, List<Integer> nums){
        if(nums.isEmpty()){
            res.add(new ArrayList<>(paths));
            return; 
        }

        for(int i=0;i<nums.size();i++){
            int k = nums.get(i);
            nums.remove(i);
            paths.add(k);
            backtrack(paths,nums);
            nums.add(i,k);
            paths.remove(paths.size()-1);
        }
    }
}