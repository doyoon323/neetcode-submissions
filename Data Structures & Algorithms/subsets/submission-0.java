class Solution {
    int n;
    List<List<Integer>> res = new ArrayList<>(); 
    public List<List<Integer>> subsets(int[] nums) {
        /* 문제 정의
        목표값 : nums의 모든 부분 집합을 구할 것
        조건1) nums는 중복값이 없다.
        조건2) 부분집합이 겹치면 안된다. 
        조건3) n도 작네? brute force도 사실상 가능하다.

        edge case) nums의 개수가 0이거나 1개

        풀이사고
        1. 각 원소에서 넣거나 말거나의 문제이다. 
        2. 넣었을 때(혹은 넣지 않았을 때) 다음 원소에서 넣었을 때, 아닐때를 계속 분기하며 가야한다.
        3. 각 원소에서 분기를 한다면 굳이 중복될 일도 없다.

        딱히 prune 할 것도 없어보이는데? dfs로 가면 될듯 하다. 

        1) result는 leaf에서 
        2) 현재가 어떤 node인지 추적가능해야하고
        3) 
        */
        int idx = 0;
        n = nums.length;
        dfs(0, new ArrayList<Integer>(),nums);
        return res;
    }

    public void dfs(int idx, List<Integer> history, int[] nums){
        if(idx==n) {
            res.add(new ArrayList<>(history));
            return; 
        }
        dfs(idx+1,history,nums);
        history.add(nums[idx]);
        dfs(idx+1,history,nums); //idx는 current node loc
        history.remove(history.size()-1);
    }
}