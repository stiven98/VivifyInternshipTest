package vivify.internship.test.model;

public class Weapon {
    private WeaponType type;

    public Weapon() {
    }

    @Override
    public String toString() {
        return type.toString();
    }

    public Weapon(WeaponType type) {
        this.type = type;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }
}
