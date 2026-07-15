class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[1],b[1]));
        int n =0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[n][1] <= intervals[i][0]){
                n++;
                intervals[n] = intervals[i];
            }
        }
        return intervals.length-(n+1);
    }
}
