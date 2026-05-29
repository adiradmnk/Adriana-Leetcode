package LatihanUASDDP2.Praktikum7;

public class LibrarySystem {
    public static void main(String[] args) {
        SavingAccounts sa = new SavingAccounts("Ari Wibowo", "SA001", 5000000.0, 1000000.0, 0.05);
        sa.displayInfo();
        System.out.println();
        sa.processPayments(6000000);
        sa.displayInfo();
        System.out.println();
        sa.processPayments(4500000);
        sa.displayInfo();
        System.out.println();
        sa.processPayments(2000000);
        sa.displayInfo();
        System.out.println();
        sa.addInterest();
        sa.displayInfo();
    }
}