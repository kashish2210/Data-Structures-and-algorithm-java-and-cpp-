import java.util.*;
public class decreasing{
    public static void decre(int n){
        if( n == 1){
            System.out.print(n);
            return;
        }
        System.out.print(n+" ");
        decre(n-1);
    }
    public static void increase(int n){
        if( n == 1){
            System.out.print(n + " ");
            return;
        }
        increase(n-1);
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        decre(n);
        System.out.println();
        increase(n);

    }
}