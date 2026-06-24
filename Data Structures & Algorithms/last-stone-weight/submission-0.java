class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a); 

        for (int x : stones) pq.offer(x); 

        while(pq.size()>1){
            int h1 = pq.poll();
            int h2 = pq.poll(); 
            
            if(h1==h2) continue; 
            if(h1>h2){
                pq.offer(h1-h2);
            }
        }

        if(pq.size()==0) return 0;
        else return pq.peek(); 
    }
}
