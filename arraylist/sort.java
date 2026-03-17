import java.util.*;
public class swap{
    public static void swap(ArrayList<Integer> list ,int i , int j){
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j, temp);
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        System.out.println(list);
        Collections.sort(list);//ascending
        System.out.println(list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
    }
}
