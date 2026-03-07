public class inheritance{
    public static void main(String args[]){
        // Dog dobby= new Dog();
        // dobby.eat();
        // dobby.legs = 4;
        // System.out.println(dobby.legs);
        Animal animal = new Animal();
        animal.color = "White";
        animal.eat();
        animal.breathe();

        // Fish - Tuna
        Tuna tuna = new Tuna();
        tuna.color = "Blue";
        tuna.name = "Tuna Fish";
        tuna.eat();
        tuna.breathe();

        // Fish - Shark
        Shark shark = new Shark();
        shark.color = "Grey";
        shark.name = "Great White";
        shark.eat();
        shark.breathe();

        // Bird - Peacock
        Peacock peacock = new Peacock();
        peacock.color = "Green";
        peacock.name = "Indian Peacock";
        peacock.eat();
        peacock.breathe();

        // Mammal - Dog
        Dog dog = new Dog();
        dog.color = "Brown";
        dog.name = "Labrador";
        dog.eat();
        dog.breathe();

        // Mammal - Cat
        Cat cat = new Cat();
        cat.color = "Black";
        cat.name = "Persian";
        cat.eat();
        cat.breathe();

        // Mammal - Human
        Human human = new Human();
        human.color = "Peach";
        human.name = "John";
        human.eat();
        human.breathe();
    }
}

class Animal{
    String color;
    void eat(){
        System.out.println("eats");
    }
    void breathe(){
         System.out.println("breathes");
    }
}
// multilevel
// class Mammals extends Animal{
//     int legs;
// }
// class Dog extends Mammals{
//     String breed;
// }
// heririchal
// class Mammals extends Animal{
//     void walk(){
//          System.out.println("walks");
//     }
// }
// class birds extends Animal{
//     void fly(){
//          System.out.println("fly");
//     }
// }
// class Fish extends Animal{
//     void swim(){
//          System.out.println("swims");
//     }
// }
class Mammals extends Animal{
    String name;
}
class birds extends Animal{
    String name;
}
class fish extends Animal{
    String name;
}
class Tuna extends fish{
    String color;
}
class Shark extends fish{
    String color;
}
class Peacock extends birds{
    String color;
}
class Dog extends Mammals{
    String color;
}
class Cat extends Mammals{
    String color;
}
class Human extends Mammals{
    String color;
}

