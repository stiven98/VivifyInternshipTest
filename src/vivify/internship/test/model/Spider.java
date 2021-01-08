package vivify.internship.test.model;

import java.util.logging.Logger;

public class Spider extends Monster {
    private MonsterWeapon[] weapons  = {MonsterWeapon.KICK, MonsterWeapon.BITE};

    public Spider() {
    }

    @Override
    public String toString() {
        return "Pauk";
    }

    @Override
    public void attack(Player p, Logger logger) {
        int idx = (int) Math.round(Math.random());
        MonsterWeapon w = weapons[idx];
        int playerHealts = p.getHealth();
        int damage = 0;
        if(w == MonsterWeapon.BITE){
            playerHealts -= 8;
            damage = 8;
        }
        if(w ==MonsterWeapon.KICK){
            playerHealts -= 5;
            damage = 5;
        }
        p.setHealth(playerHealts);
        logger.info(this.toString() + " je napao " + p.toString() + " pomocu "+ w.toString() + " steta: " + damage + " health");
    }
}
