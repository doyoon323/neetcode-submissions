

class Solution {
    int[] parent;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length; 
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        //edges sort
        Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                q.offer(new int[]{i, j, distance});
            }
        }
        int edgesUsed=0,answer=0;
        while (!q.isEmpty() && edgesUsed < n - 1) {
            int[] res = q.poll();
            int p1 = res[0];
            int p2 = res[1];
            int edge = res[2];

            if (union(p1, p2)) {
                answer += edge;
                edgesUsed++;
            }
        }
        return answer;
    }

    public boolean union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px!=py){
            parent[px] = py;
            return true; 
        }
        return false; 
    }

    public int find(int x){
        if(parent[x]==x) return x; 
        return parent[x] = find(parent[x]);
    }
}
