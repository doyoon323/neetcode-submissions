class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //times (u->v,t)
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();


        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];
            graph[u].add(new int[]{v, t});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        q.offer(new int[]{k, 0});


        while(!q.isEmpty()){
            int[] e = q.poll();
            int node = e[0];
            int time = e[1];

            if(time > dist[node]) continue;

            for (int[] next : graph[node]) {
                int nextNode = next[0];
                int nextTime = next[1];

                if (dist[node] + nextTime < dist[nextNode]) {
                    dist[nextNode] = dist[node] + nextTime;
                    q.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
