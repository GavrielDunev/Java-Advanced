import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        List<BankAccount> accounts = new ArrayList<>();
        BankAccount bankAccount;

        while (!input[0].equals("End")) {
            switch (input[0]) {
                case "Create":
                    accounts.add(new BankAccount());
                    System.out.printf("Account ID%d created%n", accounts.size());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(input[1]);
                    double amount = Double.parseDouble(input[2]);
                    if (accounts.size() - id < 0) {
                        System.out.println("Account does not exist");
                    } else {
                        bankAccount = accounts.get(id - 1);
                        bankAccount.deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(input[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(input[1]);
                    int years = Integer.parseInt(input[2]);
                    if (accounts.size() - id < 0) {
                        System.out.println("Account does not exist");
                    } else {
                        bankAccount = accounts.get(id - 1);
                        System.out.printf("%.2f%n", bankAccount.getInterestRate(years));
                    }
                    break;
            }

            input = scanner.nextLine().split("\\s+");
        }

    }
}
