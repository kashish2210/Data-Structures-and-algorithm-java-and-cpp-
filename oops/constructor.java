public class constructor{

    public static void main(String[] args) {
        // Pen p1 = new Pen();
        // p1.setColor("BLue");
        // System.out.println(p1.getColor());
        // p1.setTip(5);
        // System.out.println(p1.getTip());
        // BankAccount my = new BankAccount();
        // my.username = "kashish";
        // // my.password = "1234";//not works
        // my.setPassword("1234");//works
        // System.out.println(my.username);
        // System.out.println(my.password); not works
        Student s1 = new Student();
        s1.name = "kashish";
        s1.roll = 12;
        s1.percentage = 89;
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;
        Student s2 = new Student(s1);
        s1.marks[2] = 40;
        for(int i = 0 ; i <3 ;i++){
            System.out.println(s2.marks[i]);
        }



    }
}
class Student{
    String name;
    int roll;
    float percentage;
    int marks[];
    
    // Base constructor - initializes marks (all others will chain to this)
    Student(){
        this.marks = new int[3];
        System.out.println("yeaaaaaaa........");
    }
    
    // Constructor chaining with name
    Student(String name){
        this();  // calls Student() constructor
        this.name = name;
    }
    
    // Constructor chaining with roll
    Student(int roll){
        this();  // calls Student() constructor
        this.roll = roll;
    }
    
    // Copy constructor (deep copy)
    Student(Student s1){
        this();  // calls Student() constructor to initialize marks
        this.name = s1.name;
        this.roll = s1.roll;
        for(int i = 0 ; i < marks.length ; i++){
            this.marks[i] = s1.marks[i];
        }
    }
}

