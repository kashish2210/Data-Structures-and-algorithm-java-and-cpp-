import java.util.*;
public class basic{
    
    public static void finSubset(String str , String ans , int i){
        // base case
        if(i == str.length()){
            if(ans.length()==0){
                System.out.println("Null");
            }else{
                System.out.println(ans);
            }
            return;
        }
      // recursion
      // yes choice
      finSubset(str , ans + str.charAt(i), i +1);
      //no choice
      finSubset(str , ans, i +1);
    }
    public static void main(String[] args) {
        finSubset("Kashish" , "" , 0);

    }
}