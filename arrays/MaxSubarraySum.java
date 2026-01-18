import java.util.*;

public class subarray{
    public static void main(String args[]){
        int[] arr = {12,5,2,5,1,3};
        int currentSum =0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int start= i;
            for(int j=i; j < arr.length;j++){
                int end = j;
                currentSum =0;
                for (int k = start ; k <= end; k++){0]



                
                    currentSum += arr[k];
                }
                if(maxSum < currentSum){
                    maxSum = currentSum;
                }
            }
        }
        System.out.println("maximum sum of sub array = "+ maxSum);
    }
}