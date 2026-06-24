class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();//min heap 
    int limit;
    int[] arr;  


    public KthLargest(int k, int[] nums) {
        limit = k; 
        for(int x : nums) {
            if(pq.size()==limit){
                if(pq.peek() < x){
                    pq.poll();
                    pq.offer(x);
                }
                continue;
            }
            if(pq.size()<limit) pq.offer(x); 
        }
    }

    public int add(int val) {
        if(pq.size()<limit) {
            pq.offer(val); 
            return pq.peek(); 
        }
        if(pq.size()==limit){
            if(pq.peek() < val){
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek(); 
    }
}
