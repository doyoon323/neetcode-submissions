class Solution {
    List<List<Integer>> res = new ArrayList<>(); 
    int n; 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        /*
        문제정의: candidate의 선택한 원소의 합이 target이 되는 모든 경우의 수를 골라라.
        조건1. 중복된 조합이 없을 것
        조건2. candidate는 중복될 수 있음
        조건3. 적어도 하나는 선택될 것. 
        edge case : target == 0
        edge case : target < candidate의 각 숫자 
        edge case : target이 cnadidate의 원소합으로 나올 수 없는 수. 

        사고과정
        1. 사용하거나, 사용하지 않거나이다. 그런데 그 원소가 target보다 크다면 확정적으로 사용안함
        2. 중복된 값 (2,2)를 살 수 있으나, 조합은 겹치면 안된다. 이게 좀 까다롭다. 당장 생각나는건 마지막 res에서 필터링해주는것(O(res.size())) 근데 비효율적이다.
            -> idx-1 == idx 지나친 것과 똑같은 값이 나왔다.
            직전에 넣었으면, 이번에 같은 값이라면 넣거나 안넣어야하고.
            직전에 넣지 않았고 같은값이면 넣지 않아야한다. 
            -> sort를 하고, 직전 상태(넣었니?안 넣었니?)를 관리하는 변수를 넣는다. 
        3. ==target이 되는 경우에는 res에 넣어주어야한다. 
        */
        n = candidates.length;
        Arrays.sort(candidates);
        dfs(0,true, new ArrayList<>(),0 , candidates, target);
        return res; 
    }
    public void dfs(int idx, boolean prev,List<Integer> history, int sum, int[] candidates, int target){
        if(sum == target){
            res.add(new ArrayList<>(history));
            return;
        }
        if(idx == n || candidates[idx]>target || sum > target || sum+candidates[idx]>target ) return; //넣을 것이 더 크다면? prune
         //idx-1까지가 정답

        if(idx>0 && candidates[idx]==candidates[idx-1] && !prev)  dfs(idx+1,false, history,sum, candidates,target);
        else{
            dfs(idx+1,false, history,sum, candidates,target);
            history.add(candidates[idx]);
            dfs(idx+1, true, history,sum+candidates[idx],candidates,target);
            history.remove(history.size()-1);
        }
    }
}
