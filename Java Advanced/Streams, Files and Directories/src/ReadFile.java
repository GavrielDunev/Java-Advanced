import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Dunev\\Documents\\Programming\\Java Advanced\\Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        InputStream in = new FileInputStream(path);
        int nextByte = in.read();
        while (nextByte != -1) {
            System.out.printf("%s ", Integer.toBinaryString(nextByte));
            nextByte = in.read();
        }
    }
}
