import java.util.*;

public class clearRangeithbits  {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");
        int n = sc.nextInt();
        System.out.println("enter the range from: ");
        int i = sc.nextInt();
        System.out.println("to");
        int j = sc.nextInt();
        int a = ((~0)<<(j+1));
        int b = (1<<i)-1;
        int bitmask = a|b;
        System.out.println(n&bitmask);
    }
}