import java.util.*;

public class gridways_optimize {

    public static long factorial(int n){
        long fact = 1;
        for(int i = 1; i <= n; i++){
            fact *= i;
        }
        return fact;
    }

    public static long gridWays(int n, int m){
        int totalMoves = n + m - 2;
        int downMoves = n - 1;

        return factorial(totalMoves) /
               (factorial(downMoves) * factorial(totalMoves - downMoves));
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println("total way to solve this solution : " + gridWays(n, m));
    }
}