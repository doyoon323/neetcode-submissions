class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //top k points cloesd to (0,0)
        //max queue (k)인걸로 해서.  <dist,idx>로 담기
        //top만 비교하여, 작으면 pop & push하고, 아니면 pass
        //points 전부 순회한 후에, idx를 찾아 int[][]만들고 return. 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        
        for(int j=0;j<k;j++){
            pq.offer(new int[]{points[j][0]*points[j][0]+points[j][1]*points[j][1], j});
        }

        for(int i=k;i<points.length;i++){
            int d = pq.peek()[0];//or peek()
            int dist = points[i][0]*points[i][0]+points[i][1]*points[i][1];
            if(dist<d){
                pq.poll();
                pq.offer(new int[]{dist,i});
            }
        }

        int[][] res = new int[k][2];
        int i=0; 

        while(!pq.isEmpty()){
            int idx = pq.poll()[1];
            res[i]=points[idx];
            i++;
        }
        return res; 
    }
}
