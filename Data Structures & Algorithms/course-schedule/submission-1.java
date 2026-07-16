class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        for(int[] c : prerequisites) {
            indegree[c[0]]++;
            adj.get(c[1]).add(c[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) 
            if(indegree[i]==0) q.offer(i);

        int n=0; 
        while(!q.isEmpty()){
            int cur = q.poll();
            n++;

            for(int node: adj.get(cur)){
                if(--indegree[node]==0) q.offer(node);
            }
        }
        return n==numCourses; 
    }
}
