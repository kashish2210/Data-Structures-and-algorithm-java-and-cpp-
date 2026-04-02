import java.util.*;
public class greeedy{
    public static void main(String args[]){
        int[] arr1 = {1,3,0,5,8,5};
        int[] arr2 = {2,4,6,7,9,9};
        int activites[][] = new int[arr1.length][3];
        for(int i = 0 ; i < arr1.length ; i++){
            activites[i][0] = i;
            activites[i][1] = arr1[i];
            activites[i][2] = arr2[i];
        }
        Arrays.sort(activites , Comparator.comparingDouble(o -> o[2]));
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        maxAct = 1;
        ans.add(activites[0][0]);
        int lastEnd = activites[0][2];
        for(int i = 0 ; i < activites.length ; i++){
            if(activites[i][1] >= lastEnd){
                maxAct++;
                ans.add(i);
                lastEnd = activites[i][2];
            }
        }
        System.out.println("max activites u can perform is " + maxAct);
        for(int num : ans){
            System.out.print("A" +num +" ");
        }
     }
}