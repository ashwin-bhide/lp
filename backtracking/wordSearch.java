class Solution {
    public boolean exist(char[][] board, String word) {
        //we are going to traverse through the board to find first character of the fird word
        //once found, we'll  trigger a dfs
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(existHelper(board,i,j,word,0)){
                        return true;
                }
            }
        }
        return false;
    }
    private boolean existHelper(char[][] board,int r,int c,String word,int index){
        //base condition
        if(index==word.length())
            return true;
        
        //constraint, if r,c go out of board bounds, or char we are at is not equal to char at curr index
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!=word.charAt(index))
            return false;
        
        char temp = board[r][c];
        //choose, if we have found char mark it as chosen
        board[r][c] = ' ';
        //explore
        boolean isFound = existHelper(board,r+1,c,word,index+1)
                        || existHelper(board,r-1,c,word,index+1)
                        || existHelper(board,r,c+1,word,index+1)
                        || existHelper(board,r,c-1,word,index+1);
        //unchoose
        board[r][c] = temp;
        return isFound;
    }
}
