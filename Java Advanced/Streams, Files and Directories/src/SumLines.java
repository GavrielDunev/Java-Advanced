import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Dunev\\Documents\\Programming\\Java Advanced\\Streams, Files and Directories\\resources\\input.txt"));
        String line = reader.readLine();
        while (line != null) {
            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
            System.out.println(sum);
            line = reader.readLine();
        }
    }
}
