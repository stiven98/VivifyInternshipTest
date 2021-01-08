package vivify.internship.test.model;

import java.util.logging.Logger;

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
    public void pickupWeapon(Weapon weapon, Logger logger) throws Exception {
        if(weapon.getType() != WeaponType.MAGIC){
            throw new Exception("Heroj ne moze pokupiti ovaj tip oruzja!");
        }
        super.pickupWeapon(weapon, logger);
    }

    @Override
    public void attack(Monster m, Logger logger) {
        int monsterHealth = m.getHealth();
        int damage = 0;
        if(this.getActiveWeapon() != null && this.getActiveWeapon().getType() == WeaponType.MAGIC){
            monsterHealth -= 20;
            damage = 20;
        }
        m.setHealth(monsterHealth);
        logger.info(this.toString() + " je napao " + m.toString() + " pomocu "+ getActiveWeapon().toString() + " steta: " + damage + " health");
    }
}
