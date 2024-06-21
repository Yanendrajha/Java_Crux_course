
public class N_Queen_Per_Row {
    // Static means accessible & changeable (Changes Persist) within the class.
    static int count = 0;
    public static void main (String[] args){

        boolean[][] board = new boolean[4][4];
        //NQueen2(board,0,0,board.length,"");
        KQueen2(board,0,0,3,"");

    }

    // For NxN , and No. of Queens to be placed is also N.
    public static void NQueen2(boolean[][] board, int row,int qpsf, int tq, String ans){
        // Positive Case
        if(qpsf == tq){
            System.out.println(++count + ". " + ans);
            return;
        }
        //Negative case
        if(row == board.length){
            return;
        }
        // Whenever we do a recursive call; everything till recursive call statement Gets executed.

        for(int col = 0; col < board[0].length; col++){
            // Placing queen
            if(Queen_Combination_2D_Kill.IsItSafeToPlace(board,row,col)){
            board[row][col] = true;
            NQueen2(board, row+1, qpsf+1,tq,ans + "B"+"{"+row+col+"}");
            board[row][col] = false;}
        }
    }
    public static void KQueen2(boolean[][] board, int row,int qpsf, int tq, String ans){

        // Positive Case
        if(qpsf == tq){
            System.out.println(++count + ". " + ans);
            return;
        }

        //Negative case
        if(row == board.length){
            return;
        }

        // Whenever we do a recursive call; everything till recursive call statement Gets executed.

        // Options : Options
        for(int col = 0; col < board[0].length; col++){
            // Placing queen
            if(Queen_Combination_2D_Kill.IsItSafeToPlace(board,row,col)){
                board[row][col] = true;
                KQueen2(board, row+1, qpsf+1,tq,ans + "B"+"{"+row+col+"}");
                board[row][col] = false;}
            }
        // Not place
        KQueen2(board,row+1,qpsf, tq, ans);
    }
}
