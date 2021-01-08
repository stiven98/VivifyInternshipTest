package vivify.internship.test.model;

import java.util.logging.Logger;

public abstract class Monster extends Player {
    public abstract void attack(Player p, Logger logger);
}
