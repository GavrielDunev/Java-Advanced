import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";
        FileInputStream in = new FileInputStream(path);
        FileOutputStream out = new FileOutputStream("03.CopyBytesOutput.txt");
        int nextByte = in.read();

        while (nextByte >= 0) {
            String currentByte = String.valueOf(nextByte);
            if (nextByte == ' ' || nextByte == '\n') {
                out.write(nextByte);
            } else {
                for (int i = 0; i < currentByte.length(); i++) {
                    out.write(currentByte.charAt(i));
                }
            }
            nextByte = in.read();
        }
    }
}
