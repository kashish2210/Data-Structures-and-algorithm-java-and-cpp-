import java.util.*;

public class pairsum2 {

    public static boolean pairSum(int target, ArrayList<Integer> list) {

        int pivot = 0;

        for(int i = 1; i < list.size(); i++){
            if(list.get(i-1) > list.get(i)){
                pivot = i - 1;
                break;
            }
        }

        int lp = pivot + 1; // smallest
        int rp = pivot;     // largest

        while(lp != rp){

            int sum = list.get(lp) + list.get(rp);

            if(sum == target){
                return true;
            }

            if(sum < target){
                lp = (lp + 1) % list.size();
            } 
            else{
                rp = (list.size() + rp - 1) % list.size();
            }
        }

        return false;
    }

    public static void main(String args[]){

        ArrayList<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(list);

        System.out.println(pairSum(16, list));
    }
}