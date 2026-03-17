import java.util.*;

public class subString{

    public static void printSubstrings(String str, int start, int end) {

        if (start == str.length()) {   // base case
            return;
        }

        if (end == str.length() + 1) { 
            printSubstrings(str, start + 1, start + 1);
            return;
        }

        System.out.println(str.substring(start, end));

        printSubstrings(str, start, end + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        printSubstrings(str, 0, 1);
    }
}