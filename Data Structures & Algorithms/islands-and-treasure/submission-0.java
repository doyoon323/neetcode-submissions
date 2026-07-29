class Solution {
    int INF = 2147483647;
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};

    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) dfs(grid,j,i,0);
            }
        }
    }

    public void dfs(int[][] grid, int x,int y, int dist){
        dist++; 
        for(int d=0;d<4;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx<0||ny<0||nx>=grid[0].length||ny>=grid.length) continue; 

            if(grid[ny][nx]== INF || grid[ny][nx] > dist){
                grid[ny][nx] = Math.min(dist,grid[ny][nx]);
                dfs(grid,nx,ny,dist);
            }
        }
    }
}
