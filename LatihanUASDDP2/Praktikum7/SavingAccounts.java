package LatihanUASDDP2.Praktikum7;

public class SavingAccounts extends Account implements Payable {
    private double interestRates;
    private double minimumBalance;

    public SavingAccounts(String name, String number, double Balance, double minimumBalance, double interestRate) {
        super(name, number, Balance);
        this.minimumBalance = minimumBalance; // ini ditentukan bank 
        this.interestRates = interestRate;
        System.out.print("a saving account is created");
    }

    public void processPayments(double amount) {
        // process paymentnya
        if (getBalance() - amount > minimumBalance) {
            System.out.printf("Transaction payment of %f is succesfull", amount);
            decrease(amount);
        } else if (amount > getBalance()) {
            System.out.printf("Transaction payment of %f is failed. is not sufficient", amount);
        } else if (getBalance() - amount < minimumBalance){
            System.out.printf("Transaction payment of %f is sucessfull. the minimum balanced is not achieved", amount);
        }
    }

    public void addInterest() {
        double interest = 1.0/12.0 * this.interestRates * getBalance();
        increase(interest);
    }


}
