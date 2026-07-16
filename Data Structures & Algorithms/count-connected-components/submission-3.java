class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(n);
        for(int i=0;i<n;i++) adj.add(new ArrayList<>()); 
        boolean[] visited = new boolean[n];

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int con = 0; 
        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(!visited[i]){
                con++;
                visited[i] = true; 
                q.offer(i);

                while(!q.isEmpty()){
                    int cur = q.poll();
                    for(int node : adj.get(cur)){
                        if(!visited[node]){
                            q.offer(node);
                            visited[node]=true; 
                        }
                    }
                }
            }
        }

        return con; 
    }

}
