import java.util.*;

public class fastExpo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int a = sc.nextInt();
        System.out.println("Enter the power:");
        int n = sc.nextInt();
        sc.close();
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans= ans*a;
            }
            a = a*a;
            n = n >> 1;
        }
        System.out.println("ans:  " + ans);
    }
}
