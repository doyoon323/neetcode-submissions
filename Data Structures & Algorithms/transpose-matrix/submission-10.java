class Solution {
    public int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] mx = new int[c][r];

        for(int row=0;row<r;row++){
            for(int col=0;col<c;col++){
                mx[col][row] = matrix[row][col];
            }
        }
        return mx; 
    }
}