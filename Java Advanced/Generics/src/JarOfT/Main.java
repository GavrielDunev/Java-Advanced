package JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<String> jarOne = new Jar<>();
        Jar<Integer> jarTwo = new Jar<>();

        jarOne.add("Word");
        jarTwo.add(7);
        System.out.println(jarOne.remove());
        System.out.println(jarTwo.remove());
    }
}