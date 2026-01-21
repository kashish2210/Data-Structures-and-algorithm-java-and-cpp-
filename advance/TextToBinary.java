import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TextToBinary {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);

        System.out.println("Binary output:");

        for (byte b : bytes) {
            System.out.print(
                String.format("%8s",
                    Integer.toBinaryString(b & 0xFF)
                ).replace(' ', '0') + " "
            );
        }

        sc.close();
    }
}
