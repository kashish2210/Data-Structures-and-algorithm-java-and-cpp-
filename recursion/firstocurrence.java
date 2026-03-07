import java.util.*;
public class firstocurrence{
    public static int firstocurrence(int arr[] , int i,int index){
        if(i == arr.length -1){
            return -1;
        }
        if(arr[index] == i ){
            return index;
        }
        return firstocurrence(arr, i,index+1);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,4,6,7,8,0};
        System.out.println(firstocurrence(arr,4,0));

    }
}