import java.util.*;
public class factorial{
    public static int factorial(int n){
        if( n == 0){
            return 1;
        }
        int n1 = factorial(n-1);
        int n2 = n*factorial(n-1);
        return n2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));

    }
}