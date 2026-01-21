public class MulUsingBits {
    public static void main(String[] args) {
        int a = 5, b = 6;
        int result = 0;

        while (b != 0) {
            if ((b & 1) == 1) {
                result = add(result, a);
            }
            a <<= 1;
            b >>= 1;
        }

        System.out.println(result); // 30
    }

    static int add(int x, int y) {
        while (y != 0) {
            int carry = (x & y) << 1;
            x = x ^ y;
            y = carry;
        }
        return x;
    }
}
