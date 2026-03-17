import java.util.*;
public class occurance{
    public static void occured(int[] arr , int key , int i){
        int n = arr.length -1;
        if (i == arr.length) {
            return;
        }
        if( arr[i] == key){
            System.out.println(i);
        }
       occured(arr , key , i+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {3,2,4,5,6,2,7,2,2};
        int key = sc.nextInt();
        occured(arr , key , 0);
    }
}

