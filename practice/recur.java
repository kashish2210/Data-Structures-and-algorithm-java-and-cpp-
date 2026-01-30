public class recur {

    public static int compute(int x) {
        if (x <= 1)
            return x;
        return x + compute(x - 2);
    }

    public static void main(String[] args) {
        int result = 0;

        for (int i = 1; i <= 5; i++) {
            result += compute(i);
        }

        System.out.println(result);
    }
}

