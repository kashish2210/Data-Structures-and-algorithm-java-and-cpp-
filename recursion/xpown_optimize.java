import java.util.*;
public class xpown_optimize{
    public static int calcxpown(int x , int n){
        if(n==0) return 1;
        int half1 = calcxpown(x, n/2);
        int half = half1*half1;
        if(n%2 != 0){
            half = x*half;
        }
        return half;//O(log n)
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(calcxpown(x,n));

    }
}