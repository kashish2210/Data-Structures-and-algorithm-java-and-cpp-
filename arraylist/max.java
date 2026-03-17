import java.util.*;
public class max{
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for(int i = 0 ; i< list.size();i++){
            max=Math.max(list.get(i), max);
        }
        System.out.println(max);
    }
}
