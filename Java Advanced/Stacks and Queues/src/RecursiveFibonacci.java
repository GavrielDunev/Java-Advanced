import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n + 1];
        System.out.println(fib(n));
    }

    public static long fib(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memory[n] == 0) {
            memory[n] = fib(n - 1) + fib(n - 2);
        } else {
            return memory[n];
        }

        return fib(n - 1) + fib(n - 2);
    }
}
