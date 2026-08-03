class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] num) {
        /*
        문제정의: 모든 순열을 나열하시오
        shuffle하는 모든 케이스를 구해야한다. 
        */
        List<Integer> nums = new ArrayList<>();
        for (int n : num) nums.add(n);

        for(int i=0;i<num.length;i++){
            int k = nums.get(i);
            nums.remove(i);
            backtrack(new ArrayList<>(List.of(k)),nums);
            nums.add(i,k);
        }
        return res;
    }

    public void backtrack(List<Integer> paths, List<Integer> nums){
        if(nums.size()==0){
            res.add(new ArrayList<>(paths));
            return; 
        }

        for(int i=0;i<nums.size();i++){
            int k = nums.get(i);
            nums.remove(i);
            paths.add(k);
            backtrack(paths,nums);
            nums.add(i,k);
            paths.remove(paths.size()-1);
        }
    }
}