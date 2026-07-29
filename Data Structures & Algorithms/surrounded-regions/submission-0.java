class Solution {
    int m,n;
    boolean[][] visited; 
    public void solve(char[][] board) {
        //가장자리의 'O'를 찾고, bfs(or dfs) 하면 된다. 방문처리.
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int x=0;x<n;x++){
            if(board[0][x]=='O' && !visited[0][x]) dfs(x,0,board);

            if(board[m-1][x]=='O' && !visited[m-1][x]) dfs(x,m-1,board);
        }

        for(int y=0;y<m;y++){
            if(board[y][0]=='O' && !visited[y][0]) dfs(0,y,board);
            if(board[y][n-1]=='O' && !visited[y][n-1]) dfs(n-1,y,board);
        }

        for(int y=0;y<m;y++)
            for(int x=0;x<n;x++){
                if(!visited[y][x] && board[y][x]=='O') board[y][x]='X';
            }


    }

    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};

    public void dfs(int x, int y, char[][] b){
        visited[y][x] = true; 

        for(int d=0;d<4;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];

            if(nx<0||ny<0||nx>=n||ny>=m) continue;
            
            if(b[ny][nx]=='O' && !visited[ny][nx]){
                dfs(nx,ny,b);
            }
        }
    }
}
