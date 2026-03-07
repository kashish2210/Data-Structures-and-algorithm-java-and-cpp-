public class polymorphism{
    public static void main(String args[]){
        claculator calc = new claculator();
        System.out.println(calc.sum(1,2));
        System.out.println(calc.sum((float)1.5,(float)2.5));
        System.out.println(calc.sum(1,2,3));
        Deer d = new Deer();
        d.eat();
    }
}
// method overloading{compiled time}
class claculator{
    int sum(int a , int b){
        return a+b;
    }
    float sum(float a , float b){
        return a +b;
    }
    int sum(int a , int b , int c){
        return a + b + c;
    }
}
// method overriding(run time)
class Animal{
    void eat(){
        System.out.println("eat anyting");
    }
}
class Deer extends Animal{
    void eat(){
        System.out.println("eats grass");
    }
}