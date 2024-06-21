public class Blocked_Maze {
    public static void main(String[] args){
        int[][] maze = {{0,1,0,0},{0,0,0,0},{0,1,0,0},{0,0,1,0}};
        BlockedMaze(maze,0,0,"", new boolean[maze.length][maze[0].length]);
    }

    static int count = 0;
    public static void BlockedMaze(int[][] maze, int row, int col, String ans,boolean[][] visited){

        // Positive base case
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(++count +" " +ans);

            return;
        }

        // Negative base case (Boundary Reach)
        if(row == -1 || row == maze.length || col == -1 || col== maze[0].length ){
            return;
        }

        // Negative base case (Already Visited) or (Blocked Cell)
        if(visited[row][col] || maze[row][col] == 1){
            return;
        }

        // Put A Mark
        visited[row][col] = true;

        // Top
        BlockedMaze(maze,row-1,col, ans+"T",visited);

        //Down
        BlockedMaze(maze,row+1,col, ans+"D",visited);

        //Left
        BlockedMaze(maze,row,col-1, ans+"L",visited);

        // Right
        BlockedMaze(maze,row,col+1, ans+"R",visited);

        // Undo
        visited[row][col] = false;
    }
}
