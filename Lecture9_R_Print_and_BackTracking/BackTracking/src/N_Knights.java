public class N_Knights {
    public static void main(String[] args){
        boolean[][] board = new boolean[3][3];
        NKnights(board,0,0,0,board.length,"");
        }
    public static void NKnights(boolean[][] board, int row, int col, int kpsf, int tk, String ans){
        // Positive base case
        if(kpsf == tk){
            System.out.println(ans);
            return;
        }

        // Row & col adjustment
        if (col == board[0].length){
            NKnights(board,row+1,0,kpsf,tk,ans);
            return;}

        // Negative base case
        if(row == board.length){
            return;
        }



        //PLaced Condition
        if(IsItSafeToPlace(board,row,col)){
        board[row][col] = true;
        NKnights(board,row,col+1,kpsf+1,tk,ans + "K"+"{"+row+col+"}"+" ");
        board[row][col] = false;}

        // Not placed condition
        NKnights(board,row,col+1,kpsf,tk,ans);
    }

    public static boolean IsItSafeToPlace(boolean[][] board, int row, int col){

        int[] rowArr = {-1, -2, -2, -1};
        int[] colArr = {+2,+1,-1,-2};

        for(int i = 0; i< 4; i++){
            int r = row + rowArr[i];
            int c = col + colArr[i];

            if ( r >= 0 &&  r < board.length && c > -1 && c < board[0].length){
                if(board[r][c]){
                    return false;
                }
            }
        }
        return  true;
    }
}
