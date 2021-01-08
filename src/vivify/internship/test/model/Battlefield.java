package vivify.internship.test.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Battlefield {

    private static Battlefield instance;
    private Logger logger;

    private Battlefield(){
        logger = Logger.getLogger("BattleLogger");
        FileHandler fh;

        try {

            fh = new FileHandler("./BattleLog.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Logger getLogger() {
        return logger;
    }

    public static Battlefield getInstance(){
        if(instance == null){
            instance = new Battlefield();
        }
        return instance;
    }

    public void simulateWeaponPickUp(){
        Weapon w1 = new Weapon(WeaponType.SWORD);
        Weapon w2 = new Weapon(WeaponType.SPEAR);
        Weapon w22 = new Weapon(WeaponType.SPEAR);
        Weapon w23 = new Weapon(WeaponType.SPEAR);
        Weapon w3 = new Weapon(WeaponType.MAGIC);

        Swordsman swordsman = new Swordsman();

        try {
            swordsman.pickupWeapon(w1, logger);
            swordsman.pickupWeapon(w2, logger);
            swordsman.pickupWeapon(w22, logger);
            swordsman.pickupWeapon(w23, logger); //Expected exception bag is already full 1 active weapon and 2 weapons in the bag

        } catch (Exception e) {
            e.printStackTrace();
        }
        Weapon weaponToThrow = swordsman.getActiveWeapon();
        Swordsman swordsman2 = new Swordsman();
        Wizard wizard = new Wizard();

        try {
            swordsman.throwWeapon(weaponToThrow);
            swordsman2.pickupWeapon(weaponToThrow, logger);
            wizard.pickupWeapon(weaponToThrow, logger); // Expected exception not allowed type of weapon

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void simulateBattle(){
        Weapon w1 = new Weapon(WeaponType.SWORD);
        Weapon w2 = new Weapon(WeaponType.SPEAR);
        Swordsman swordsman = new Swordsman();
        try {
            swordsman.pickupWeapon(w1, logger);
            swordsman.pickupWeapon(w2, logger);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Dragon dragon = new Dragon();

        while(swordsman.getHealth() > 0 && dragon.getHealth() > 0){
            try {
                swordsman.changeWeapon();
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                double attack = 100.0  * Math.random();
                if(attack < 50){
                    swordsman.attack(dragon, logger);
                }else{
                    dragon.attack(swordsman, logger);
                }
            }
        }
        if(swordsman.getHealth() > 0){
            logger.info(swordsman.toString() + " je pobedio u duelu sa " + dragon.toString());
        }
        else{
            logger.info(dragon.toString() + " je pobedio u duelu sa " + swordsman.toString());
        }
    }


}
