class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) 
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});
        minCost[src] = 0;

        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if (node == dst) {
                min = Math.min(min, cost);
                continue;
            }

            if (stops > k) continue;

            for (int[] next : adj.get(node)) {
                int nextNode = next[0];
                int nextCost = cost + next[1];

                if (nextCost >= min) continue;

                if (nextCost < minCost[nextNode]) {
                    minCost[nextNode] = nextCost;
                    q.offer(new int[]{nextNode, nextCost, stops + 1});
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}