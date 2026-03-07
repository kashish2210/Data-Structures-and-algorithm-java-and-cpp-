import java.util.*;
public class fibonacii{
    public static int fibo(int n){
        if( n == 0){
            return 0;
        }
        if( n == 1){
            return 1;
        }
        int n1 = fibo(n-1);
        int n2 = fibo(n-2);
        int fib = n1 + n2;
        return fib;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(n));

    }
}