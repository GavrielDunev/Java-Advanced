import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Dunev\\Documents\\Programming\\Java Advanced\\Streams, Files and Directories\\Files-and-Streams");

        ArrayDeque<File> queue = new ArrayDeque<>();

        queue.offer(file);

        int count = 0;

        while (!queue.isEmpty()) {
            File f = queue.poll();
            File[] files = f.listFiles();
            for (File currentFile : files) {
                if (currentFile.isDirectory()) {
                    queue.offer(currentFile);
                }
            }
            count++;
            System.out.println(f.getName());
        }
        System.out.printf("[%d] folders", count);
    }
}