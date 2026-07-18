class Solution {
    boolean[][] visited;
    int r,c;
    public boolean exist(char[][] board, String word) {
        r=board.length;
        c=board[0].length;

        visited = new boolean[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(j,i,word,1,board)) return true;
                }
            }
        }
        return false; 
    }
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};

    public boolean dfs(int x,int y,String word, int idx,char[][] board){
        visited[y][x] = true; 
        if(idx==word.length()) return true; 

        for(int d=0;d<4;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx<0||ny<0||nx>=c||ny>=r) continue;

            if(!visited[ny][nx] && board[ny][nx]==word.charAt(idx)){
                if(dfs(nx,ny,word,idx+1,board)) return true;
            }
        }
        visited[y][x] = false; 
        return false; 
    }
}
