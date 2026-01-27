import java.util.*;

public class UpdateIthBit {

    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);
        return (n & bitmask);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number:");
        int n = sc.nextInt();

        System.out.println("Enter the ith bit you want to change:");
        int i = sc.nextInt();

        System.out.println("Enter the new bit (0 or 1):");
        int newbit = sc.nextInt();

        while (newbit != 0 && newbit != 1) {
            System.out.println("Please enter only 0 or 1:");
            newbit = sc.nextInt();
        }

        n = clearIthBit(n, i);      // clear ith bit
        int bitmask = newbit << i; // set new bit

        System.out.println("Updated number: " + (n | bitmask));

        sc.close();
    }
}
