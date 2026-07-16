class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++) adj[i] = new ArrayList<>(); 
        boolean[] visited = new boolean[n];

        for(int[] e : edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int con = 0; 
        Queue<Integer> q = new ArrayDeque<>();

        for(int[] e : edges){
            if(!visited[e[0]]){
                con++;
                visited[e[0]] = true; 
                q.offer(e[0]);

                while(!q.isEmpty()){
                    int cur = q.poll();
                    for(int node : adj[cur]){
                        if(!visited[node]){
                            q.offer(node);
                            visited[node]=true; 
                        }
                    }
                }
            }
        }

        for(int i=0;i<n;i++) if(!visited[i]) con++; 
        return con; 
    }

}
