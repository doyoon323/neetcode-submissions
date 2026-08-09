class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> r = new ArrayList<>();
        List<Set<Integer>> c = new ArrayList<>();
        List<Set<Integer>> thr = new ArrayList<>();

        for(int i=0;i<board.length;i++)
            r.add(new HashSet<>());

        for(int j=0;j<board[0].length;j++)
            c.add(new HashSet<>());

        for(int k=0;k<3;k++) thr.add(new HashSet<>());

        for(int i=0;i<board.length;i++){
            if(i%3==0){
                thr.get(0).clear();
                thr.get(1).clear();
                thr.get(2).clear();
            }
            int idx = -1; 
            for(int j=0;j<board[0].length;j++){
                if(j%3==0) idx++;
                if(board[i][j]!='.'){
                    if(r.get(i).contains(board[i][j]-'0')) return false;
                    r.get(i).add(board[i][j]-'0');

                    if(c.get(j).contains(board[i][j]-'0')) return false;
                    c.get(j).add(board[i][j]-'0');

                    
                    if(thr.get(idx).contains(board[i][j]-'0')) return false; 
                    thr.get(idx).add(board[i][j]-'0');
                }
            }
        }

        return true; 
    }
}
