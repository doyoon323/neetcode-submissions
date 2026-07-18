class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> currentTrack = new ArrayList<>();
        dfs(nums, target, 0, 0, currentTrack);
        return answer;
    }

    public void dfs(int[] nums, int target, int k, int total, List<Integer> currentTrack) {
        if (total > target) return;
        if (total == target) {
            answer.add(new ArrayList<>(currentTrack)); 
            return;
        }
        if (k >= nums.length) return;
        currentTrack.add(nums[k]);
        dfs(nums,target,k, total+nums[k], currentTrack); 
        currentTrack.remove(currentTrack.size()-1); 
        dfs(nums, target, k + 1, total, currentTrack);
    }
}