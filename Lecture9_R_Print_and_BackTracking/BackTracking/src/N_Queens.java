public class N_Queens{
    public static void main(String[] args){
        boolean[][] board = new boolean[4][4];
        NQueens(board,0,0,0,board.length, "");
    }
    public static void NQueens(boolean[][] board, int row, int col, int qpsf, int tq, String ans){

        // Positive base case
        if(qpsf == tq){
            System.out.println(ans);
            return;
        }

        // Automated Value Change
        if(col == board[0].length){
            NQueens(board,row+1,0,qpsf,tq,ans);
            return;
        }

        // Negative base case
        if(row == board.length){
            return;
        }

        // Placed Condition (Place only if Safe)
        if(IsItSafeToPlace(board,row,col)){
            board[row][col] = true;
            NQueens(board,row,col+1,qpsf+1,tq,ans + "B"+"{"+row+col+"}"+" ");
            board[row][col] = false;}

        // Not Placed
        NQueens(board,row,col+1,qpsf,tq,ans);
    }

    public static Boolean IsItSafeToPlace(boolean[][] board, int row, int col){
        // Vertical Cases
        //Vertically Upward
        int row_temp = row;
        int col_temp = col;
        while(row_temp != -1){
            if(board[row_temp][col_temp]){
                return false;
            }row_temp--;}

        //Vertically Downward
        row_temp = row;
        col_temp = col;
        while(row_temp != board.length){
            if(board[row_temp][col_temp]){
                return false;
            }row_temp++;}

        // Horizontal Cases
        // Horizontally left
        row_temp = row;
        col_temp = col;
        while(col_temp != -1){
            if(board[row_temp][col_temp]){
                return false;
            }col_temp--;}

        //Horizontally right
        row_temp = row;
        col_temp = col;
        while(col_temp != board[0].length){
            if(board[row_temp][col_temp]){
                return false;
            }col_temp++;}

        // Diagonal Cases
        //Diagonal Upper right
        row_temp = row;
        col_temp = col;
        while(col_temp != board[0].length && row_temp != -1 ){
            if(board[row_temp][col_temp]){
                return false;
            }row_temp--; col_temp++;
        }

        // Diagonal Lower left
        row_temp = row;
        col_temp = col;
        while(col_temp != -1 && row_temp != board.length){
            if(board[row_temp][col_temp]){
                return false;
            }col_temp--; row_temp++;}

        //Diagonal Upper left
        row_temp = row;
        col_temp = col;
        while(col_temp != -1 && row_temp != -1 ){
            if(board[row_temp][col_temp]){
                return false;
            }row_temp--; col_temp--;
        }
        // Diagonal Lower right
        row_temp = row;
        col_temp = col;
        while(col_temp != board[0].length && row_temp != board.length){
            if(board[row_temp][col_temp]){
                return false;
            }col_temp++;row_temp++;}

        return true;
    }
}