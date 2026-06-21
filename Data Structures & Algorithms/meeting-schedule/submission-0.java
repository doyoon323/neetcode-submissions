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
    public boolean canAttendMeetings(List<Interval> intervals) {
        //List
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        int len = intervals.size();

        for(int i=0;i<len-1;i++){
            if(intervals.get(i).end > intervals.get(i+1).start){
                return false;
            }
        }
        return true; 
    }
}
