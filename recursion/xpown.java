import java.util.*;
public class xpown{
    public static int calcxpown(int x , int n){
        if(n==0) return 1;
        return x*calcxpown(x,n-1);//O(n)
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(calcxpown(x,n));

    }
}