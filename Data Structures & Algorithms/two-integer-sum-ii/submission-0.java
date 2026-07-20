class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //내림차순
        //return : index 배열 
        //합이 target이 되는 index

        /*
            1. ptr 두개로 합이 같아지면 add해야한다.
            2. 크다면 left--, 작다면 right++.
        */
        int left=0, right=numbers.length-1;
        while(left<right){
            if(numbers[left]+numbers[right] == target) return new int[]{left+1,right+1};

            if(numbers[left]+numbers[right] < target) left++;
            else right--; 
        }
        return new int[]{-1,-1};
    }
}