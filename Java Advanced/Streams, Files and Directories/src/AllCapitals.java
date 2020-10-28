import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class AllCapitals {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("C:\\Users\\Dunev\\Documents\\Programming\\Java Advanced\\Streams, Files and Directories\\resources\\input.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        List<String> lines = reader.lines().collect(Collectors.toList());
        PrintWriter writer = new PrintWriter("output.txt");
        for (String line : lines) {
            String currentLine = line.toUpperCase();
            writer.println(currentLine);
        }
        writer.close();
    }
}
