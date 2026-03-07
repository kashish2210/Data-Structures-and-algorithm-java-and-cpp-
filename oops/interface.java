public class main{
    public static void main(String args[]){
        // Queen q = new Queen();
        // Rook r = new Rook();
        // King k = new King();
        // q.moves();
        // r.moves();
        // k.moves();
        
        // kashish kh = new kashish();
        // kh.moves();
        Player p = new Player();
        p.move();
    }
}

interface ChessPlayer{
    void moves();
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up , down , left , right , digonal (in all direction)");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up , down , left , right");
    }
}
class King implements ChessPlayer{
    public void moves(){
        System.out.println("up , down , left , right (only one step)");
    }
}
class kashish implements ChessPlayer{
    public void moves(){
        System.out.println("I can move like Queen and Rook combined!");
    }
}
interface Move { void move(); }
interface Attack { void attack(); }
class Player implements Move, Attack {
    public void move() { System.out.println("move");}
    public void attack() { System.out.println("attack"); }
}