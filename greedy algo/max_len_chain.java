import java.util.*;
public class greeedy{
    public static void main(String args[]){
        int[][] chain = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        Arrays.sort(chain , Comparator.comparingDouble(o -> o[1]));
        int ans = 1;
        int lastSeclectedEnd = chain[0][1];
        for(int i = 1 ; i < chain.length ; i++){
            if(chain[i][0] > lastSeclectedEnd){
                ans++;
                lastSeclectedEnd = chain[i][1];
            }
        }
        System.out.println("final length of chain = " + ans);
     }
}