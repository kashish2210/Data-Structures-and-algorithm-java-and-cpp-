import java.util.*;
public class greeedy{
    public static void main(String args[]){
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        int val = 10590;
        Arrays.sort(coins , Comparator.reverseOrder());
        int count = 0;
        ArrayList<Integer> lis = new ArrayList<>();
        for(int i = 0 ; i < coins.length ; i++){
            if(coins[i] <= val){
                while(coins[i] <= val){
                    count++;
                    lis.add(coins[i]);
                    val -= coins[i];
                }
            }
        }
        System.out.println("no. of coins paid = " + count);
        System.out.print("coins are = ");
        for(int i = 0 ; i < lis.size() ; i++){
            System.out.print(lis.get(i) +" ");
        }
     }
}