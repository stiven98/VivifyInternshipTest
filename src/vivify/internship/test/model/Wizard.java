package vivify.internship.test.model;

public class Wizard extends Hero {
    public Wizard() {
        super(100);
    }

    public Wizard(WeaponBag bag, Weapon activeWeapon) {
        super(100, bag, activeWeapon);
    }

    public Wizard(WeaponBag bag) {
        super(100, bag);
    }

    @Override
    public String toString() {
        return "Carobnjak";
    }

    @Override
    public void pickupWeapon(Weapon weapon) throws Exception {
        if(weapon.getType() != WeaponType.MAGIC){
            throw new Exception("Heroj ne moze pokupiti ovaj tip oruzja!");
        }
        super.pickupWeapon(weapon);
    }

    @Override
    public void attack(Monster m) {
        int monsterHealth = m.getHealth();
        if(this.getActiveWeapon() != null && this.getActiveWeapon().getType() == WeaponType.MAGIC){
            monsterHealth -= 20;
        }
        m.setHealth(monsterHealth);
    }
}
