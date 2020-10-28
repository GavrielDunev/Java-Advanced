import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        ArrayDeque<String> files = new ArrayDeque<>();

        while (!fileName.equals("print")) {
            if (fileName.equals("cancel")) {
                if (files.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + files.poll());
                }
            } else {
                files.offer(fileName);
            }

            fileName = scanner.nextLine();
        }

        while (!files.isEmpty()) {
            System.out.println(files.poll());
        }
    }
}
