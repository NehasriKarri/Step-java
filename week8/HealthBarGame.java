class Character {
    private final int maxHealth;
    private int health;

    Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    void takeDamage(int amount) {
        if (amount < 0) return;
        health = Math.max(0, health - amount);
    }

    void heal(int amount) {
        if (amount < 0) return;
        health = Math.min(maxHealth, health + amount);
    }

    int getHealth() { return health; }
}

public class HealthBarGame {
    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("health = " + c.getHealth());
        c.heal(50);
        System.out.println("health = " + c.getHealth());
        c.takeDamage(150);
        System.out.println("health = " + c.getHealth());
    }
}
