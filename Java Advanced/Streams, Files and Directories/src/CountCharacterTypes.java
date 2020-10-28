import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class CountCharacterTypes {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("C:\\Users\\Dunev\\Documents\\Programming\\Java Advanced\\Streams, Files and Directories\\resources\\input.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        String vowels = "aeoui";
        String punctuationMarks = ".?!,";
        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuationMarks = 0;
        PrintWriter writer = new PrintWriter("output.txt");
        List<String> lines = reader.lines().collect(Collectors.toList());
        for (String line : lines) {
            for (char currentChar : line.toCharArray()) {
                if (currentChar == ' ') {
                    continue;
                }
                if (vowels.contains(String.valueOf(currentChar))) {
                    countVowels++;
                } else if (punctuationMarks.contains(String.valueOf(currentChar))) {
                    countPunctuationMarks++;
                } else {
                    countConsonants++;
                }
            }
        }
        writer.println("Vowels: " + countVowels);
        writer.println("Consonants: " + countConsonants);
        writer.println("Punctuation: " + countPunctuationMarks);
        writer.close();
    }
}
