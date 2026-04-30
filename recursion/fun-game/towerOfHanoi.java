import java.util.*;

public class TowerOfHanoi {

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    public static void printTowers(Map<String, List<Integer>> towers, int n) {
        clearConsole();
        System.out.println("Tower of Hanoi\n");

        for (int level = n - 1; level >= 0; level--) {
            for (String peg : new String[]{"A", "B", "C"}) {
                List<Integer> currentPeg = towers.get(peg);
                if (level < currentPeg.size()) {
                    int disk = currentPeg.get(level);
                    String diskStr = "=".repeat(disk);
                    System.out.printf("%" + n + "s|%-" + n + "s ", diskStr, diskStr);
                } else {
                    System.out.printf("%" + n + "s|%-" + n + "s ", "", "");
                }
            }
            System.out.println(); 
        }

        String base = "-".repeat(n * 2 + 1) + " ";
        System.out.println(base.repeat(3));
        
        String padding = " ".repeat(n);
        System.out.println(padding + "A" + padding + " " + 
                           padding + "B" + padding + " " + 
                           padding + "C" + padding + "\n");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void solveHanoi(int n, String source, String auxiliary, String target, 
                                  Map<String, List<Integer>> towers, int totalDisks) {
        if (n > 0) {
            solveHanoi(n - 1, source, target, auxiliary, towers, totalDisks);

            List<Integer> sourcePeg = towers.get(source);
            List<Integer> targetPeg = towers.get(target);
            int disk = sourcePeg.remove(sourcePeg.size() - 1);
            targetPeg.add(disk);
            
            printTowers(towers, totalDisks);

            solveHanoi(n - 1, auxiliary, source, target, towers, totalDisks);
        }
    }

    public static void main(String[] args) {
        int totalDisks = 4;

        Map<String, List<Integer>> towers = new HashMap<>();
        towers.put("A", new ArrayList<>());
        towers.put("B", new ArrayList<>());
        towers.put("C", new ArrayList<>());

        for (int i = totalDisks; i > 0; i--) {
            towers.get("A").add(i);
        }

        printTowers(towers, totalDisks);
        
        solveHanoi(totalDisks, "A", "B", "C", towers, totalDisks);
        
        System.out.println("Puzzle Solved!");
    }
}
