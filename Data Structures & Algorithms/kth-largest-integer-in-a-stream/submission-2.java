class KthLargest {

    private final PriorityQueue<Integer> pq = new PriorityQueue<>();
    private final int limit;


    public KthLargest(int k, int[] nums) {
        this.limit = k;
        for (int x : nums) add(x);
    }

    public int add(int val) {
        pq.offer(val);

        if(pq.size()>limit) pq.poll(); 

        return pq.peek(); 
    }
}
