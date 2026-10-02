class Cart {
    private final String cartId;
    private final double[] prices;
    private int count = 0;

    Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
    }

    boolean addItem(double price) {
        if (count >= prices.length || price < 0) return false;
        prices[count++] = price;
        return true;
    }

    double getTotal() {
        double sum = 0;
        for (int i = 0; i < count; i++) sum += prices[i];
        return sum;
    }

    int getItemCount() { return count; }
    String getCartId() { return cartId; }
}

public class ShoppingCartApp {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Items: " + cart.getItemCount());
    }
}
