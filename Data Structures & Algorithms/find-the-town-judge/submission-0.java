class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] t = new int[n+1];

        for(int[] i : trust){
            t[i[1]]++;
            t[i[0]]--;
        }

        for(int j=1;j<=n;j++){
            if(t[j]==n-1) return j;
        }
        return -1; 
    }
}