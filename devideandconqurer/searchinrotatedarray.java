import java.util.*;
public class searchinrotatedarray{
    public static void printarray(int[] arr){
        for(int i = 0 ; i <arr.length;i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();
    }
    
    public static int search(int[] arr , int tar, int si , int ei){
        int mid = si + (ei - si)/2;
        if(arr[mid] == tar){
            return mid;
        }
        if(arr[si] <= arr[mid]){
            if(arr[si] <= tar && tar <= arr[mid]){
                return search(arr,tar,si,mid-1);
            }
            else{
                return search(arr,tar,mid + 1,ei);
            }
        }
        else{
            if(arr[mid] <= tar&& tar <=arr[ei]){
                return search(arr,tar,mid + 1,ei);
            }else{
                return search(arr,tar,si,mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr ={1,7,3,34,1,8,1,90,2};
        int target = 8;
        int targetIdx = search(arr,target , 0 , arr.length-1);
        System.out.println(targetIdx);

    }
}

