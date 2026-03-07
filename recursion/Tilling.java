import java.util.*;
public class Tilling{
    public static int tilingProblem(int n){ //2 x n (floor size)
        if(n == 0 || n==1){
            return 1;
        }
        int verticalTiles = tilingProblem(n-1);
        int horizontalTiles = tilingProblem(n-2);
        return verticalTiles + horizontalTiles;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(tilingProblem(n));

    }
}