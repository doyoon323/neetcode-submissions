class Solution {
    public int missingNumber(int[] nums) {
        // idea: xor를 두번 하면 사라진다 
        int xor=0;
        for(int i=0;i<=nums.length;i++) xor = xor^i;
        for(int n : nums) xor=xor^n;
        return xor; 
    }
}
