import java.util.*;
public class jump{
    public static int findLowestStartingStair(int[] jumps) {
        int prefixSum = 0;
        int minPrefix = 0;

        for (int jump : jumps) {
            prefixSum += jump;
            minPrefix = Math.min(minPrefix, prefixSum);
        }

        // Need: start + minPrefix >= 1
        return Math.max(1, 1 - minPrefix);
    }
    public static void main(String args[]){
        int arr[] = {1,-4,-2,3};
        System.out.println(findLowestStartingStair(arr));
    }
}