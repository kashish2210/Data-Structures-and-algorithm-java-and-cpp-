import java.util.*;
public class sum{
    public static int sumn(int n){
        if( n == 1){
            return 1;
        }
        int n1 = sumn(n-1);
        int n2 = n+ n1;
        return n2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumn(n));

    }
}