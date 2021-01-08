package vivify.internship.test.model;

public class Swordsman extends Hero {
    public Swordsman() {
        super(150);
    }

    public Swordsman(WeaponBag bag) {
        super(150, bag);
    }

    public Swordsman(WeaponBag bag, Weapon activeWeapon) {
        super(150, bag, activeWeapon);
    }

    @Override
    public void attack(Monster m) {
        int monsterHealth = m.getHealth();
        if(this.getActiveWeapon() != null){
            if(this.getActiveWeapon().getType() == WeaponType.SWORD)
                monsterHealth -= 10;
            if(this.getActiveWeapon().getType() == WeaponType.SPEAR)
                monsterHealth -= 15;
        }
        m.setHealth(monsterHealth);
    }

    @Override
    public String toString() {
        return "Macevalac";
    }

    @Override
    public void pickupWeapon(Weapon weapon) throws Exception {
        if(weapon.getType() == WeaponType.MAGIC){
            throw new Exception("Heroj ne moze pokupiti ovaj tip oruzja!");
        }
        super.pickupWeapon(weapon);
    }
}
