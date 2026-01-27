import java.util.*;

public class getithbit{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");
        int n = sc.nextInt();
        System.out.println("enter the ith bit u want to know");
        int i = sc.nextInt();
        int bitmask = 1<<i;
        if((n & bitmask)==0){
            System.out.println("0");
        }else{
            System.out.println("1");
        }
    }
}