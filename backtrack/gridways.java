import java.util.*;
public class gridways{
    public static int gridWaays( int i , int j ,int n ,int m){
        if(i == n-1 && j == m-1){
            return 1;
        }else if(i == n || j==n){
            return 0;
        }
        int w1 = gridWaays(i+1, j , n , m);
        int w2 = gridWaays(i, j+1 , n , m);
        return w1 + w2;
    }
    static int count = 0;
    public static void main(String[] args) {
        int n =3,  m = 3;
        System.out.println("total way to solve this solution : "+gridWaays(0, 0 ,n , m));
    }
}