class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums) map.put(x,map.getOrDefault(x,0)+1);

        int[] top = new int[k];

        for(int n=0;n<k;n++){
            int key=nums[0];
            int cnt=map.get(key); 

            for(int i=1;i<nums.length;i++){
                if(cnt < map.get(nums[i])){
                    cnt = map.get(nums[i]);
                    key = nums[i]; 
                }
            }
            top[n]=key;
            map.put(key,-1);
        }
        return top; 
    }
}
