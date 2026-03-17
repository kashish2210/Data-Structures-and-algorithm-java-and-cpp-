import java.util.*;

public class phoneKeypad {

    static String digits[] = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void keypad(String str, int idx, String ans){

        if(idx == str.length()){
            if(ans.length()==0){
                System.out.println("Null");
            }else{
                System.out.println(ans);
            }
            return;
        }

        int currDigit = str.charAt(idx) - '0';
        String letters = digits[currDigit-1];

        for(int i = 0; i < letters.length(); i++){
            keypad(str, idx+1, ans + letters.charAt(i));
        }
    }

    public static void main(String[] args){
        String input = "1";
        keypad(input, 0, "");
    }
}