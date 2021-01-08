package vivify.internship.test.model;

import java.util.logging.Logger;

public abstract class Hero extends Player{
    private WeaponBag bag;
    private Weapon activeWeapon;

    public Hero(int health) {
        super(health);
        this.activeWeapon = null;
        this.bag = new WeaponBag();
    }

    public Hero(int health, WeaponBag bag) {
        super(health);
        this.bag = bag;
    }

    public Hero(int health, WeaponBag bag, Weapon activeWeapon) {
        super(health);
        this.bag = bag;
        this.activeWeapon = activeWeapon;
    }

    public WeaponBag getBag() {
        return bag;
    }

    public void setBag(WeaponBag bag) {
        this.bag = bag;
    }

    public Weapon getActiveWeapon() {
        return activeWeapon;
    }

    public void changeWeapon() throws Exception {
        if(bag.getWeaponList().size() > 0) {
            if (activeWeapon == null) {
                this.activeWeapon = bag.getWeaponList().get(0);
                bag.getWeaponList().remove(activeWeapon);
            }
            else {
                for (Weapon w : bag.getWeaponList()) {
                    if (activeWeapon != w) {
                        bag.getWeaponList().add(activeWeapon);
                        activeWeapon = w;
                        bag.getWeaponList().remove(w);
                        break;
                    }
                }
            }
        }
        else {
            throw new Exception("Torba je prazna!");
        }
    }

    public void throwWeapon(Weapon weapon) throws Exception {
        bag.getWeaponList().remove(weapon);
        activeWeapon = null;
        changeWeapon();
    }

    public void pickupWeapon(Weapon weapon) throws Exception {
        bag.getWeaponList().add(weapon);
        if(activeWeapon == null){
            activeWeapon = weapon;
            bag.getWeaponList().remove(weapon);
        }
    }

    public abstract void attack(Monster m, Logger logger);

}
