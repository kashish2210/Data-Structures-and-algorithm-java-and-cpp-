import java.util.*;
public class pairsum{
    public static boolean pairSum(int target ,ArrayList<Integer> list){
        int lp = 0 ;
        int rp = list.size()-1;
        while(lp < rp){
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            if(list.get(lp)+list.get(rp)<target){
                lp++;
            }else{
                rp--;
            }
        }
        return false;
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
        System.out.println(pairSum(8,list));

    }
}
