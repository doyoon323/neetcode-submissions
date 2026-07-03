class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums.length/2; 
        HashMap<Integer,Integer> map = new HashMap<>(); 

        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
            if(map.get(x)>majority) return x; 
        }
        return -1; 
    }
}