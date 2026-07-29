class Solution {
    public int orangesRotting(int[][] grid) {
        int fruit=0;
        int T=0; 
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2) q.offer(new int[]{j,i,0});
                else if(grid[i][j]==1) fruit++; 
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            T = cur[2]; 
            for(int d=0;d<4;d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (ny < 0 || nx >= grid[0].length || nx < 0 || ny >= grid.length) continue;

                if(grid[ny][nx]==1){
                    fruit--;
                    grid[ny][nx]=2; 
                    q.offer(new int[]{nx,ny,T+1});
                }
            }
        }
        return fruit==0 ? T : -1; 
    }
}
