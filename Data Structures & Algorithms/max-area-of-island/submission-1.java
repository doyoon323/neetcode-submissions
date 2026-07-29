class Solution {
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1, 0,0};
    public int maxAreaOfIsland(int[][] grid) {
        int max=0; 

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    max = Math.max(max,bfs(j,i,grid));
                }
            }
        }
        return max; 
    }

    public int bfs(int x, int y, int[][] grid){
        grid[y][x] = 0; 
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int area=1;
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] cur = q.poll(); 

            for(int d=0;d<4;d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(nx<0||ny<0||nx>=grid[0].length||ny>=grid.length) continue; 

                if(grid[ny][nx]==1){
                    area++; 
                    grid[ny][nx]=0;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return area; 
    }
}
