public class comple{
    public static void main(String[] args) {
        complex c = new complex();
        System.out.println(c.multi(2,3));
        System.out.println(c.sum(2,3));
        System.out.println(c.devide(12,4));
    }
}
class complex{
    public int ans;
    public static int multi(int a  , int b){
        return a*b;
    }
    public static int sum(int a  , int b){
        return a+b;
    }
    public static int devide(int a  , int b){
        return a/b;
    }
}
