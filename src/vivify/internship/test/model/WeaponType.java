package vivify.internship.test.model;

public enum WeaponType {
    SWORD{
        @Override
        public String toString() {
            return "Mac";
        }
    },
    SPEAR{
        @Override
        public String toString() {
            return "Koplje";
        }
    },
    MAGIC{
        @Override
        public String toString() {
            return "Carolija";
        }
    }
}
