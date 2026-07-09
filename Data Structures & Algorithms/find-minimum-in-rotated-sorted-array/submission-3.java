class Solution {
    public int findMin(int[] nums) {
        int res = nums[0]; 
        int left=0, right = nums.length-1; 


// mid가 min보다 작다? -> rot되어있으며, 0초과 mid미만을 훑어야함.
// mid가 min보다 크다? -> 0~mid까지 오름차순 정렬되어있으며, mid초과 right까지 살펴보아야한다. 
        while(left<=right){
            int mid=(left+right)/2; 
            res = Math.min(res,nums[mid]);
            System.out.println("left,right, res: " + left+" " +right+" "+ res);

            if(nums[mid]< nums[left]) right = mid-1;
            else {
                res = Math.min(res,nums[left]);
                left = mid+1; 
            }
        }

        return res; 
    }
}