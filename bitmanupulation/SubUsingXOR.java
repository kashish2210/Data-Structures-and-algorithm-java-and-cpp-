public class SubUsingXOR {
    public static void main(String[] args) {
        int a = 10, b = 3;

        while (b != 0) {
            int borrow = (~a & b) << 1;
            a = a ^ b;
            b = borrow;
        }

        System.out.println(a); // 7
    }
}
