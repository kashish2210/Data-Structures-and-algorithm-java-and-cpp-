import java.util.*;
public class swap{
    public static void swap(ArrayList<Integer> list ,int i , int j){
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j, temp);
    }
    public static void main(String args[]){
        // ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for(int i = 1 ; i <=5 ; i++){
            list.add(1*i);
            list2.add(2*i);
            list3.add(3*i);
        }
        mainlist.add(list);
        mainlist.add(list2);
        mainlist.add(list3);
        System.out.println(mainlist);
        for(int i = 0 ; i <mainlist.size();i++){
            ArrayList<Integer> curr = mainlist.get(i);
            for(int j = 0 ; j <curr.size() ; j++){
                System.out.print(curr.get(j)+ " ");
            }
            System.out.println();
        }
       
    }
}
