import java.util.*;
public class Solution {
    public static boolean isDuplicate(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =  0 ; i < s.length() ;i++){
            char ch = s.charAt(i);
            //closing
            if(ch == ')'){
                int count =0;
                while(stack.pop() != '('){
                    count++;
                }
                if(count < 1){
                    return true;
                }
            }//opening
            else{
                    stack.push(ch);
                }
        }
        return false;
    }
    public static void main(String args[]){
        String str = "(a+b+(a+c))";
        System.out.println(isDuplicate(str));
        str = "((a+b+(a+b)))";
        System.out.println(isDuplicate(str));
    }
}