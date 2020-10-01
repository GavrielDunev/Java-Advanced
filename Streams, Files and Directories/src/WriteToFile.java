import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("02.WriteToFileOutput.txt");
        Scanner scanner = new Scanner(inputStream);
        String symbols = ",.!?";
        while(scanner.hasNext()) {
            String line = scanner.nextLine();

            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                if (!symbols.contains(String.valueOf(currentChar))) {
                    outputStream.write(currentChar);
                }
            }
            outputStream.write('\n');
        }
    }
}
