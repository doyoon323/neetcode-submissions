class Solution {
    boolean[][] visited; 
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    int r,c;
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        r = grid.length;
        c = grid[0].length;
        visited = new boolean[r][c];
        boolean found = false; 

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    found=true;
                    perimeter = dfs(j,i,grid);
                    break; 
                }
            }
            if(found) break; 
        }
        
        return perimeter; 
    }

    public int dfs(int x,int y,int[][] map){
        visited[y][x]=true; 
        int dir=0; 

        for(int d=0;d<4;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];

            if(nx<0||ny<0||nx>=c||ny>=r||map[ny][nx]==0){
                dir++;
                continue;
            }
           
            if(!visited[ny][nx]){
                dir+=dfs(nx,ny,map); 
            }
        }
        return dir; 
    }
}