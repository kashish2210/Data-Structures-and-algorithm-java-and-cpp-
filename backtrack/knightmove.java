import java.util.*;

public class KnightTour {

    static int N = 5;

    public static void printBoard(int[][] board){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int x, int y, int[][] board){
        return (x>=0 && y>=0 && x<N && y<N && board[x][y] == -1);
    }

    public static boolean solveKT(int x, int y, int move, int[][] board,
                                  int[] xMove, int[] yMove){

        if(move == N*N){
            printBoard(board);
            return true;
        }

        for(int k=0;k<8;k++){
            int nextX = x + xMove[k];
            int nextY = y + yMove[k];

            if(isSafe(nextX, nextY, board)){
                board[nextX][nextY] = move;

                if(solveKT(nextX, nextY, move+1, board, xMove, yMove))
                    return true;

                board[nextX][nextY] = -1; // backtrack
            }
        }
        return false;
    }

    public static void main(String[] args){

        int[][] board = new int[N][N];

        for(int i=0;i<N;i++)
            Arrays.fill(board[i], -1);

        int[] xMove = {2,2,-2,-2,1,1,-1,-1};
        int[] yMove = {1,-1,1,-1,2,-2,2,-2};

        board[0][0] = 0;

        if(!solveKT(0,0,1,board,xMove,yMove)){
            System.out.println("No solution exists");
        }
    }
}