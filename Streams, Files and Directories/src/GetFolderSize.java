import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Dunev\\Documents\\Programming\\Java Advanced\\Streams, Files and Directories\\resources\\Exercises Resources");

        long sum = 0;
        File[] files = file.listFiles();
        for (File currentFile : files) {
            sum += currentFile.length();
        }
        System.out.println("Folder size: " + sum);
    }
}
