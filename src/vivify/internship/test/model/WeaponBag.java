package vivify.internship.test.model;

import java.util.ArrayList;
import java.util.List;

public class WeaponBag {

    private List<Weapon> weaponList;

    public WeaponBag() {
        this.weaponList = new ArrayList<Weapon>();
    }

    public WeaponBag(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) throws Exception {
        if(this.weaponList.size() > 2){
            throw new Exception("Pokusavate da dodate previse oruzja u ranac!");
        }
        this.weaponList = weaponList;
    }

    public boolean addWeapon(Weapon weapon) throws Exception {
        if(this.weaponList.size() == 2){
            throw new Exception("Nemoguce dodati oruzje! Vas ranac je pun!");
        }
        this.weaponList.add(weapon);
        return true;
    }

}
