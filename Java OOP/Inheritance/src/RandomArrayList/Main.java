package RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            randomArrayList.add(i + 1);
        }

        System.out.println(randomArrayList.getRandomElement());
    }
}
