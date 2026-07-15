/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> time = new ArrayList<>();
        if(intervals.size()==0) return 0; 
        intervals.sort(Comparator.comparing(a -> a.start));
        
        time.add(intervals.get(0).end);

        for(int i=1;i<intervals.size();i++){
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;

            int idx = -1; 

            for(int j=0;j<time.size();j++){
                if(start >= time.get(j)){
                    idx = j;
                    break; 
                }
            }
            if(idx!=-1) time.set(idx,end);
            else time.add(end);
        }
        return time.size();
    }
}
