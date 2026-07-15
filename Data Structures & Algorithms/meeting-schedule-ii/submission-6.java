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
        if(intervals.size()==0) return 0; 
        intervals.sort(Comparator.comparing(a -> a.start));

        Queue<Integer> time = new PriorityQueue<>();
        time.offer(intervals.get(0).end);

        for(int i=1;i<intervals.size();i++){
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;

            if(start >= time.peek())time.poll();
            time.offer(end);
        }
        return time.size();
    }
}
