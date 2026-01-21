import java.io.InputStream;

public class jvmBits {
    public static void main(String[] args) throws Exception {

        InputStream inputStream = System.in;

        System.out.println("Type something and press Enter:");

        byte[] data = inputStream.readNBytes(16);

        for (byte b : data) {
            System.out.printf("%8s ",
                Integer.toBinaryString(b & 0xFF).replace(' ', '0')
            );
        }
    }
}