import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Dunev\\Documents\\Programming\\Java Advanced\\Streams, Files and Directories\\resources\\inputLineNumbers.txt"));
        String line = reader.readLine();
        PrintWriter writer = new PrintWriter("output.txt");
        int row = 1;
        while (line != null) {
            writer.println(row++ + ". " + line);
            line = reader.readLine();
        }
        writer.close();
    }
}
