import java.util.*;

abstract class Payment {
    protected double amount;
    Payment(double amount) { this.amount = amount; }
    abstract double calculateFinalAmount();
    abstract String getType();
}

class CardPayment extends Payment {
    CardPayment(double a) { super(a); }
    double calculateFinalAmount() { return amount * 1.02; }
    String getType() { return "CARD"; }
}

class WalletPayment extends Payment {
    WalletPayment(double a) { super(a); }
    double calculateFinalAmount() { return amount * 1.01; }
    String getType() { return "WALLET"; }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double a) { super(a); }
    double calculateFinalAmount() { return amount; }
    String getType() { return "BANKTRANSFER"; }
}

public class PaymentFeeCalculator {
    static Payment create(String type, double amount) {
        switch (type.toUpperCase()) {
            case "CARD": return new CardPayment(amount);
            case "WALLET": return new WalletPayment(amount);
            default: return new BankTransferPayment(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            payments.add(create(p[0], Double.parseDouble(p[1])));
        }
        double total = 0;
        for (Payment p : payments) {
            double r = p.calculateFinalAmount();
            total += r;
            System.out.println(p.getType() + ": " + String.format(Locale.US, "%.2f", r));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
        sc.close();
    }
}