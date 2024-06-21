public class Queen_Combination_Box_Respect {
    public static void main(String[] args){
        QueenCombinationBoxRespect(new boolean[4],0,0,2,"");
    }
    public static void QueenCombinationBoxRespect(boolean[] board, int col, int qpsf, int tq, String ans){

        // Positive base case
        if(qpsf == tq){
            System.out.println(ans);
            return;
        }

        // Negative base case
        if(col == board.length){
            return;
        }

        // Placed Condition
        board[col] = true;

                 // It's in the stack, as function get executed variable inside the function call
                // Get back to its Previous Value. At Last, It's original value.
        QueenCombinationBoxRespect(board,col+1,qpsf+1,tq,ans + "B"+col);

                // Board data are in Heap, So, we will have to change its data. Exclusive Backtracking.
        board[col] = false;

        // Not Placed
        QueenCombinationBoxRespect(board,col+1,qpsf,tq,ans);

    }
}
