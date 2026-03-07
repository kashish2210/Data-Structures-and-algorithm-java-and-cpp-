public class Opp{

    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setColor("BLue");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());
        BankAccount my = new BankAccount();
        my.username = "kashish";
        // my.password = "1234";//not works
        my.setPassword("1234");//works
        System.out.println(my.username);
        // System.out.println(my.password); not works

    }
}
class BankAccount{
    public String username;
    private String password;
    public void setPassword(String pwd){
        password = pwd;
    }
}
class Pen{
    private String color;
    private int tip;
    String getColor(){
        return this.color;
    }
    int getTip(){
        return this.tip;
    }
    void setColor(String newColor){
        this.color = newColor;
    }
    void setTip(int newTip){
        this.tip = newTip;
    }

}
class Student{
    String name;
    int age;
    float percentage;
    void calcper(int phy , int math , int chem){
        percentage = (phy + math + chem)/3;
    }
}

