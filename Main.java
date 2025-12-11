class BankAccount {
    private String accNumber;
    private String accHolder;
    private double balance;

    BankAccount(String accNumber, String accHolder, double balance) {
        this.accNumber = accNumber;
        this.accHolder = accHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Not enough balance");
        }
    }

    public void showDetails() {
        System.out.println(accNumber + " | " + accHolder + " | Balance: " + balance);
    }
}

public class Main{
    public static void main(String[] args) {
        BankAccount a = new BankAccount("101", "Priyanka", 5000);
        a.deposit(500);
        a.withdraw(1000);
        a.showDetails();
    }
}
