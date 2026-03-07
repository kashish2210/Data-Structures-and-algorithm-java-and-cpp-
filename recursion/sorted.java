import java.util.*;
public class sorted{
    public static boolean isSort(int arr[] , int i){
        if(i == arr.length -1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSort(arr,i+1);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,7,8,0};
        System.out.println(isSort(arr,4));

    }
}