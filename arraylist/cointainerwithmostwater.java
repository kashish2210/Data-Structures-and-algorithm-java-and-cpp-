import java.util.*;
public class cointainerwithmostwater{
    public static int storewater(ArrayList<Integer> height){
        int max =  0;
        int lp = 0;
        int rp = height.size()-1;
        while(lp<rp){
            int ht = Math.min(height.get(lp),height.get(rp));
            int width = rp - lp;
            int curr = ht*width;
            max = Math.max(max, curr);
            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return max;
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(list);
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < list.size(); i++){
            for(int j = i ; j < list.size();j++){
                int width = j-i;
                int height = Math.min(list.get(j),list.get(i));
                int area = width*height;
                max = Math.max(area,max);
            }
        }
        System.out.println(max);
        System.out.println(storewater(list));
    }
}
