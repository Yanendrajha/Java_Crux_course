public class Queen_Combination_2D_Box_Respect{
        public static void main(String[] args){
            QueenCombination2DBoxRespect(new boolean[2][2],0,0,0,2, "");
        }
        public static void QueenCombination2DBoxRespect(boolean[][] board, int row,int col, int qpsf, int tq, String ans){

            // Positive base case
            if(qpsf == tq){
                System.out.println(ans);
                return;
            }

//            // Manually Variable Change;
//            if(col == board[0].length){
//                //Board[0].length will give the horizontal length
//                // Or the number of column+1;
//               row ++;
//               col = 0;
//            }

            // Automated Value Change
            if(col == board[0].length){
                QueenCombination2DBoxRespect(board,row+1,0,qpsf,tq,ans);
                return;
            }

            // Negative base case
            if(row == board.length){
                // board.length will give the length of array vertically
                // Or the number of rows+1;
                return;
            }

            // Placed Condition
            board[row][col] = true;
            // It's in the stack, as function get executed variable inside the function call
            // Get back to its Previous Value. At Last, It's original value.
            QueenCombination2DBoxRespect(board,row,col+1,qpsf+1,tq,ans + "B"+" "+"{"+row+col+"}"+" ");
            // Board data are in Heap, So, we will have to change its data. Exclusive Backtracking.
            board[row][col] = false;

            // Not Placed
            QueenCombination2DBoxRespect(board,row,col+1,qpsf,tq,ans);
        }
    }