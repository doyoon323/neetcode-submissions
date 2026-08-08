class Solution {
    public int findKthLargest(int[] nums, int k) {
        //can not be unique
        //return kths elemeent in sorted array 
        //k size 힙에 push한다. largest니까 k size max-heap.

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int x : nums) {
            pq.offer(x);
        }

        for(int i=0;i<k-1;i++) pq.poll(); 

        return pq.peek();
    }
}
