class TrafficLight {
    private static final String[] COLORS = {"RED", "GREEN", "YELLOW"};
    private final String id;
    private int index = 0;

    TrafficLight(String id) {
        this.id = id;
    }

    String next() {
        index = (index + 1) % COLORS.length;
        return COLORS[index];
    }

    String getColor() { return COLORS[index]; }
    String getId() { return id; }
}

public class TrafficLightApp {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
    }
}
