import java.util.*;
public class removeDuplicate{
    public static void removeDuplicateFromStiring(String str , int index , StringBuilder sb, boolean map[]){ //2 x n (floor size)
        if(index == str.length()){
            System.out.println(sb);
            return;
        }
        char cur = str.charAt(index);
        if(map[cur - 'a']==true){
            removeDuplicateFromStiring(str , index +1 , sb , map);
        }
        else{
            map[cur - 'a'] = true;
            removeDuplicateFromStiring(str ,index+1, sb.append(cur),map);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        removeDuplicateFromStiring(str, 0 , new StringBuilder(""), new boolean[26]);

    }
}