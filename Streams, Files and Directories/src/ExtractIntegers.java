import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);
        PrintWriter printWriter = new PrintWriter("04.ExtractIntegersOutput.txt");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                printWriter.println(number);
            }
            scanner.next();
        }
        printWriter.close();
    }
}
