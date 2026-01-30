public class incre {
    public static void main(String[] args) {
        int a = 4;
        int b = 7;
        int c;

        if (a++ > 4 && ++b > 7) {
            c = a + b;
        } else {
            c = a * b;
        }

        System.out.println(a + " " + b + " " + c);
    }
}
