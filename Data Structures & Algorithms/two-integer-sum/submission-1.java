class Solution {
    public int[] twoSum(int[] nums, int target) {
        // i!=j && 두개 더했을 때 target 
        HashMap<Integer,Integer> set = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(set.containsKey(nums[i])) continue;

            set.put(nums[i],i);
        }
        int[] res = new int[2]; 
        for(int i=0;i<nums.length;i++){
            if(set.containsKey(target-nums[i]) && set.get(target-nums[i])!=i){
                res[0] = i;
                res[1] = set.get(target-nums[i]);
                break; 
            }
        }
        Arrays.sort(res);
        return res; 
    }
}
