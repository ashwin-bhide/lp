class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0)
            return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int r = row-1;
        int c = 0;
        
        while(r>=0 && c<col){
            if(target==matrix[r][c])
                return true;
            else if(target>matrix[r][c])
                c = c+1;
            else
                r = r-1;
        }
        
        return false;
    }
}
