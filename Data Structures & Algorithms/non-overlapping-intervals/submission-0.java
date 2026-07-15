class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        int n =0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[n][1] <= intervals[i][0]){
                n++;
                intervals[n] = intervals[i];
                continue; 
            }

            if(intervals[n][1]>intervals[i][1]){
                intervals[n] = intervals[i];
            }
        }
        return intervals.length-(n+1);
    }
}
