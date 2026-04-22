import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("=== Secure Banking Interface ===");

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNo = sc.next();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Set 4-digit PIN: ");
                    int pin = sc.nextInt();

                    bank.createAccount(accNo, name, pin);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.next();

                    Account acc = bank.getAccount(accNo);
                    if (acc == null) {
                        System.out.println("Account not found!");
                        break;
                    }

                    System.out.print("Enter PIN: ");
                    pin = sc.nextInt();

                    if (!acc.authenticate(pin)) {
                        System.out.println("Invalid PIN!");
                        break;
                    }

                    System.out.println("Login Successful!");

                    while (true) {
                        System.out.println("\n1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Balance");
                        System.out.println("4. Transactions");
                        System.out.println("5. Logout");
                        System.out.print("Choose option: ");
                        int opt = sc.nextInt();

                        if (opt == 5) break;

                        switch (opt) {
                            case 1:
                                System.out.print("Enter amount: ");
                                acc.deposit(sc.nextDouble());
                                break;

                            case 2:
                                System.out.print("Enter amount: ");
                                acc.withdraw(sc.nextDouble());
                                break;

                            case 3:
                                acc.showBalance();
                                break;

                            case 4:
                                acc.showTransactions();
                                break;

                            default:
                                System.out.println("Invalid option!");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
