package vivify.internship.test.model;

public enum MonsterWeapon {
    KICK{
        @Override
        public String toString() {
            return "Udarac";
        }
    },
    BITE{
        @Override
        public String toString() {
            return "Ujed";
        }
    },
    BLOW_FIRE{
        @Override
        public String toString() {
            return "Bljuvanje vatre";
        }
    }
}
