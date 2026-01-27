import java.util.*;

public class Swap {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        int a = sc.nextInt();

        System.out.println("Enter b number:");
        int b = sc.nextInt();
        if(a==b){
            System.out.println("After swapping:");
            System.out.println("a is now " + a);
            System.out.println("b is now " + b);
        }else{
            // XOR swap
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;

            System.out.println("After swapping:");
            System.out.println("a is now " + a);
            System.out.println("b is now " + b);
        }

        sc.close();
    }
}
