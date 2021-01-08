package vivify.internship.test.model;

public abstract class Player {
    private int health;

    public Player() {
        this.health = 100;
    }

    public Player(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
