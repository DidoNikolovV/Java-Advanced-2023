package rpg_lab.fakeImplementations;

import rpg_lab.Target;

public class FakeTarget implements Target {

    @Override
    public void takeAttack(int attackPoints) {

    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public int giveExperience() {
        return 0;
    }

    @Override
    public boolean isDead() {
        return false;
    }
}
