package vivify.internship.test.model;

public class Spider extends Monster {
    private MonsterWeapon[] weapons  = {MonsterWeapon.KICK, MonsterWeapon.BITE};

    public Spider() {
    }

    @Override
    public String toString() {
        return "Pauk";
    }

    @Override
    public void attack(Player p) {
        int idx = (int) Math.round(Math.random());
        MonsterWeapon w = weapons[idx];
        int playerHealts = p.getHealth();
        if(w == MonsterWeapon.BITE){
            playerHealts -= 8;
        }
        if(w ==MonsterWeapon.KICK){
            playerHealts -= 5;
        }
        p.setHealth(playerHealts);
    }
}
