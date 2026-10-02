import java.util.*;

abstract class Delivery {
    protected double weight, distance;
    Delivery(double w, double d) { weight = w; distance = d; }
    abstract double calculateFee();
    abstract String getType();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double w, double d) { super(w, d); }
    double calculateFee() { return 5 + 0.50 * weight + 0.10 * distance; }
    String getType() { return "STANDARD"; }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double w, double d) { super(w, d); }
    double calculateFee() { return 15 + 1.00 * weight + 0.20 * distance; }
    String getType() { return "EXPRESS"; }
}

class InternationalDelivery extends Delivery {
    private double customsFee;
    InternationalDelivery(double w, double d, double c) { super(w, d); customsFee = c; }
    double calculateFee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
    String getType() { return "INTERNATIONAL"; }
}

public class DeliveryFeeCalculator {
    static Delivery create(String[] p) {
        double w = Double.parseDouble(p[1]);
        double d = Double.parseDouble(p[2]);
        switch (p[0].toUpperCase()) {
            case "STANDARD": return new StandardDelivery(w, d);
            case "EXPRESS": return new ExpressDelivery(w, d);
            default: return new InternationalDelivery(w, d, Double.parseDouble(p[3]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Delivery> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(create(sc.nextLine().trim().split("\\s+")));
        }
        double total = 0;
        for (Delivery d : list) {
            double fee = d.calculateFee();
            total += fee;
            System.out.println(d.getType() + ": " + String.format(Locale.US, "%.2f", fee));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
        sc.close();
    }
}