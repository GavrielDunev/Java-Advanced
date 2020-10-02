import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Dunev\\Documents\\Programming\\Java Advanced\\Streams, Files and Directories\\resources\\words.txt");
        BufferedReader readerOne = new BufferedReader(fileReader);
        String line = readerOne.readLine();
        Map<String, Integer> words = new HashMap<>();

        for (String currentWord : line.split("\\s+")) {
            words.put(currentWord, 0);
        }

        BufferedReader readerTwo = new BufferedReader(new FileReader("C:\\Users\\Dunev\\Documents\\Programming\\Java Advanced\\Streams, Files and Directories\\resources\\text.txt"));
        List<String> lines = readerTwo.lines().collect(Collectors.toList());
        PrintWriter writer = new PrintWriter("results.txt");
        lines.forEach(l -> {
            String[] lineWords = l.split("[. ,]");
            for (String lineWord : lineWords) {
                if (words.containsKey(lineWord)) {
                    words.put(lineWord, words.get(lineWord) + 1);
                }
            }
        });
        words.entrySet().stream().sorted((w1,w2) -> w2.getValue().compareTo(w1.getValue()))
                .forEach(e -> {
                    writer.println(e.getKey() + " - " + e.getValue());
                });
        writer.close();
    }
}
