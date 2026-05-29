package LatihanUASDDP2.Praktikum7;

public class Account {
    private String name;
    private String number;
    private double balance;

    public Account(String name, String number, double balance) {
        this.name= name;
        this.number = number;
        this.balance = balance;
    }

    public Account(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public double getBalance() {
        return this.balance;
    }

    public void decrease(double amount) {
        this.balance -= amount;
    }

    public void increase(double amount) {
        this.balance += amount;
    } 

    public void displayInfo() {
        System.out.print("\nNama Akun: " + getName() +
                           " | Nomor Akun: " + getNumber()  +
                           " | Balance Akun: " + getBalance() + "\n");
    }
}
