public class main{
    public static void main(String args[]){
        Horse h = new Horse();
        h.eat();
        h.walk();
        System.out.println(h.color);
        h.changeColor();
        System.out.println(h.color);
        Mustang m = new Mustang();
        Chicken c = new Chicken();
        c.eat();
        c.walk();

        // Animal a = new Animal(); error: Animal is abstract; cannot be instantiated

    }
}

abstract class Animal{
    String color;
    Animal(){
         color = "brown";
         System.out.println("Animal constructor called");
    }
    void eat(){
        System.out.println("animal eats");
    }
    abstract void walk();
}
class Horse extends Animal{
    Horse(){
        System.out.println("horse constructor called");
    }
    void changeColor(){
        color = "dark Brown";
    }
    void  walk(){
         System.out.println("walks onn 4 legs");
    }
}
class Mustang extends Horse{
    Mustang(){
        System.out.println("Mustang construtor called");
    }
}
class Chicken extends Animal{
    void changeColor(){
        color = "white";
    }
    void  walk(){
         System.out.println("walks onn 2 legs");
    }
}