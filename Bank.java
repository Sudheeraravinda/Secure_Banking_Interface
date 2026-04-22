import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public void createAccount(String accNo, String name, int pin) {
        Account acc = new Account(accNo, name, pin);
        accounts.put(accNo, acc);
        System.out.println("Account created successfully!");
    }

    public Account getAccount(String accNo) {
        return accounts.get(accNo);
    }
}
