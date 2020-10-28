import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File file  = new File("C:\\Users\\Dunev\\Documents\\Programming\\Java Advanced\\Streams, Files and Directories\\Files-and-Streams");

        File[] files = file.listFiles();

        for (File currentFile : files) {
            if (!currentFile.isDirectory()) {
                System.out.printf("%s: [%d]%n", currentFile.getName(), currentFile.length());
            }
        }
    }
}
