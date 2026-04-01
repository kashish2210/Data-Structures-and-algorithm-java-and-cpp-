import java.util.*;

public class pushAtBotton{
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0  i < str.length() ; i++){
            s.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            char curr = s.pop();
            sb.append(curr);
        }
        return sb.toString();
    }
    public static void main(String args[]){
        String str = "Kashish";
        String res = reverseString(str);
        System.out.println(res);
    }
}