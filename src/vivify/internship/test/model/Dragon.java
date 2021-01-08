package vivify.internship.test.model;

import java.util.logging.Logger;

public class Dragon extends Monster {

    private MonsterWeapon[] weapons  = {MonsterWeapon.KICK, MonsterWeapon.BLOW_FIRE};

    public Dragon() {
    }

    @Override
    public String toString() {
        return "Zmaj";
    }

    @Override
    public void attack(Player p, Logger logger){
        int idx = (int) Math.round(Math.random());
        MonsterWeapon w = weapons[idx];
        int playerHealts = p.getHealth();
        int damage = 0;
        if(w == MonsterWeapon.KICK){
            playerHealts -= 5;
            damage = 5;
        }
        if(w ==MonsterWeapon.BLOW_FIRE){
            playerHealts -= 20;
            damage = 20;
        }
        p.setHealth(playerHealts);
        logger.info(this.toString() + " je napao " + p.toString() + " pomocu "+ w.toString() + " steta: " + damage + " health");
    }

}
