import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path inPath = Paths.get("input.txt");
        Path outPath = Paths.get("06.SortLinesOutput.txt");

        List<String> lines = Files.readAllLines(inPath);
        Collections.sort(lines);

        Files.write(outPath, lines);

    }
}
