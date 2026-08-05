class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found=false;
        int r=matrix.length-1,c=0;

        while(!found){
            if(matrix[r][c]==target){
                found = true;
                break;
            }
            
            if(matrix[r][c]>target){
                r--;
                if(r<0) break;
            }else{
                c++; 
                if(c>=matrix[0].length) break; 
            }
        }
        return found;
    }
}
