import java.util.*;

abstract class Transport {
    protected double distance;
    Transport(double d) { distance = d; }
    abstract double calculateFare();
    abstract String getType();
}

class Bus extends Transport {
    Bus(double d) { super(d); }
    double calculateFare() { return Math.min(2 + 0.10 * distance, 10); }
    String getType() { return "BUS"; }
}

class Train extends Transport {
    Train(double d) { super(d); }
    double calculateFare() { return 3 + 0.15 * distance; }
    String getType() { return "TRAIN"; }
}

class Metro extends Transport {
    private double peakFactor;
    Metro(double d, double f) { super(d); peakFactor = f; }
    double calculateFare() { return (1.50 + 0.20 * distance) * peakFactor; }
    String getType() { return "METRO"; }
}

public class TransportFareCalculator {
    static Transport create(String[] p) {
        double d = Double.parseDouble(p[1]);
        switch (p[0].toUpperCase()) {
            case "BUS": return new Bus(d);
            case "TRAIN": return new Train(d);
            default: return new Metro(d, Double.parseDouble(p[2]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Transport> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(create(sc.nextLine().trim().split("\\s+")));
        }
        double total = 0;
        for (Transport t : list) {
            double f = t.calculateFare();
            total += f;
            System.out.println(t.getType() + ": " + String.format(Locale.US, "%.2f", f));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
        sc.close();
    }
}