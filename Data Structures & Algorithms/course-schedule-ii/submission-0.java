
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prev = pre[1];
            adj[prev].add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            result[index++] = cur;

            for (int next : adj[cur]) {
                if (--indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return index == numCourses ? result : new int[0];
    }
}