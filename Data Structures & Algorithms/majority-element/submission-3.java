class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums.length/2; 
        HashMap<Integer,Integer> map = new HashMap<>(); 

        for(int x : nums){
            if(!map.containsKey(x)) map.put(x,0);
            else map.replace(x,map.get(x)+1);
            if(map.get(x)>=majority) return x; 
        }
        return -1; 
    }
}