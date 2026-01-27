import java.util.*;

public class oddeven{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bitmask = 1;
        if((n & bitmask)==0){
            System.out.println("even number");
        }else{
            System.out.println("odd number");
        }
    }
}