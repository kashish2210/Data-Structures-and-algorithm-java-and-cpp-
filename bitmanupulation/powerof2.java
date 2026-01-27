import java.util.*;

public class powerof2{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");
        int n = sc.nextInt();
        if((n&(n-1))==0){
            System.out.println("yes it is power of 2 :)");
        }else{
            System.out.println("no it is not a power of two :(");
        }
    }
}