import java.io.*;

public class SerializeCustomObject {

    private static class Cube implements Serializable {
        String color;
        double width;
        double height;
        double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Cube cube = new Cube("green", 15.3, 12.4, 3.0);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.ser"));
            out.writeObject(cube);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("save.ser"));
            Cube readObject = (Cube) in.readObject();

            System.out.println(readObject.color);
            System.out.println(readObject.width);
            System.out.println(readObject.height);
            System.out.println(readObject.depth);

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
