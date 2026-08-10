class Solution {
    // 1. public 접근 제어자가 있어야 함
    // 2. 메서드명이 findDuplicate 이어야 함
    // 3. 매개변수가 int[] 배열이어야 함
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}