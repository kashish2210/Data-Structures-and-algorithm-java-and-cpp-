import java.io.InputStream;

public class jvmBits {
    public static int sign(int v){
        int sign = (v > 0) ? 1 : (v < 0 ? -1 : 0);
        return sign;
    }
    public static int absolute(int v){
        int mask = v >> 31;  // 0 if v >= 0, -1 if v < 0
        int r = (v + mask) ^ mask;
        return r;
    }
    public static int max(int x , int y){
        int mask = (x < y) ? -1 : 0;
        int r = x ^ ((x ^ y) & mask); // max(x, y)
        return r;
    }
    public static int min(int x , int y){
        int mask = (x < y) ? -1 : 0;
        int r = y ^ ((x ^ y) & mask); // min(x, y)
        return r;
    }
    public static boolean powerof2(int n){
        boolean isPowerOfTwo = (n > 0) && ((n & (n - 1)) == 0);
        return isPowerOfTwo;
    }
   public static void main(String[] args) throws Exception {
        int v =-19;
        int x = 12 ;
        int y = 29;
        System.out.println(sign(v));
        System.out.println(absolute(v));
        System.out.println(max(x,y));
        System.out.println(min(x,y));
        System.out.println(powerof2(v));
    }
} 