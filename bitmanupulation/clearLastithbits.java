import java.util.*;

public class clearLastithbits{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");
        int n = sc.nextInt();
        System.out.println("enter the ith bit till u want to clear");
        int i = sc.nextInt();
        int bitmask = ~0<<i;
        System.out.println(n&bitmask);
    }
}