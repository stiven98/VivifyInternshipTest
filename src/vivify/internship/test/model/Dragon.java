package vivify.internship.test.model;

public class Dragon extends Monster {

    private MonsterWeapon[] weapons  = {MonsterWeapon.KICK, MonsterWeapon.BLOW_FIRE};

    public Dragon() {
    }

    @Override
    public String toString() {
        return "Zmaj";
    }

    @Override
    public void attack(Player p){
        int idx = (int) Math.round(Math.random());
        MonsterWeapon w = weapons[idx];
        int playerHealts = p.getHealth();
        if(w == MonsterWeapon.KICK){
            playerHealts -= 5;
        }
        if(w ==MonsterWeapon.BLOW_FIRE){
            playerHealts -= 20;
        }
        p.setHealth(playerHealts);

    }

}
