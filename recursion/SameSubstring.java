import java.util.*;

public class SameSubstring {

    public static int countSub(String str, int start, int end) {

        if (start == str.length()) {
            return 0;
        }

        if (end == str.length()) {
            return countSub(str, start + 1, start + 1);
        }

        int count = 0;

        if (str.charAt(start) == str.charAt(end)) {
            count = 1;
        }

        return count + countSub(str, start, end + 1);
    }

    public static void main(String[] args) {
        String str = "abcab";
        System.out.println(countSub(str, 0, 0));
    }
}