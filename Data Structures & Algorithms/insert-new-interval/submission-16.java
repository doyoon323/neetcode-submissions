class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = 0, end = 0; 
        int min = newInterval[0], max = newInterval[1]; 
        int len = intervals.length;

        for (int i = 0; i < len; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (e < newInterval[0]) {
                start++;
            } else if (s > newInterval[1]) {
                end++;
            } else {
                min = Math.min(min, s);
                max = Math.max(max, e);
            }
        }

        int n = start+1+end;
        int[][] res = new int[n][2];

        for (int i = 0; i < start; i++) {
            res[i] = intervals[i];
        }

        res[start][0] = min;
        res[start][1] = max; 

        int size = len-end;
        for (int i=0;i<end;i++) {
            res[start+1+i] = intervals[size+i];
        }

        return res; 
    }
}