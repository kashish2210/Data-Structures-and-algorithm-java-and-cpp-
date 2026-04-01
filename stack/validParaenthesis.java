import java.util.*;
public class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } 
            else if(!stack.isEmpty() && (
                    (ch == ')' && stack.peek() == '(') ||
                    (ch == '}' && stack.peek() == '{') ||
                    (ch == ']' && stack.peek() == '[')
            )){
                stack.pop();
            } 
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String args[]){
        String str = "([]){[]]}";
        System.out.println(isValid(str));
    }
}