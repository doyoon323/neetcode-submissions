class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        for(int x: nums){
            if(h.contains(x)) return true;
            h.add(x); 
        }
        return false; 
    }
}