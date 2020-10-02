import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path pathOne = Paths.get("C:\\Users\\Dunev\\Documents\\Programming\\Java Advanced\\Streams, Files and Directories\\resources\\inputOne.txt");
        Path pathTwo = Paths.get("C:\\Users\\Dunev\\Documents\\Programming\\Java Advanced\\Streams, Files and Directories\\resources\\inputTwo.txt");
        List<String> stringsOne = Files.readAllLines(pathOne);
        List<String> stringsTwo = Files.readAllLines(pathTwo);
        PrintWriter writer = new PrintWriter("thirdFile.txt");
        stringsOne.forEach(writer::println);
        stringsTwo.forEach(writer::println);
        writer.close();
    }
}
