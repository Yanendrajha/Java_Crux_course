import java.util.Arrays;

public class Maze_Path {
    public static int Maze_Path_Recursion(int cr, int cc, int er, int ec){
        if( cr ==  er && cc ==ec){
            return 1;
        }
        if(cr>er || cc > ec){
            return 0;
        }

        int ch = Maze_Path_Recursion(cr,cc+1,er,ec);
        int cv = Maze_Path_Recursion(cr+1, cc, er,ec);

        return ch+cv;

    }

    public static int Maze_Path_Top_Down_DP(int cr, int cc, int er, int ec, int[][] strg){
        if( cr ==  er && cc ==ec){
            return 1;
        }
        if(cr>er || cc > ec){
            return 0;
        }
        if(strg[cr][cc] != 0){
            return strg[cr][cc];
        }

        int ch = Maze_Path_Top_Down_DP(cr,cc+1,er,ec,strg);
        int cv = Maze_Path_Top_Down_DP(cr+1, cc, er,ec,strg);

        return ch+cv;

    }

    public static int Maze_path_Bottom_Up_DP(int er, int ec){
        int[][] strg = new int[er+2][ec+2];
        for(int row = er; row>=0 ; row--){
            for(int col = ec; col>=0; col--){
                if(row == er && col==ec){
                    strg[row][col] = 1;
                }else{
                    strg[row][col] = strg[row][col+1]+ strg[row+1][col];
                }
            }
        }
        return strg[0][0];
    }

    public static int Maze_Path_Bottom_Up_Space_Efficient(int er, int ec){
        int[] strg = new int[ec+1];
        Arrays.fill(strg,1);
        for(int slide = er-1; slide >=0 ; slide--){
            for(int col = ec; col >=0 ; col--){
                if(col == ec){
                    strg[col] = 1;
                }else{
                    //Updated value col = old value at col + new value at col + 1;
                    strg[col] = strg[col]+strg[col+1];
                }
            }
        }
        return strg[0];
    }
}
