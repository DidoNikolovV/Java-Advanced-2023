package rpg_lab.fakeImplementations;

import rpg_lab.Target;
import rpg_lab.Weapon;

public class FakeWeapon implements Weapon {
    @Override
    public void attack(Target target) {

    }

    @Override
    public int getAttackPoints() {
        return 0;
    }

    @Override
    public int getDurabilityPoints() {
        return 0;
    }
}
