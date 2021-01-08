package vivify.internship.test.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Battlefield {

    private static Battlefield instance;
    private List<Player> players;
    private List<Weapon> freeWeapon;
    private Logger logger;

    private Battlefield(){
        players = new ArrayList<Player>();
        freeWeapon = new ArrayList<Weapon>();
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

    public List<Weapon> getFreeWeapon() {
        return freeWeapon;
    }

    public void setFreeWeapon(List<Weapon> freeWeapon) {
        this.freeWeapon = freeWeapon;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


}
