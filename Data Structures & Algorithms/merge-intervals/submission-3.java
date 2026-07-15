class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals; 

        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<int[]> res = new ArrayList<>(); 
        res.add(intervals[0]);

        int n = 0; 
        for(int i=1;i<intervals.length;i++){
            int[] cur = intervals[i];

            if(res.get(n)[1]>=cur[0]) {
                int max = Math.max(res.get(n)[1],cur[1]);
                res.get(n)[1]=max;
            }
            else {
                res.add(cur);
                n++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
