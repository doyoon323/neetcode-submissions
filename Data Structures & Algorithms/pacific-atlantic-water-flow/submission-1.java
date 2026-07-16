class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return res;

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacificVisit = new boolean[n][m];
        boolean[][] atlanticVisit = new boolean[n][m];
        
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1}; 

        Queue<int[]> q = new ArrayDeque<>(); 

        for (int i=0;i<m;i++) {
            q.offer(new int[]{0,i});
            pacificVisit[0][i] = true; 
        }
        for (int i=0;i<n;i++) {
            if (!pacificVisit[i][0]) {
                q.offer(new int[]{i,0});
                pacificVisit[i][0] = true; 
            }
        }
        bfs(heights, q, pacificVisit, dy, dx, n, m);

        for (int i=0;i<m;i++) {
            q.offer(new int[]{n-1, i});
            atlanticVisit[n-1][i] = true; 
        }
        for (int i=0;i<n;i++) {
            if (!atlanticVisit[i][m-1]) {
                q.offer(new int[]{i, m-1});
                atlanticVisit[i][m-1] = true; 
            }
        }

        bfs(heights,q,atlanticVisit,dy,dx,n,m);

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (pacificVisit[i][j] && atlanticVisit[i][j]) {
                    res.add(Arrays.asList(i,j));
                }   
            }
        }
        return res;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] visit, int[] dy, int[] dx, int n, int m) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue; 
                if (visit[ny][nx]) continue;

                if (heights[ny][nx] >= heights[cy][cx]) {
                    visit[ny][nx] = true;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
    }
}