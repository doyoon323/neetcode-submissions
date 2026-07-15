class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals; 
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int n = 0;
        for(int i=1;i<intervals.length;i++){
            int[] cur = intervals[i];

            if(intervals[n][1]>=cur[0]) {
                int max = Math.max(intervals[n][1],cur[1]);
                intervals[n][1]=max;
            }
            else {
                n++;
                intervals[n] = intervals[i];
            }
        }
        int[][] res = new int[n+1][2];
        for(int i=0;i<=n;i++){
            res[i]=intervals[i];
        }

        return res; 
    }
}
