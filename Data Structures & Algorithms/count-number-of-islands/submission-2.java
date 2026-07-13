class Solution {

    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    int m,n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0; 

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    bfs(j,i,grid);
                    res++; 
                }
            }
        }
        return res; 
    }

    public void bfs(int x,int y,char[][] grid){
        Queue<int[]> q = new ArrayDeque<>(); 
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] cur = q.poll(); 
            
            for(int d=0;d<4;d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx<0||ny<0||nx>=n||ny>=m) continue;

                if(grid[ny][nx]=='1'){
                    q.offer(new int[]{nx,ny});
                    grid[ny][nx]='0';
                }
                
            }
        }
    }
}
